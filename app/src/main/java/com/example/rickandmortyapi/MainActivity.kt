package com.example.rickandmortyapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapi.databinding.ActivityMainBinding
import com.example.rickandmortyapi.entities.SingleCharacter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.activity.viewModels
import com.example.rickandmortyapi.adapter.ApiAdapter
import com.example.rickandmortyapi.api.ApiService
import com.example.rickandmortyapi.view.MainActivityViewModel
import kotlinx.coroutines.Job

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter: ApiAdapter
    private val characters = mutableListOf<SingleCharacter>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        listCharacter()
    }
    private fun initRecyclerView() {
        adapter = ApiAdapter(characters)
        binding.rvChar.layoutManager = LinearLayoutManager(this)
        binding.rvChar.adapter = adapter

    }

    private fun getRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun listCharacter(){
        CoroutineScope(Dispatchers.IO).launch {

            val call = getRetrofit().create(ApiService::class.java).getCharacters(1)
            val character = call.apiCharacters
            runOnUiThread {

                characters.clear()
                characters.addAll(character)
                adapter.notifyDataSetChanged()
            }
        }
    }
    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }
}


