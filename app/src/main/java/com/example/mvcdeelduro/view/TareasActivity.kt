package com.example.mvcdeelduro.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvcdeelduro.R
import com.example.mvcdeelduro.controller.TareasController

class TareasActivity : AppCompatActivity() {
    private val tareasController = TareasController()
    private val tareasAdapter = TareasAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tareas)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = tareasAdapter

        val agregarButton = findViewById<Button>(R.id.agregarButton)
        val descripcionEditText = findViewById<EditText>(R.id.descripcionEditText)

        tareasAdapter.setTareasController(tareasController)

        agregarButton.setOnClickListener {
            val descripcion = descripcionEditText.text.toString()
            if (descripcion.isNotEmpty()) {
                tareasController.agregarTarea(descripcion)
                actualizarListaTareas()
                descripcionEditText.text.clear()
            }
        }
    }

    private fun actualizarListaTareas() {
        tareasAdapter.setTareas(tareasController.obtenerTareas())
    }
}