package org.iesalandalus.programacion.tallermecanico.modelo.dominio;

import java.time.LocalDate;

public class Trabajo {

    private static final float FACTOR_DIA = 30F;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int horas;

    protected Trabajo(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio) {

    }

    protected Trabajo(Trabajo trabajo) {

    }

    public Trabajo copiar(Trabajo trabajo) {

    }

    public Trabajo get(Vehiculo vehiculo) {

    }

    public Cliente getCliente() {

    }





}
