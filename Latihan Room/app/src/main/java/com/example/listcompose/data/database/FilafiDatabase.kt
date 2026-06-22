package com.example.listcompose.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.listcompose.data.dao.ReviewDao
import com.example.listcompose.data.entity.FilmRoomEntity
import com.example.listcompose.data.entity.ReviewEntity

@Database(
    entities = [FilmRoomEntity::class, ReviewEntity::class],
    version = 1,
    exportSchema = false
)
abstract class FilafiDatabase: RoomDatabase() {
    abstract fun reviewDao(): ReviewDao

    companion object{
        @Volatile
        private var INSTANCE: FilafiDatabase? = null

        fun getDatabase(context: Context): FilafiDatabase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FilafiDatabase::class.java,
                    "filafi_database"
                ).build()
                INSTANCE= instance
                instance
            }
        }
    }
}