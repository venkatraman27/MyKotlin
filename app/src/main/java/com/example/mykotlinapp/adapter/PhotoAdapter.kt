package com.example.mykotlinapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_items.view.*
import com.example.mykotlinapp.model.Photo
import com.example.mykotlinapp.R
import java.util.ArrayList

class PhotoAdapter (val items:ArrayList<Photo>) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_items,null))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = items[position]
        holder.name.text = user.title
        Picasso.get().load(user.thumbnailUrl).into(holder.image)

    }


}

class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
    val name : TextView = view.tvTitle
    val image : ImageView = view.ivImage
}

