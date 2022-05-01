package com.shubham.ascensionappchallenge.mvvm.repository.home

import com.shubham.ascensionappchallenge.model.common.DataResult
import com.shubham.ascensionappchallenge.model.data.HomeDataModel
import com.shubham.ascensionappchallenge.mvvm.repository.base.MVVMRepository
import kotlinx.coroutines.flow.Flow

interface HomeRepository : MVVMRepository {

    suspend fun onRetrieveSearchResult(queryText: String, page: Int): Flow<DataResult<List<HomeDataModel>>>
    suspend fun getWatchList(): DataResult<List<HomeDataModel>>
}