package com.shubham.ascensionappchallenge.mvvm.repository.details

import com.shubham.ascensionappchallenge.model.common.DataResult
import com.shubham.ascensionappchallenge.model.data.HomeDataModel
import com.shubham.ascensionappchallenge.mvvm.repository.base.MVVMRepository
import kotlinx.coroutines.flow.Flow

interface DetailsRepository : MVVMRepository {

    suspend fun onRetrieveFlowDetails(homeDataModel: HomeDataModel): Flow<DataResult<HomeDataModel>>
    suspend fun onRetrieveDetails(homeDataModel: HomeDataModel): DataResult<HomeDataModel>
    suspend fun updateFavourite(homeDataModel: HomeDataModel?): DataResult<HomeDataModel>
}
