package com.example.categorias

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.categorias.DataSet.DataSet
import com.example.categorias.adapter.AdapterCarrito
import com.example.categorias.adapter.AdapterCategoria
import com.example.categorias.databinding.ActivityCarritoBinding
import com.example.categorias.model.Producto

class CarritoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCarritoBinding

    private lateinit var listaProductos: ArrayList<Producto>
    private lateinit var adapterCarrito: AdapterCarrito

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarritoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        instancias()
        initGUI()
        acciones()
    }

    private fun acciones() {


    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initGUI() {
        binding.numeroProductos.text = DataSet.listaCarrito.size.toString()

        binding.reciclable.layoutManager= LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.reciclable.adapter = adapterCarrito
    }

    private fun instancias() {
        listaProductos = DataSet.listaCarrito
        Log.v("carrito",listaProductos.size.toString())
        adapterCarrito = AdapterCarrito(
            listaProductos, this
        )

    }
}