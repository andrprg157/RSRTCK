package com.shiv.rsrtck.repositories

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shiv.rsrtck.utils.NetworkUtils
import java.util.*

class CityRepositories(private val context: Context)
{


    private val  citiesLiveData = MutableLiveData<List<String>>()


    val cities : LiveData<List<String>>
    get() = citiesLiveData

    suspend fun getCities()
    {

        if(NetworkUtils.isInternetAvailable(context))
        {
            Log.d("shiv","NET CONNNECTED")
            //FETCH AND SET DATA FROM API AND INSERTT IN ROOM
            citiesLiveData.postValue(getCityList())
        }
        else
        {
            Log.d("shiv","NET NOT CONNNECTED")
            //FETCH AND  SET DATA FROM ROOM DAO
            citiesLiveData.postValue(getCityList())

        }
    }
    fun getCityList():List<String>
    {
        Log.d("shiv","callled getCityList")

        return  listOf("mumbai","delhi","bangalore","calcutta","hyderabad","ahmedabad",
            "chennai","kolkata","surat","pune","jaipur","jucknow","kanpur","nagpur","indore","thane","bhopal").map { it.capitalized() }

    }
    fun String.capitalized(): String {
        return this.replaceFirstChar {
            if (it.isLowerCase())
                it.titlecase(Locale.getDefault())
            else it.toString()
        }
    }
}