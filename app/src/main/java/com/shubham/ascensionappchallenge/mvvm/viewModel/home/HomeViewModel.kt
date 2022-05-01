package com.shubham.ascensionappchallenge.mvvm.viewModel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shubham.ascensionappchallenge.model.data.HomeDataModel
import com.shubham.ascensionappchallenge.mvvm.repository.home.HomeRepositoryImpl
import com.shubham.ascensionappchallenge.mvvm.viewModel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepositoryImpl: HomeRepositoryImpl) :
    BaseViewModel() {

    lateinit var searchMutableLiveData: MutableLiveData<MutableList<HomeDataModel>>
    private var finishPaginationLiveData: MutableLiveData<Boolean> = MutableLiveData()
    private var toolbarTitleLiveData: MutableLiveData<Boolean> = MutableLiveData()
    var paginationLoaderLiveData: MutableLiveData<Boolean> = MutableLiveData()
    private var searchList = mutableListOf<HomeDataModel>()
    private var databaseList = mutableListOf<HomeDataModel>()
    private var page = 0
    private var isFetching = false
    private var queryText = ""
    var isWatchListMode = false

    fun getSearchList(): LiveData<MutableList<HomeDataModel>> {
        if (!::searchMutableLiveData.isInitialized) {
            searchMutableLiveData = MutableLiveData()
            fetchSearchResult()
        }
        return searchMutableLiveData
    }

    fun getPaginationStatus(): LiveData<Boolean> {
        return finishPaginationLiveData
    }

    fun getToolbarTitle(): LiveData<Boolean> {
        return toolbarTitleLiveData
    }

    fun getPaginationLoader(): LiveData<Boolean> {
        return paginationLoaderLiveData
    }

    fun readWatchListFromDatabase() {
        uiScope.launch {
            val response = withContext(bgDispatcher) { homeRepositoryImpl.getWatchList() }
            response.data?.let {
                databaseList = it.toMutableList()
                if (isWatchListMode && it.isNotEmpty()) {
                    searchMutableLiveData.value = databaseList
                } else {
                    isWatchListMode = false
                    searchMutableLiveData.value = searchList
                }
            } ?: response.throwable?.let {
                Timber.e(it.toString())
                isWatchListMode = false
                searchMutableLiveData.value = searchList
            } ?: run {
                isWatchListMode = false
                searchMutableLiveData.value = searchList
            }
        }
    }

    fun fetchSearchResult() {
        if (isFetching() || queryText.isEmpty() || isWatchListMode) {
            return
        }
        setFetching(true)

        uiScope.launch {
            if (page == 0) {
                loadingLiveData.value = true
            }
            page++

            homeRepositoryImpl.onRetrieveSearchResult(queryText, page).collect { response ->

                response.data?.let {
                    emptyLiveData.value = false
                    finishPaginationLiveData.value = isPaginationFinished(
                        it.firstOrNull()?.page
                            ?: 0, it.firstOrNull()?.totalPage ?: 0
                    )
                    searchList.addAll(it)
                    searchMutableLiveData.value = searchList
                } ?: run {
                    Timber.e(response.throwable.toString())
                    onErrorThrowable(response.throwable)
                    finishPaginationLiveData.value = true
                }
                paginationLoaderLiveData.value = false
                loadingLiveData.value = false
                setFetching(false)
            }
        }
    }

    @Synchronized
    private fun isFetching(): Boolean {
        return this.isFetching
    }

    @Synchronized
    private fun setFetching(isFetching: Boolean) {
        this.isFetching = isFetching
    }

    private fun resetPagination() {
        if (queryText.isEmpty()) {
            return
        }
        page = 0
        searchList.clear()
    }

    fun setQueryText(queryText: String) {
        this.queryText = queryText
    }

    private fun isPaginationFinished(page: Int, totalPages: Int): Boolean {
        return page >= totalPages
    }

    fun updateModel(updatedHomeDataModel: HomeDataModel?) {
        if (updatedHomeDataModel?.id == null) {
            return
        }
        searchList.map {
            return@map when (it.id) {
                updatedHomeDataModel.id -> it.isFavorite = updatedHomeDataModel.isFavorite
                else -> it
            }
        }
    }

    fun searchForResults() {
        if (isWatchListMode) {
            filterListByQuery()
            return
        }
        fetchSearchResult()
        resetPagination()
    }

    private fun filterListByQuery() {
        if (queryText.isEmpty()) {
            searchMutableLiveData.value = databaseList
            return
        }
        val queryList = databaseList.filter {
            it.title?.lowercase(Locale.getDefault())
                ?.contains(queryText.lowercase(Locale.getDefault()), true)
                ?: false
        }
        searchMutableLiveData.value = queryList.toMutableList()
    }
}