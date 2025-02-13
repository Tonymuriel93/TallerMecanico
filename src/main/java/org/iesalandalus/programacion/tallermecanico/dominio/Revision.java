package org.iesalandalus.programacion.tallermecanico.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Revision {

    private static float PRECIO_HORA;
    private static float PRECIO_DIA;
    private static float PRECIO_MATERIAL;
    public static DateTimeFormatter FORMATO_FECHA;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int horas;
    private float precioMaterial;

    public Revision(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio) {

        setCliente(cliente);
        setVehiculo(vehiculo);
        setFechaInicio(fechaInicio);

    }

    public Revision(Revision revision) {

        Objects.requireNonNull(revision,"La revision no puede ser nula");
        fechaInicio = revision.fechaInicio;
        fechaFin = revision.fechaFin;
        horas = revision.horas;
        precioMaterial = revision.precioMaterial;
    }

    public Cliente getCliente() {

        return getCliente();

    }

    private void setCliente(Cliente cliente) {

        this.cliente = cliente;
    }









}
