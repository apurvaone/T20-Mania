package com.example.t20mania

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.t20mania.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView= binding.recyclerView
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=CountryAdapter(this)

    }
}