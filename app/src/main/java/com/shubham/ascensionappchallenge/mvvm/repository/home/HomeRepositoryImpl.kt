package com.shubham.ascensionappchallenge.mvvm.repository.home

import com.shubham.ascensionappchallenge.common.Constants
import com.shubham.ascensionappchallenge.database.MovieDbDatabase
import com.shubham.ascensionappchallenge.database.dao.MovieDbTable
import com.shubham.ascensionappchallenge.model.common.DataResult
import com.shubham.ascensionappchallenge.model.data.HomeDataModel
import com.shubham.ascensionappchallenge.model.responses.search.SearchResponse
import com.shubham.ascensionappchallenge.mvvm.repository.base.BaseRepositoryImpl
import com.shubham.ascensionappchallenge.networks.MovieClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber

//We get the data from remote source and setting up in local db.
class HomeRepositoryImpl(private var movieClient: MovieClient, private val movieDbDatabase: MovieDbDatabase?) : BaseRepositoryImpl(), HomeRepository {

    override suspend fun getWatchList(): DataResult<List<HomeDataModel>> {
        return try {
            val databaseList = movieDbDatabase?.movieDbTableDao()?.loadAll()
            DataResult(toHomeDataModelFromTable(databaseList!!))
        } catch (t: Throwable) {
            Timber.d(t)
            DataResult(throwable = t)
        }
    }

    override suspend fun onRetrieveSearchResult(queryText: String, page: Int): Flow<DataResult<List<HomeDataModel>>> {
        return try {
            val response = movieClient.getSearchAsync(queryText, page)
            flow { emit(DataResult(toHomeDataModel(response))) }
        } catch (t: Throwable) {
            Timber.d(t)
            flow { DataResult(null, throwable = t) }
        }
    }


    private fun toHomeDataModel(searchResponse: SearchResponse): List<HomeDataModel> {
        return (searchResponse.searchResultsList?.map { searchItem ->
            HomeDataModel(
                    id = searchItem.id,
                    title = searchItem.title ?: searchItem.name ?: searchItem.originalName ?: "-",
                    mediaType = searchItem.mediaType ?: "-",
                    summary = searchItem.overview ?: "-",
                    thumbnail = "${Constants.IMAGE_URL_W300}${searchItem.posterPath}",
                    releaseDate = searchItem.releaseDate ?: searchItem.firstAirDate ?: "-",
                    ratings = (searchItem.voteAverage ?: 0).toString(),
                    page = searchResponse.page ?: 0,
                    totalPage = searchResponse.totalPages ?: 0,
                    isFavorite = movieDbDatabase?.movieDbTableDao()!!.isFavourite(searchItem.id ?: 0))
        } ?: arrayListOf())
    }


    private fun toHomeDataModelFromTable(databaseList: List<MovieDbTable>): List<HomeDataModel> {
        return databaseList.map { databaseItem ->
            HomeDataModel(
                    id = databaseItem.id,
                    title = databaseItem.title,
                    mediaType = databaseItem.mediaType,
                    summary = databaseItem.summary,
                    thumbnail = databaseItem.thumbnail,
                    releaseDate = databaseItem.releaseDate,
                    ratings = databaseItem.ratings,
                    isFavorite = databaseItem.isFavourite,
                    genresName = databaseItem.genresName,
                    videoKey = databaseItem.videoKey,
                    videoUrl = databaseItem.videoUrl,
                    dateAdded = databaseItem.dateAdded)
        }
    }
}