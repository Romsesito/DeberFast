package com.inkdeber.jordan.service;

import com.inkdeber.jordan.model.Tarea;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TareaService {
    private List<Tarea> tareas = new ArrayList<>();

    public TareaService() {
        // Datos quemados
        Tarea t1 = new Tarea();
        t1.setId(1L);
        t1.setEmpleado("Carlos");
        t1.setProyecto("Proyecto A");
        t1.setDescripcion("Documentar módulo X");
        t1.setFechaInicio(LocalDate.of(2025, 4, 13));
        t1.setDiasEstimados(2);
        t1.setEstado("pendiente");

        Tarea t2 = new Tarea();
        t2.setId(2L);
        t2.setEmpleado("Ana");
        t2.setProyecto("Proyecto B");
        t2.setDescripcion("Desarrollar módulo Y");
        t2.setFechaInicio(LocalDate.of(2025, 4, 15));
        t2.setDiasEstimados(3);
        t2.setEstado("pendiente");

        tareas.add(t1);
        tareas.add(t2);
    }

    public List<Tarea> getAllTareas() {
        return tareas;
    }

    public Tarea agregarTarea(Tarea tarea) {
        tarea.setId((long) (tareas.size() + 1)); // Generar ID simple
        tareas.add(tarea);
        return tarea;
    }

    public Tarea actualizarTarea(Long id, Tarea tareaActualizada) {
        Tarea tarea = getTareaPorId(id);
        if (tarea != null) {
            tarea.setEmpleado(tareaActualizada.getEmpleado());
            tarea.setProyecto(tareaActualizada.getProyecto());
            tarea.setDescripcion(tareaActualizada.getDescripcion());
            tarea.setFechaInicio(tareaActualizada.getFechaInicio());
            tarea.setDiasEstimados(tareaActualizada.getDiasEstimados());
            tarea.setEstado(tareaActualizada.getEstado());
        }
        return tarea;
    }

    public void eliminarTarea(Long id) {
        tareas.removeIf(t -> t.getId().equals(id));
    }

    public Tarea getTareaPorId(Long id) {
        return tareas.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }
}