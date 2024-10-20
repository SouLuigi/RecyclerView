package com.ex.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EstadoAdapter(private val estados: List<Estado>, private val onClick: (Estado) -> Unit) :
    RecyclerView.Adapter<EstadoAdapter.EstadoViewHolder>() {

    inner class EstadoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val bandeiraImageView: ImageView = itemView.findViewById(R.id.imageViewBandeira)
        private val nomeTextView: TextView = itemView.findViewById(R.id.textViewNomeEstado)

        fun bind(estado: Estado) {
            bandeiraImageView.setImageResource(estado.bandeira)
            nomeTextView.text = estado.nome

            itemView.setOnClickListener {
                onClick(estado)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstadoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_estado, parent, false)
        return EstadoViewHolder(view)
    }

    override fun onBindViewHolder(holder: EstadoViewHolder, position: Int) {
        holder.bind(estados[position])
    }

    override fun getItemCount(): Int = estados.size
}
