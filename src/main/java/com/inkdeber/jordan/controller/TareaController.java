package com.inkdeber.jordan.controller;

import com.inkdeber.jordan.service.TareaService;
import com.inkdeber.jordan.model.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;


    @GetMapping
    public List<Tarea> obtenerTareas() {
        return tareaService.getAllTareas();
    }


    @GetMapping("/atrasadas")
    public List<Tarea> obtenerTareasAtrasadas() {
        return tareaService.getAllTareas().stream()
                .filter(t -> t.getDiasAtrasados() > 0)
                .toList();
    }


    @PostMapping
    public Tarea crearTarea(@RequestBody Tarea nuevaTarea) {
        return tareaService.agregarTarea(nuevaTarea);
    }


    @PutMapping("/{id}")
    public Tarea actualizarTarea(@PathVariable Long id, @RequestBody Tarea tareaActualizada) {
        return tareaService.actualizarTarea(id, tareaActualizada);
    }


    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable Long id) {
        tareaService.eliminarTarea(id);
    }
}