package com.example.mvcdeelduro.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvcdeelduro.R
import com.example.mvcdeelduro.controller.TareasController
import com.example.mvcdeelduro.model.Tarea

class TareasAdapter : RecyclerView.Adapter<TareasAdapter.TareaViewHolder>() {
    private val tareas = mutableListOf<Tarea>()
    private lateinit var tareasController: TareasController

    fun setTareasController(controller: TareasController) {
        tareasController = controller
    }

    fun setTareas(nuevasTareas: List<Tarea>) {
        tareas.clear()
        tareas.addAll(nuevasTareas)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_tarea, parent, false)
        return TareaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TareaViewHolder, position: Int) {
        val tarea = tareas[position]
        holder.bind(tarea)
    }

    override fun getItemCount(): Int {
        return tareas.size
    }

    inner class TareaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tarea: Tarea) {
            itemView.findViewById<TextView>(R.id.descripcionTextView).text = tarea.descripcion
            itemView.findViewById<Button>(R.id.eliminarButton).setOnClickListener {
                tareasController.eliminarTarea(tarea.id)
                setTareas(tareasController.obtenerTareas())
            }
        }
    }
}