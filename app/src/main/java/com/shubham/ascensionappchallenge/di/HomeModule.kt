package com.shubham.ascensionappchallenge.di

import com.shubham.ascensionappchallenge.database.MovieDbDatabase
import com.shubham.ascensionappchallenge.mvvm.repository.home.HomeRepositoryImpl
import com.shubham.ascensionappchallenge.networks.MovieClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//Constructor Injection for Home Repo
@InstallIn(SingletonComponent::class)
@Module
object HomeModule {

    @Provides
    fun provideHomeRepository(movieClient: MovieClient,
                              movieDbDatabase: MovieDbDatabase
    ): HomeRepositoryImpl {
        return HomeRepositoryImpl(movieClient, movieDbDatabase)
    }
}