package com.shubham.ascensionappchallenge

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shubham.ascensionappchallenge.database.MovieDbDatabase
import com.shubham.ascensionappchallenge.database.dao.MovieDbTable
import com.shubham.ascensionappchallenge.database.dao.MovieDbTableDao
import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/*
 Test class to verify Note dao CRUD operations
 */
@RunWith(AndroidJUnit4::class)
class MovieDbTableDaoTest {

    private lateinit var movieDbDatabase: MovieDbDatabase
    private lateinit var movieDbTableDao: MovieDbTableDao


    // Setting Up context and intialise database, dao instance.
    @Before
    fun setup() {
        val context = androidx.test.InstrumentationRegistry.getContext()
        movieDbDatabase = Room.inMemoryDatabaseBuilder(context, MovieDbDatabase::class.java).build()
        movieDbTableDao = movieDbDatabase.movieDbTableDao()
    }

    /*testing that movie is saved into database and then fetching that data from same db to
    ensure that data is stored correctly*/
    @Test
    fun testSaveMovie() {
        val movie = MovieDbTable(
            id = 1,
            title = "Avenger",
            mediaType = "movie",
            summary = "A tale based on the life of the inventor of the original"
        )

        movieDbTableDao.insertModel(movie)

        assertNotNull(movie)
        assertEquals(movie.id,1)
        assertEquals(movie.title,"Avenger")
        assertEquals(movie.mediaType,"movie")
        assertEquals(movie.summary,"A tale based on the life of the inventor of the original")

    }

    @Test
    fun testFindSavedMovies() {
        val movies = listOf(
            MovieDbTable(
                id = 1,
                title = "Avenger",
                mediaType = "movie",
                summary = "A tale based on the life of the inventor of the original"
            ),
            MovieDbTable(
                id = 2,
                title = "Iron man",
                mediaType = "movie",
                summary = "Super Hero movie"
            ),
            MovieDbTable(
                id = 3,
                title = "Titanic",
                mediaType = "movie",
                summary = "Romantic movie"
            )
        )

        movies.forEach {
            movieDbTableDao.insertModel(it)
        }

        assertEquals(3, movieDbTableDao.loadAll().size)
    }

    @Test
    fun testDeleteMovie() {
        val movie = MovieDbTable(
            id = 1,
            title = "Avenger",
            mediaType = "movie",
            summary = "A tale based on the life of the inventor of the original"
        )
        movieDbTableDao.insertModel(movie)
        movieDbTableDao.loadAll()[0]

        movieDbTableDao.deleteModel(movie.id)

        assertEquals(0, movieDbTableDao.loadAll().size)
    }
}