package com.example.categorias.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.categorias.CarritoActivity
import com.example.categorias.DataSet.DataSet
import com.example.categorias.DetalleActivity
import com.example.categorias.R
import com.example.categorias.model.Categoria
import com.example.categorias.model.Producto
import com.google.android.material.snackbar.Snackbar
import java.io.Serializable

class AdapterCategoria(var listaProductos: ArrayList<Producto>,var context: Context): RecyclerView.Adapter<AdapterCategoria.MyHolder>(),
    Serializable{

        private lateinit var listener: OnProductoListener


        init {
            listener = context as OnProductoListener
        }
    inner class MyHolder(var vista: View): RecyclerView.ViewHolder(vista){
        val textView: TextView = vista.findViewById(R.id.nombreProducto)
        val imageView: ImageView = vista.findViewById(R.id.imagenProducto)
        val botonDetalle: Button =vista.findViewById(R.id.buttonDetalle)
        val botonCarrito: Button = vista.findViewById(R.id.aniadirCarrito)



    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        val binding = LayoutInflater.from(context).inflate(R.layout.item_producto,parent,false)
        return MyHolder(binding)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
      val producto: Producto = listaProductos[position]
        Glide.with(context).load(producto.imagen).placeholder(R.drawable.corteingles).into(holder.imageView)
        holder.textView.setText(producto.nombre)
        holder.botonDetalle.setOnClickListener {
            Snackbar.make(
                holder.itemView,
                "este es el producto ${holder.textView.text}",
                Snackbar.LENGTH_LONG
            ).show()

            val intent: Intent = Intent(context, DetalleActivity::class.java)
            intent.putExtra("producto",producto)
            context.startActivity(intent)
        }

        holder.botonCarrito.setOnClickListener {
            DataSet.aniadirAlCarrito(producto)
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

    interface OnProductoListener{
        fun onCompraProductoSelected();
    }


}

