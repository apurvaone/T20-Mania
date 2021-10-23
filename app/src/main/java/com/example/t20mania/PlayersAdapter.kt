package com.example.t20mania

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

class PlayersAdapter(private val countryName:String,context:Context): RecyclerView.Adapter<>() {

private val countrySquad:List<String>

init {
    val sw= countryName.slice(0..2)
    val p= context.resources.getIdentifier(sw,"array",context.packageName)
    countrySquad= listOf(p)

}
}