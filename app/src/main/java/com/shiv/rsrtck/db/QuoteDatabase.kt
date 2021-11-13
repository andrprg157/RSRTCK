package com.shiv.rsrtck.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cheezycode.randomquote.models.QuoteList


//@Database(entities = [QuoteList::class],version = 1)
abstract  class QuoteDatabase : RoomDatabase()
{

abstract fun quoteDao() : QuoteDao

    companion object{

        @Volatile
        private var INSTANCE : QuoteDatabase? = null


        fun getDatabase(context: Context):QuoteDatabase
        {
            if (INSTANCE == null)
            {
                synchronized(this){
                    INSTANCE= Room.databaseBuilder(context,
                        QuoteDatabase::class.java,
                        "my_db"
                    ).build()

                }
            }
            return  INSTANCE!!

        }

    }
}