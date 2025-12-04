package com.example.categorias.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.categorias.DataSet.DataSet
import com.example.categorias.R
import com.example.categorias.model.Categoria
import com.example.categorias.model.Producto
import com.google.android.material.snackbar.Snackbar
import java.io.Serializable



class AdapterCarrito(var listaProductos: ArrayList<Producto>,var context: Context): RecyclerView.Adapter<AdapterCarrito.MyHolder>(),
    Serializable{

    inner class MyHolder(var vista: View): RecyclerView.ViewHolder(vista){
        val textView: TextView = vista.findViewById(R.id.nombreProductoCarrito)
        val imageView: ImageView = vista.findViewById(R.id.imagenProductoCarrito)
        val botonQuitar: Button = vista.findViewById(R.id.buttonQuitarCarrito)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        val binding = LayoutInflater.from(context).inflate(R.layout.item_producto_carrito,parent,false)
        return MyHolder(binding)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        val producto: Producto = listaProductos[position]
        Glide.with(context).load(producto.imagen).placeholder(R.drawable.corteingles).into(holder.imageView)
        holder.textView.text = producto.nombre

        holder.botonQuitar.setOnClickListener {
            DataSet.quitarDelCarrito(producto)
            notifyDataSetChanged()
            Snackbar.make(
                holder.itemView,
                "Se ha quitado el producto ${holder.textView.text} del carrito",
                Snackbar.LENGTH_LONG
            ).show()
        }
    }








    override fun getItemCount(): Int {
        return listaProductos.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun actualizar_datos(list: ArrayList<Producto>, categoria: Categoria){
        listaProductos = DataSet.getCategorias(categoria)
        notifyDataSetChanged()
    }


}

