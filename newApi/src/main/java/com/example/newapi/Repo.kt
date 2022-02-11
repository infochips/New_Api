package com.example.newapi

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.networklibrary.NetworkUtils
import com.example.newapi.api.PostService
import com.example.newapi.db.PostDatabase
import com.example.newapi.models.CommentListItem
import com.example.newapi.models.PostListItem

class Repo(val postService: PostService,
          val  postDatabase: PostDatabase,
           val applicationContext: Context) {

    private val postsLiveData = MutableLiveData<List<PostListItem>>()   // publically not access
    private val postsLiveData1 = MutableLiveData<List<CommentListItem>>()   // publically not access

    //val posts : LiveData<PostListItem>
    val posts : MutableLiveData<List<PostListItem>>
        get() = postsLiveData

    val posts1 : MutableLiveData<List<CommentListItem>>
        get() = postsLiveData1

    suspend fun getPosts(url1: String) {

        if (NetworkUtils.isNetworkAvailable(applicationContext)){

            //  val url :String = "https://jsonplaceholder.typicode.com/posts"

            val result = postService.getPosts(url1)

            if (result != null){
                for (postlistitem1 in result) {
                    postDatabase.postDao().addtPost(result)  // save data in room database
                    // Log.e("postDatabase", result.toString())

                    postsLiveData.postValue(result)
                }
            }

        }else{

            // for Offline support. get data from room database & display on UI
            val posts = postDatabase.postDao().getPosts()
            postsLiveData.postValue(posts)

        }

    }

    suspend fun getPost2(url2 : String){

        val commentResult = postService.getComments(url2)

        if (commentResult != null){
            for (postlistitem2 in commentResult) {
                postDatabase.postDao().addtComment(commentResult)  // save data in room database
                // Log.e("postDatabase", result.toString())

                postsLiveData1.postValue(commentResult)
            }
        }else{

            // for Offline support. get data from room database & display on UI
            val posts1 = postDatabase.postDao().getComments()
            postsLiveData1.postValue(posts1)

        }

    }





    //=========================================

//    lateinit var postService: PostService
//    private val postsLiveData = MutableLiveData<List<PostListItem>>()   // publically not access
//    private val postsLiveData1 = MutableLiveData<List<CommentListItem>>()   // publically not access
//
////    val posts : MutableLiveData<List<PostListItem>>
////        get() = postsLiveData
////
////    val posts1 : MutableLiveData<List<CommentListItem>>
////        get() = postsLiveData1
//
//    suspend fun getPost1(){
//
//       // val result = postService.getPosts()
//        val result = postService.getPosts()
//        postsLiveData.postValue(result)
//    }

   // initialize()

}