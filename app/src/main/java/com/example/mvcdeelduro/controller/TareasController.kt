package com.example.mvcdeelduro.controller

import com.example.mvcdeelduro.model.Tarea

class TareasController {
    private val tareas = mutableListOf<Tarea>()

    fun agregarTarea(descripcion: String) {
        val nuevaTarea = Tarea(tareas.size + 1, descripcion)
        tareas.add(nuevaTarea)
    }

    fun eliminarTarea(id: Int) {
        tareas.removeAll { it.id == id }
    }

    fun obtenerTareas(): List<Tarea> {
        return tareas.toList()
    }
}