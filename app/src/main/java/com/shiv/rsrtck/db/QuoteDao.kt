package com.shiv.rsrtck.db

import androidx.room.Dao
import androidx.room.Insert
import com.cheezycode.randomquote.models.Result


@Dao
interface QuoteDao {

    @Insert
    suspend fun addQuotes(quotes:List<Result>)
}