package com.inkdeber.jordan.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Tarea {
    private Long id;
    private String empleado;
    private String proyecto;
    private String descripcion;
    private LocalDate fechaInicio;
    private int diasEstimados;
    private String estado;
    private LocalDate fechaFinal;

    public int getDiasAtrasados() {
        LocalDate hoy = LocalDate.now();
        LocalDate estimada = fechaInicio.plusDays(diasEstimados);
        return hoy.isAfter(estimada) && !estado.equalsIgnoreCase("completado")
                ? estimada.until(hoy).getDays()
                : 0;
    }
}