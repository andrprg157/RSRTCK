package com.shiv.rsrtck.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shiv.rsrtck.repositories.CityRepositories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CityViewModel(private val cityRepositories: CityRepositories): ViewModel()
{
    init {

        viewModelScope.launch(Dispatchers.IO)
        {
            cityRepositories.getCities()
        }


    }
    val cities : LiveData<List<String>>
        get() = cityRepositories.cities
}