package com.example.moneycrunch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter(

    private val homeComponents: ArrayList<Components>

) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layouts = LayoutInflater.from(parent.context).inflate(R.layout.home_layout, parent, false)
        return RecyclerView.ViewHolder(layouts)
    }

    override fun getItemCount(): Int {
        return homeComponents.size
    }

    class ComponentViewHolder constructor(
        itemView : View
    ) : RecyclerView.ViewHolder(itemView) {
        val calImage = itemView.findViewById<ImageButton>(R.id.cal_loan)
        val calTextview = itemView.findViewById<TextView>(R.id.cal_textView)

        fun bind(viewHome: )

    }
}