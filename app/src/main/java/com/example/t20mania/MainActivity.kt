package com.example.t20mania

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.t20mania.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private  var isLinearLayoutManager= true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView= binding.recyclerView
        recyclerView.layoutManager= LinearLayoutManager(this)
//        recyclerView.adapter=CountryAdapter(this)
        chooseLayout()

    }

    private fun chooseLayout()
    {
         if(isLinearLayoutManager)
           recyclerView.layoutManager=LinearLayoutManager(this)
         else
             recyclerView.layoutManager=GridLayoutManager(this,2)

         recyclerView.adapter= CountryAdapter(this)

    }

    private  fun setIcon(menuItem: MenuItem?)
    {
        if(menuItem==null)
            return

        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)

        val layoutButton= menu?.findItem(R.id.switch_layout)
        setIcon(layoutButton)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId)
        {
            R.id.switch_layout->
            {
                isLinearLayoutManager= !isLinearLayoutManager
                chooseLayout()
                 setIcon(item)
                return true

            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}

