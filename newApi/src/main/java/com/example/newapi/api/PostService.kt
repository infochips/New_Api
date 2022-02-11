package com.example.newapi.api

import com.example.newapi.models.CommentListItem
import com.example.newapi.models.PostListItem
import retrofit2.http.GET
import retrofit2.http.Url

interface PostService {


//    @GET("/posts")
//    suspend fun getPosts() : List<PostListItem>

            @GET
            suspend fun getPosts(@Url url: String): List<PostListItem>

            //https://jsonplaceholder.typicode.com/posts/1/comments
            @GET
            suspend fun getComments(@Url url: String): List<CommentListItem>
}