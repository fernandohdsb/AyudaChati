package com.example.fernando_hernandezdesantamaria_pmdm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fernando_hernandezdesantamaria_pmdm.R
import com.example.fernando_hernandezdesantamaria_pmdm.model.Tarea
import com.google.android.material.snackbar.Snackbar

class AdapterTareas(var contexto: Context, var listaDatos: ArrayList<Tarea>) : RecyclerView.Adapter<AdapterTareas.MyHolder>() {
    inner class MyHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var nombre: TextView = view.findViewById(R.id.textoAdapter)
        var imagen: ImageView = view.findViewById(R.id.imagenAdapter)
        var boton: Button = view.findViewById(R.id.botonAdapter)
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View =
            LayoutInflater.from(contexto).inflate(R.layout.view_adapter, parent, false)

        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var tarea: Tarea = listaDatos.get(position)
        Glide.with(contexto).load(tarea.imagen).placeholder(R.drawable.pantalla_de_carga).into(holder.imagen)
        holder.nombre.setText(tarea.nombre)
        holder.boton.setOnClickListener {view ->
            Snackbar.make(view,tarea.descripcion, Snackbar.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }


}