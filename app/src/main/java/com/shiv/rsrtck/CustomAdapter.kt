package com.shiv.rsrtck

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.shiv.rsrtck.model.ItemsViewModel

//onCreateViewHolder to inflate the row layout
//onBIndviewHolder to loop and set data on views
//getItemcount() to return the Arraylist/List size

class CustomAdapter(val mList:List<String>): RecyclerView.Adapter<CustomAdapter.ViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_desing,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]
     //   holder.imageView.setImageResource(ItemsViewModel.image)
        holder.textView.text = ItemsViewModel
    }

    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
    val textView :TextView =  itemView.findViewById(R.id.tvcity)
  //  val imageView :ImageView =  itemView.findViewById(R.id.imageview)
    }
    }
