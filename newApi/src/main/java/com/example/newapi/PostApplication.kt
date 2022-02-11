package com.example.newapi

import android.app.Application
import com.example.newapi.api.PostService
import com.example.newapi.api.RetrofitHelper
import com.example.newapi.db.PostDatabase
//import com.example.newapi.repo.PostRepository

class PostApplication : Application() {

    lateinit var postRepository: Repo

    override fun onCreate() {
        super.onCreate()

        initialize()
    }

    private fun initialize() {

       // PostService postService : retrofit.


        val postService = RetrofitHelper.getInstance().create(PostService::class.java)

        val database = PostDatabase.getDatabase(applicationContext)

         postRepository = Repo(postService,database,applicationContext)
    }
}