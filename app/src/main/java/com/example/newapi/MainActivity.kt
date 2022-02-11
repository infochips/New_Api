package com.example.newapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//suspend fun getData() : String{
//    return Repo(postService, database, applicationContext).getPost1().toString()
//}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        launch(Dispatchers.Default)
//        {
//            try {
//                val result = async(Dispatchers.IO) {
//                    getData()
//                }
//                Log.d("result", result.await());
//                tv.text = result.await()
//
//            } catch (e: Exception) {
//                // Toast.makeText(applicationContext, e.message, Toast.LENGTH_LONG).show()
//
//            }


//            launch(Dispatchers.IO) {
//                repository.getPosts("/posts")

                // getPosts1("/posts")
                // repository.getPosts("/posts/1/comments")

        //}
    }
}