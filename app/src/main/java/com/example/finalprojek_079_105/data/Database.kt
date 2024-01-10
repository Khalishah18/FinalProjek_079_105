package com.example.finalprojek_079_105.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Pembeli::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase(){
    abstract fun pembeliDao() : PembeliDao

    companion object{
        @Volatile
        private var Instance: Database? = null

        fun getDatabase(context: Context): Database {
            return (Instance?: synchronized(this){
                Room.databaseBuilder(context,
                   Database::class.java,
                    "pembeli_database")
                    .build().also { Instance=it }
            })
        }
    }
}