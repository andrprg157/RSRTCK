package com.shiv.rsrtck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.shi.MainRepositories
import com.shiv.rsrtck.api.ApiClient
import com.shiv.rsrtck.api.ApiInterface
import com.shiv.rsrtck.repositories.Response
import com.shiv.rsrtck.viewmodels.MainViewModel
import com.shiv.rsrtck.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var progressBar:ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiInterface = ApiClient.getInstance().create(ApiInterface::class.java)
        val mainRepositories = MainRepositories(apiInterface,this)

        progressBar = findViewById(R.id.progressBar);
        mainViewModel = ViewModelProvider(this,
            MainViewModelFactory(mainRepositories)).get(MainViewModel::class.java)
        // calling the api in oncreate
        // mainViewModel.getResponse()

        mainViewModel.mutableLiveData.observe(this,

            Observer {
                Log.d("shiv", "INSIDE OBSERVER")
                when(it)
                {
                    is Response.Loading ->{
                        Log.d("shiv","Loading got")
                        progressBar.visibility=View.VISIBLE
                    }
                    is Response.Success ->
                    {
                        progressBar.visibility=View.INVISIBLE
                        Log.d("shiv","Success got")
                        it.data?.let {
                            Toast.makeText(this, "here = " + it.results.size, Toast.LENGTH_LONG).show()
                        }
                    }
                    is Response.Error ->{
                        progressBar.visibility=View.INVISIBLE
                        Log.d("shiv","Error got")
                    }
                }
            })
    }

    fun callMOdel(view: View) {
        mainViewModel.getResponse()
    }
}