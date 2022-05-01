package com.shubham.ascensionappchallenge.mvvm.viewModel.details

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.shubham.ascensionappchallenge.common.Constants
import com.shubham.ascensionappchallenge.model.common.DataResult
import com.shubham.ascensionappchallenge.model.data.HomeDataModel
import com.shubham.ascensionappchallenge.model.responses.movie.MovieResponse
import com.shubham.ascensionappchallenge.mvvm.repository.details.DetailsRepository
import com.shubham.ascensionappchallenge.mvvm.repository.details.DetailsRepositoryImpl
import com.shubham.ascensionappchallenge.networks.MovieClient
import com.shubham.ascensionappchallenge.networks.MovieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.verify
import retrofit2.Response
import java.util.*


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DetailsViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var detailsRepository: DetailsRepository

    @Mock
    lateinit var detailsRepositoryImpl: DetailsRepositoryImpl

    @Mock
    lateinit var detailsObserver: Observer<HomeDataModel>

    @Test
    fun getDetailsListSuccessTest() {
        runBlockingTest {

            val sampleResult = Response.success(Gson().fromJson(Constants.MOVIE_RESPONSE, MovieResponse::class.java))

            doReturn(sampleResult).`when`(detailsRepository).onRetrieveDetails(HomeDataModel(movieId))

            val viewModel = DetailsViewModel(detailsRepositoryImpl)

            viewModel.homeDataModelLiveData.observeForever(detailsObserver)

            viewModel.getDetailsList()

            verify{viewModel.getDetailsList()}

            val originalResult = Gson().fromJson(Constants.MOVIE_RESPONSE, HomeDataModel::class.java)

            verify(detailsRepository).onRetrieveDetails(HomeDataModel())

            verify(detailsObserver.onChanged(originalResult))

            viewModel.homeDataModelLiveData.removeObserver(detailsObserver)

        }
    }

    companion object{
        const val movieId = 1726
    }
}