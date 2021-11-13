package com.shiv.rsrtck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shiv.rsrtck.model.ItemsViewModel
import com.shiv.rsrtck.repositories.CityRepositories
import com.shiv.rsrtck.viewmodels.CityViewModel
import com.shiv.rsrtck.viewmodels.CityViewModelFactory

class CityActivity : AppCompatActivity() {

    lateinit var cityViewModel: CityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)
        val recyclrvw= findViewById<RecyclerView>(R.id.recyclervwcity)
        val mlayoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        recyclrvw.layoutManager=mlayoutManager
        val cityRepositories = CityRepositories(this)
        cityViewModel = ViewModelProvider(this,
            CityViewModelFactory(cityRepositories)).get(CityViewModel::class.java)
        cityViewModel.cities.observe(this, Observer {
            Log.d("shiv","inside cityActivity")
            Log.d("shiv","inside cityActivity ="+ it.toString())
            val adapter = CustomAdapter(it)
            recyclrvw.adapter=adapter
            DividerItemDecoration(
                this, // context
                mlayoutManager.orientation
            ).apply { recyclrvw.addItemDecoration(this) }
        })
    }
}