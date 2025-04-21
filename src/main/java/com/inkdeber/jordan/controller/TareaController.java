package com.inkdeber.jordan.controller;

import com.inkdeber.jordan.service.TareaService;
import com.inkdeber.jordan.model.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController // Cambiado a RestController para devolver JSON
@RequestMapping("/api/tareas") // Prefijo para todos los endpoints
public class TareaController {

    @Autowired
    private TareaService tareaService;

    // Obtener todas las tareas
    @GetMapping
    public List<Tarea> obtenerTareas() {
        return tareaService.getAllTareas();
    }

    // Obtener tareas atrasadas
    @GetMapping("/atrasadas")
    public List<Tarea> obtenerTareasAtrasadas() {
        return tareaService.getAllTareas().stream()
                .filter(t -> t.getDiasAtrasados() > 0)
                .toList();
    }

    // Crear una nueva tarea
    @PostMapping
    public Tarea crearTarea(@RequestBody Tarea nuevaTarea) {
        return tareaService.agregarTarea(nuevaTarea);
    }

    // Actualizar una tarea existente
    @PutMapping("/{id}")
    public Tarea actualizarTarea(@PathVariable Long id, @RequestBody Tarea tareaActualizada) {
        return tareaService.actualizarTarea(id, tareaActualizada);
    }

    // Eliminar una tarea
    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable Long id) {
        tareaService.eliminarTarea(id);
    }
}