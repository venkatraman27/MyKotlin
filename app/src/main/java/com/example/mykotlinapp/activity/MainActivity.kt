package com.example.mykotlinapp.activity

import android.os.Bundle
import android.util.Log.e
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mykotlinapp.APIClient
import com.example.mykotlinapp.IRetrofit
import kotlinx.android.synthetic.main.activity_main.*
import com.example.mykotlinapp.R
import com.example.mykotlinapp.adapter.PhotoAdapter
import com.example.mykotlinapp.model.Photo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text.setText("")
        text.setOnClickListener{
            Toast.makeText(this,"Logg",Toast.LENGTH_LONG).show()
                e("adfasgf","sg") }


        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        val apiClient: IRetrofit = APIClient.create()
        apiClient.getAllPosts().enqueue(object : Callback<ArrayList<Photo>> {
                override fun onFailure(call: Call<ArrayList<Photo>>, t: Throwable) {
                }

               override fun onResponse(call: Call<ArrayList<Photo>>, response: Response<ArrayList<Photo>>) {
                    recyclerView.adapter = PhotoAdapter(response.body()!!)
               }
            })
    }
}




