package com.example.mykotlinapp

import retrofit2.Call
import retrofit2.http.GET
import com.example.mykotlinapp.model.Photo
import kotlin.collections.ArrayList

interface IRetrofit {
    @GET("albums/1/photos")
    fun getAllPosts(): Call<ArrayList<Photo>>

}