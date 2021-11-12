package com.shiv.rsrtck.api

import com.cheezycode.randomquote.models.QuoteList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/quotes")
  //  suspend fun getQuotes(@Query("page") page: Int) : Response<QuoteList>
  //   fun getQuotes(@Query("page") page: Int) : Call<QuoteList>
    suspend fun getQuotes(@Query("page") page: Int) : Response<QuoteList>


}