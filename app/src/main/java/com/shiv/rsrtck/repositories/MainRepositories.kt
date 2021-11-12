package com.shi

import android.content.Context
import android.util.Log

import androidx.lifecycle.MutableLiveData
import com.cheezycode.randomquote.models.QuoteList
import com.shiv.rsrtck.api.ApiInterface
import com.shiv.rsrtck.db.QuoteDatabase
import com.shiv.rsrtck.repositories.Response
import com.shiv.rsrtck.utils.NetworkUtils

class MainRepositories(private val apiInterface: ApiInterface,private val context: Context)
{
    var mutableLiveData = MutableLiveData<Response<QuoteList>>()
     val quoteDatabase =QuoteDatabase.getDatabase(context) //SEND THIS FROM MAINACTIVITY



    suspend fun getMutableLiveData(): MutableLiveData<Response<QuoteList>> {

        if(NetworkUtils.isInternetAvailable(context))
        {
            Log.d("shiv","NET CONNNECTED")
            //FETCH AND SET DATA FROM API AND INSERTT IN ROOM
        }
        else
        {
            Log.d("shiv","NET NOT CONNNECTED")
            //FETCH AND  SET DATA FROM ROOM DAO

        }

        try {
            mutableLiveData.postValue(Response.Loading())
            val mycall = apiInterface.getQuotes(1)
            Log.d("shiv","response")
            Log.d("shiv","response ="+mycall)
            if (mycall.body()!=null)
            {
                quoteDatabase.quoteDao().addQuotes(mycall.body()!!.results)
                mutableLiveData.postValue(Response.Success(mycall.body()))
            }
        } catch (e: Exception) {
            Log.d("shiv","heree")
            Log.d("shiv","heree"+e.message)
            Log.d("shiv","heree"+e.cause)
            Log.d("shiv","heree"+e.stackTrace)
            mutableLiveData.postValue(Response.Error(e.message.toString()))
        }
        /*  mycall.enqueue(object : Callback<QuoteList> {
              override fun onResponse(call: Call<QuoteList>, response: Response<QuoteList>) {
                  Log.d("shiv", "Inside onResponse")
                  Log.d("shiv", "Inside onResponse =" + response.body()!!.results)
                  mutableLiveData.value = response.body()
              }

              override fun onFailure(call: Call<QuoteList>, t: Throwable) {
                  Log.d("shiv", "Inside onFailure")

              }

          })*/

        return mutableLiveData


    }
}