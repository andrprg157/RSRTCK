package com.cheezycode.randomquote.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "QuoteList")
data class QuoteList(
    @PrimaryKey
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)