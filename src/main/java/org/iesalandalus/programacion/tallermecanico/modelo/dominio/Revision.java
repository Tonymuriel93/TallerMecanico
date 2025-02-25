package org.iesalandalus.programacion.tallermecanico.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/*public class Revision {

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

    public Vehiculo getVehiculo() {

        return getVehiculo();

    }

    private void setVehiculo( Vehiculo vehiculo) {

        this.vehiculo = vehiculo;

    }

    public LocalDate getFechaInicio() {

        return getFechaInicio();

    }

    private void setFechaInicio(LocalDate fechaInicio) {

        this.fechaInicio = fechaInicio;

    }

    public LocalDate getFechaFin() {

        return getFechaFin();

    }

    private void setFechaFin(LocalDate fechaFin) {

        this.fechaFin = fechaFin;

    }

    public int getHoras() {

        return getHoras();
    }

    public void añadirHoras(int horas) {



    }

    public float getPrecioMaterial() {

        return getPrecioMaterial();
    }

    public void añadirPrecioMaterial(float precioMaterial) {

    }

    public boolean estaCerrada() {

    }

    public void cerrar (LocalDate fechaFin) {

    }

    public float getPrecio() {

        return getPrecio();

    }

    private float getDias() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Revision revision = (Revision) o;
        return horas == revision.horas && Float.compare(precioMaterial, revision.precioMaterial) == 0 && Objects.equals(fechaInicio, revision.fechaInicio) && Objects.equals(fechaFin, revision.fechaFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaInicio, fechaFin, horas, precioMaterial);
    }

    @Override
    public String toString() {
        return String.format("[fechaInicio=%s, fechaFin=%s, horas=%s, precioMaterial=%s]", fechaInicio, fechaFin, horas, precioMaterial);
    }
}
*/