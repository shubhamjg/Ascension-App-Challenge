package com.shubham.ascensionappchallenge.model.common

data class DataResult<out T>(
        val data: T? = null,
        val throwable: Throwable? = null
)