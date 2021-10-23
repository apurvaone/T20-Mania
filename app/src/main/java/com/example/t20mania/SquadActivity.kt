package com.example.t20mania

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t20mania.databinding.ActivitySquadBinding

class SquadActivity : AppCompatActivity() {

    companion object{
const val Country= "country"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        val binding= ActivitySquadBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val countryname=intent?.extras?.getString(Country).toString()
        val recyclerView= binding.recyclerView

        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=PlayersAdapter(countryname,this)

        title= countryname

        supportActionBar?.setDisplayHomeAsUpEnabled(true)





    }
}