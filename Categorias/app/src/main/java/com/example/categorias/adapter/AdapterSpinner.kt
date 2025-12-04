package com.example.categorias.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.categorias.R
import com.example.categorias.model.Categoria

class AdapterSpinner(var listaCategorias: ArrayList<Categoria>): BaseAdapter() {
    override fun getCount(): Int {
        return listaCategorias.size
    }

    override fun getItem(position: Int): Any? {
        return listaCategorias[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    @SuppressLint("ViewHolder")
    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        val view: View =
            LayoutInflater.from(parent?.context)
                .inflate(
                    R.layout.items_spinner,
                    parent, false
            )

        val text: TextView = view.findViewById(R.id.textSpinner)
        val imagen: ImageView = view.findViewById(R.id.imagenSpinner)
        val categoria: Categoria = listaCategorias[position]

        text.text = categoria.categoria
        imagen.setImageResource(categoria.cartel)
        return view
    }
}