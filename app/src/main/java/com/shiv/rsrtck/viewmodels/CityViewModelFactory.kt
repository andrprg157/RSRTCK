package com.shiv.rsrtck.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.Factory
import com.shiv.rsrtck.repositories.CityRepositories

class CityViewModelFactory(private val cityRepositories: CityRepositories): Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CityViewModel(cityRepositories) as T
    }
}