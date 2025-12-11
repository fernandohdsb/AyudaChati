package com.example.fernando_hernandezdesantamaria_pmdm

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fernando_hernandezdesantamaria_pmdm.adapter.AdapterTareas
import com.example.fernando_hernandezdesantamaria_pmdm.databinding.ActivityMainBinding
import com.example.fernando_hernandezdesantamaria_pmdm.model.Tarea
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: AdapterTareas
    lateinit var listaTareas: ArrayList<Tarea>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
        initGUI()
        acciones()

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun acciones() {
        binding.imageButton.setOnClickListener {view ->

            var url: String =""
            Log.v("valorSpinner", binding.spinner.selectedItem.toString())
            when(binding.spinner.selectedItem.toString()){
                "baja"->{ url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHJqiExDSm_Qf2yXlUOuTDqjcqvisHMspMq2r8lEATMwQKAE6W0OmYfEUaaqpw9sVvvrc&usqp=CAU"}
                "media"->{url = "https://static-00.iconduck.com/assets.00/medium-priority-icon-2048x2048-g3fzjdtl.png"}
                "alta"->{url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPsBD4_YDJYic70mveK7NbYxCYbaWa-i2Yb3KRMMGGurujXObeT8ux7UwXA5vYGMxS1-k&usqp=CAU"}

            }


            if (binding.nombreTarea.text.isNotEmpty() && binding.descripcionTarea.text.isNotEmpty()){
                listaTareas.add(Tarea(binding.nombreTarea.text.toString(),binding.descripcionTarea.text.toString(),url))
                adapter.notifyDataSetChanged()
                Snackbar.make(view,"Se ha añadido la tarea correctamente", Snackbar.LENGTH_LONG).show()
            }else Snackbar.make(view,"No se han rellenado todos los datos correctamente", Snackbar.LENGTH_LONG).show()

            Log.v("listatareas",listaTareas.size.toString())
        }
    }

    private fun initGUI() {
        binding.recycle.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL,false
        )
        binding.recycle.adapter = adapter



    }

    private fun instancias() {
        listaTareas = arrayListOf()
        adapter = AdapterTareas(this,listaTareas)
    }

}