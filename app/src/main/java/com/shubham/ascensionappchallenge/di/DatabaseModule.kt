package com.shubham.ascensionappchallenge.di

import android.content.Context
import androidx.room.Room
import com.shubham.ascensionappchallenge.database.MovieDbDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


//Return
@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {


    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): MovieDbDatabase {
        return Room.databaseBuilder(
                appContext.applicationContext,
                MovieDbDatabase::class.java, DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }

    private const val DATABASE_NAME = "MovieDB"
}