package com.shubham.ascensionappchallenge.mvvm.viewModel.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shubham.ascensionappchallenge.model.data.HomeDataModel
import com.shubham.ascensionappchallenge.mvvm.repository.details.DetailsRepositoryImpl
import com.shubham.ascensionappchallenge.mvvm.viewModel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val detailsRepositoryImpl: DetailsRepositoryImpl) : BaseViewModel() {

    var homeDataModel: HomeDataModel? = null
    var homeDataModelLiveData: MutableLiveData<HomeDataModel> = MutableLiveData()
    var isFavouriteLiveData: MutableLiveData<Boolean> = MutableLiveData()
    var hasUserChangeFavourite: Boolean? = false

    fun getDetailsList(): LiveData<HomeDataModel> {
            homeDataModelLiveData = MutableLiveData()
            fetchDetails()

        return homeDataModelLiveData
    }

    fun getFavourite(): LiveData<Boolean> {
        return isFavouriteLiveData
    }

     fun fetchDetails() {
        if (homeDataModel == null ||
                homeDataModel?.id == null ||
                homeDataModel?.mediaType == null) {
            return
        }

        uiScope.launch {
            loadingLiveData.value = true
            val response = detailsRepositoryImpl.onRetrieveDetails(homeDataModel!!)
            response.data?.let {
                homeDataModelLiveData.value = it
            } ?: response.throwable?.let {
                Timber.e(it.toString())
                onErrorThrowable(it, true)
            } ?: run {
                genericErrorLiveData.value = true
            }
            loadingLiveData.value = false
        }
    }

    fun toggleFavourite() {
        if (homeDataModel == null) {
            return
        }
        hasUserChangeFavourite = true
        val homeModel = homeDataModel
        homeModel?.isFavorite = homeModel?.isFavorite == false
        uiScope.launch {
            loadingLiveData.value = true
            val response = withContext(bgDispatcher) { detailsRepositoryImpl.updateFavourite(homeModel) }
            homeDataModel = response.data
            homeDataModel?.let {
                isFavouriteLiveData.value = it.isFavorite
            } ?: response.throwable?.let {
                Timber.e(it.toString())
                genericErrorLiveData.value = true
            } ?: run {
                genericErrorLiveData.value = true
            }
            loadingLiveData.value = false
        }
    }

    fun setUIModel(homeDataModel: HomeDataModel?) {
        this.homeDataModel = homeDataModel
    }
}