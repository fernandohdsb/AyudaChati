package com.example.categorias

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.categorias.DataSet.DataSet
import com.example.categorias.adapter.AdapterCategoria
import com.example.categorias.adapter.AdapterSpinner
import com.example.categorias.databinding.ActivityMainBinding
import com.example.categorias.model.Categoria
import com.example.categorias.model.Producto

class MainActivity : AppCompatActivity(), AdapterCategoria.OnProductoListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var categoraSeleccionado: Categoria
    private lateinit var listaCategoria: ArrayList<Categoria>
    private lateinit var adapterSpinner: AdapterSpinner
    private lateinit var listaProductos: ArrayList<Producto>
    private lateinit var adapterCategoria: AdapterCategoria
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)


        instancias()
        initGUI()
        acciones()
    }



    private fun acciones() {

        binding.buttonCarrito.setOnClickListener {
            val intent: Intent = Intent(this, CarritoActivity::class.java)
            startActivity(intent)
        }


        binding.spinnerCategorias.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                 categoraSeleccionado = parent!!.adapter.getItem(position) as Categoria
                 adapterCategoria.actualizar_datos(listaProductos,categoraSeleccionado)


                Log.v("cambiarLista",listaProductos.size.toString())
                Log.v("reciclable",binding.reciclable.adapter.toString())

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

    }

    private fun initGUI() {
        binding.numeroProductos.text = DataSet.listaCarrito.size.toString()
        binding.spinnerCategorias.adapter =adapterSpinner
        binding.reciclable.layoutManager =
            LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
            )

        binding.reciclable.adapter = adapterCategoria
        Log.v("reciclable",binding.reciclable.adapter.toString())


    }

    private fun instancias() {
        listaCategoria = arrayListOf(
            Categoria("Todas",R.drawable.corteingles),
            Categoria("Tecnologia",R.drawable.tecnologia),
            Categoria("Ropa",R.drawable.ropa),
            Categoria("Muebles",R.drawable.muebles),
            Categoria("Belleza",R.drawable.belleza),
        )

        categoraSeleccionado =  Categoria("Todas",R.drawable.corteingles)
        Log.v("categoriaSeleccionada",categoraSeleccionado.categoria)
        listaProductos = DataSet.getCategorias(categoraSeleccionado)
        Log.v("listaProductos",listaProductos.size.toString())
        adapterSpinner = AdapterSpinner(listaCategoria)
        adapterCategoria = AdapterCategoria(listaProductos,this)
    }

    override fun onCompraProductoSelected() {
        binding.numeroProductos.text = DataSet.listaCarrito.size.toString()
    }
}