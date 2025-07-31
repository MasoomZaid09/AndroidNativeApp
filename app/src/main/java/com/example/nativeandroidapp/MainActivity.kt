package com.example.nativeandroidapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.nativeandroidapp.databinding.ActivityMainBinding
import com.example.nativeandroidapp.domain.model.Response
import com.example.nativeandroidapp.ui.adapters.PostsAdapter
import com.example.nativeandroidapp.ui.viewmodels.MyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val myViewModel : MyViewModel by viewModels()
    private var binding: ActivityMainBinding? = null
    private lateinit var postsAdapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        lifecycleScope.launch {
            myViewModel.dataFlow.collect { it ->

                delay(500L)
                setupPostAdapter(it)
            }
        }

        binding?.btnGoTopOffline?.setOnClickListener{

            if (binding?.btnGoTopOffline?.text == "GET DATA FROM LOCAL DB"){
                binding?.btnGoTopOffline?.text = "GET DATA FROM API"
                myViewModel.fetchUserDataFromLocal()

            }else{
                binding?.btnGoTopOffline?.text = "GET DATA FROM LOCAL DB"
                myViewModel.fetchUserData()
            }

            setupPostAdapter(ArrayList())
        }

        myViewModel.fetchUserData()
    }


    private fun setupPostAdapter(list: ArrayList<Response>) {
        postsAdapter = PostsAdapter(list)
        binding?.postRecyclerView?.adapter = postsAdapter
    }
}