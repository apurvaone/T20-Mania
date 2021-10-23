package com.example.t20mania

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class PlayersAdapter(private val countryName:String,context:Context): RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder>() {

private val countrySquad:List<String>

init {
    val sw= countryName.slice(0..2)
    val p= context.resources.getIdentifier(sw,"array",context.packageName)
    val ps= context.resources.getStringArray(p).toList()
    countrySquad=ps
}

    class PlayerViewHolder(val view: View):RecyclerView.ViewHolder(view)
    {
          val button= view.findViewById<Button>(R.id.country_button)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
       val layout=LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return PlayerViewHolder(layout)

    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {

        val item= countrySquad[position]
        val context= holder.view.context

        holder.button.text=item


    }

    override fun getItemCount(): Int = countrySquad.size

}