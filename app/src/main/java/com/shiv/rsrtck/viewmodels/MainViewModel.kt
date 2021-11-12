package com.shiv.rsrtck.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cheezycode.randomquote.models.QuoteList
import com.shi.MainRepositories
import com.shiv.rsrtck.repositories.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepositories: MainRepositories) : ViewModel() {

    /*init {
        viewModelScope.launch(Dispatchers.IO)
        {
            mainRepositories.getMutableLiveData()
        }
    }*/
    val mutableLiveData : MutableLiveData<Response<QuoteList>>
    get() = mainRepositories.mutableLiveData
//    val mainRepositories = MainRepositories()

    fun getResponse() {
        Log.d("shiv", "getresponse!!")
        viewModelScope.launch(Dispatchers.IO)
        {
          //  mutableLiveData = mainRepositories.getMutableLiveData()
            mainRepositories.getMutableLiveData()
        }

    }
}
