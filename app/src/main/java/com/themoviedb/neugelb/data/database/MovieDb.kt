package com.themoviedb.neugelb.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.themoviedb.neugelb.data.MovieData

@Database(
    entities = [
        MovieData::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DbTypeConverters::class)
abstract class MovieDb : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}