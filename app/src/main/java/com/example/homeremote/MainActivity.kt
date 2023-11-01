package com.example.homeremote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.homeremote.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MoviesViewModel
    private lateinit var apiService: MoviesApiService
    private lateinit var moviesDatabase: MoviesDatabase
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiService = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesApiService::class.java)

        moviesDatabase = Room.databaseBuilder(
            this@MainActivity,
            MoviesDatabase::class.java,
            "movies_database")
            .build()

        val factory = MoviesFactory(apiService, moviesDatabase)
        viewModel = ViewModelProvider(this@MainActivity, factory)[MoviesViewModel::class.java]

        initView()
        initRecycler()
    }

    private fun initRecycler() {
        moviesAdapter = MoviesAdapter()
        binding.rcView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = moviesAdapter
        }
    }

    private fun initView() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.pagingData.collectLatest {
                    moviesAdapter.submitData(it)
                }
            }
        }
    }
}