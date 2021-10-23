package com.example.t20mania

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(context: Context):RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
private val ctx:Context= context
private val countryNames:List<String>

init {
    val names= context.resources.getStringArray(R.array.countries).toList()
    countryNames=names

}

class CountryViewHolder(val view:View):RecyclerView.ViewHolder(view)
{
    val button= view.findViewById<Button>(R.id.country_button)

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
    val layout= LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)

        return CountryViewHolder(layout)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val item= countryNames[position]
//        val typeface = ctx.resources.getFont(R.font.montserrat_bold)
//        holder.button.typeface=typeface
        holder.button.text=item

        holder.button.setOnClickListener {
            val context= holder.view.context
            val intent= Intent(context,SquadActivity::class.java)
            context.startActivity(intent)


        }

    }

    override fun getItemCount(): Int {
return countryNames.size
    }
}