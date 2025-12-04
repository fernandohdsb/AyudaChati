package com.example.categorias

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.categorias.DataSet.DataSet
import com.example.categorias.databinding.ActivityDetalleBinding
import com.example.categorias.model.Producto
import com.google.android.material.snackbar.Snackbar

class DetalleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalleBinding
    private lateinit var producto: Producto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        initGUI()
        acciones()
        producto = intent.getSerializableExtra("producto") as Producto

        binding.nombreProducto.text = producto.nombre
        binding.precioProducto.text = producto.precio.toString()
        Glide.with(this).load(producto.imagen).placeholder(R.drawable.corteingles).into(binding.imagenProducto)

    }

    private fun acciones() {
        binding.botonVolver.setOnClickListener { view ->
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.botonAAdirCarro.setOnClickListener { view ->
            DataSet.aniadirAlCarrito(producto)
            Snackbar.make(binding.root,"El producto ${binding.nombreProducto} se ha agregado correctamente.",
                Snackbar.LENGTH_LONG).show()
        }
    }

    private fun initGUI() {

    }

    private fun instancias() {

    }


}