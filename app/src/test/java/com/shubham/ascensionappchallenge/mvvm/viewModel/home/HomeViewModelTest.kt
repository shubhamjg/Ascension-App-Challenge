package com.shubham.ascensionappchallenge.mvvm.viewModel.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.shubham.ascensionappchallenge.common.Constants
import com.shubham.ascensionappchallenge.common.Constants.API_KEY
import com.shubham.ascensionappchallenge.model.data.HomeDataModel
import com.shubham.ascensionappchallenge.model.responses.search.SearchResponse
import com.shubham.ascensionappchallenge.mvvm.repository.home.HomeRepositoryImpl
import com.shubham.ascensionappchallenge.networks.MovieClient
import com.shubham.ascensionappchallenge.networks.MovieService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var movieService: MovieService

    @Mock
    lateinit var movieClient: MovieClient

    @Mock
    lateinit var paginationLoaderLiveData:Observer<Boolean>

    @Mock
    lateinit var searchList:Observer<MutableList<HomeDataModel>>

    @Mock
    lateinit var homeViewModel: HomeViewModel

    @Test
    fun `testing for repo`() {
        runBlocking {
            val getResponse = Gson().fromJson(Constants.SEARCH_RESPONSE, SearchResponse::class.java)
            val response = getResponse
            Mockito.`when`(
                movieService.getSearchAsync(
                    apiKey = API_KEY,
                    query = MovieName,
                    page = pageNumber
                )
            ).thenReturn(response)


            movieClient = MovieClient(movieService)

            val homeRepositoryImpl = HomeRepositoryImpl(movieClient,movieDbDatabase = null)
            homeViewModel = HomeViewModel(homeRepositoryImpl)
            homeViewModel.paginationLoaderLiveData.observeForever(paginationLoaderLiveData)
            homeViewModel.getSearchList().observeForever(searchList)

            movieService.getSearchAsync(apiKey = API_KEY,
                query = MovieName,
                page = pageNumber)

            verify(movieService).getSearchAsync(apiKey = API_KEY,
                query = MovieName,
                page = pageNumber)

            val expectedResult =
                Gson().fromJson(Constants.SEARCH_RESPONSE, HomeDataModel::class.java)

            verify(searchList).onChanged(mutableListOf(expectedResult))
            verify(paginationLoaderLiveData).onChanged(true)

            homeViewModel.searchMutableLiveData.removeObserver(searchList)
            homeViewModel.paginationLoaderLiveData.removeObserver(paginationLoaderLiveData)

        }


    }

    companion object {
        const val MovieName = "Iron Man"
        const val pageNumber = 1
    }
}
