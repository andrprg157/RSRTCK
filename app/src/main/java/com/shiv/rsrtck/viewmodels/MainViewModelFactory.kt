package com.shiv.rsrtck.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shi.MainRepositories

class MainViewModelFactory(private val mainRepositories: MainRepositories):ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(mainRepositories) as T
    }
}