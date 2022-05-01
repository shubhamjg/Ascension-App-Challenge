package com.shubham.ascensionappchallenge.mvvm.repository.details

import com.shubham.ascensionappchallenge.common.Constants
import com.shubham.ascensionappchallenge.database.MovieDbDatabase
import com.shubham.ascensionappchallenge.database.dao.MovieDbTable
import com.shubham.ascensionappchallenge.model.common.DataResult
import com.shubham.ascensionappchallenge.model.data.HomeDataModel
import com.shubham.ascensionappchallenge.model.responses.movie.MovieResponse
import com.shubham.ascensionappchallenge.mvvm.repository.base.BaseRepositoryImpl
import com.shubham.ascensionappchallenge.networks.MovieClient
import com.shubham.ascensionappchallenge.model.responses.tv.TvShowResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class DetailsRepositoryImpl @Inject constructor(
    private var movieClient: MovieClient,
    private val movieDbDatabase: MovieDbDatabase?
) : BaseRepositoryImpl(), DetailsRepository {

    override suspend fun onRetrieveFlowDetails(homeDataModel: HomeDataModel): Flow<DataResult<HomeDataModel>> {
        return flow {
            emit(onRetrieveDetails(homeDataModel))
        }
    }

    override suspend fun onRetrieveDetails(homeDataModel: HomeDataModel): DataResult<HomeDataModel> {
        return try {
            val response = when (homeDataModel.mediaType) {
                Constants.IS_MOVIE -> movieToHomeDataModel(
                    homeDataModel, movieClient.getMovieDetailsAsync(
                        homeDataModel.id
                            ?: 0
                    )
                )
                else -> tvShowToHomeDataModel(
                    homeDataModel, movieClient.getTvShowDetailsAsync(
                        homeDataModel.id
                            ?: 0
                    )
                )
            }
            DataResult(response)
        } catch (t: Throwable) {
            Timber.d(t)
            DataResult(throwable = t)
        }
    }

    override suspend fun updateFavourite(homeDataModel: HomeDataModel?): DataResult<HomeDataModel> {
        return try {
            homeDataModel?.let {
                if (homeDataModel.isFavorite) {
                    movieDbDatabase?.movieDbTableDao()!!.insertModel(toDatabaseModel(homeDataModel))
                } else {
                    it.id?.let { id -> movieDbDatabase?.movieDbTableDao()!!.deleteModel(id) }
                }
            }
            DataResult(homeDataModel)
        } catch (t: Throwable) {
            Timber.d(t)
            DataResult(throwable = t)
        }
    }

    private fun toDatabaseModel(homeDataModel: HomeDataModel): MovieDbTable {
        homeDataModel.apply {
            return MovieDbTable(
                id = id ?: 0,
                title = title ?: "-",
                mediaType = mediaType ?: "-",
                summary = summary ?: "-",
                thumbnail = thumbnail ?: "",
                releaseDate = releaseDate ?: "-",
                ratings = ratings ?: "-",
                isFavourite = isFavorite,
                genresName = genresName ?: "-",
                videoKey = videoKey ?: "",
                videoUrl = videoUrl ?: "",
                dateAdded = System.currentTimeMillis()
            )
        }
    }

    private fun movieToHomeDataModel(
        homeDataModel: HomeDataModel,
        movieResponse: MovieResponse
    ): HomeDataModel {
        homeDataModel.apply {
            thumbnail = "${Constants.IMAGE_URL_W500}${movieResponse.posterPath}"
            genresName = movieResponse.genres?.firstOrNull()?.name ?: "-"
            videoUrl =
                "<html><body><br><iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/${homeDataModel.videoKey}\" frameborder=\"0\" allowfullscreen></iframe></body></html>"
        }
        return homeDataModel
    }

    private fun tvShowToHomeDataModel(
        homeDataModel: HomeDataModel,
        tvShowResponse: TvShowResponse
    ): HomeDataModel {
        homeDataModel.apply {
            thumbnail = "${Constants.IMAGE_URL_W500}${tvShowResponse.posterPath}"
            genresName = tvShowResponse.genres?.firstOrNull()?.name ?: "-"
            videoUrl =
                "<html><body><br><iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/${homeDataModel.videoKey}\" frameborder=\"0\" allowfullscreen></iframe></body></html>"

        }
        return homeDataModel
    }
}
