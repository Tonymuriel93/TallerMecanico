package org.iesalandalus.programacion.tallermecanico.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Revision {

    private static final float PRECIO_HORA = 30F;
    private static final float PRECIO_DIA = 10F;
    private static final float PRECIO_MATERIAL = 1.5F;
    static final  DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int horas;
    private float precioMaterial;

    public Revision(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio) {
        setCliente(cliente);
        setVehiculo(vehiculo);
        setFechaInicio(fechaInicio);
        fechaFin = null;
        horas = 0;
        precioMaterial = 0;

    }

    public Revision(Revision revision) {
        Objects.requireNonNull(revision,"La revision no puede ser nula");
        cliente = new Cliente(revision.cliente);
        vehiculo = revision.vehiculo;
        fechaInicio = revision.fechaInicio;
        fechaFin = revision.fechaFin;
        horas = revision.horas;
        precioMaterial = revision.precioMaterial;
    }

    public Cliente getCliente() {
        return cliente;
    }

    private void setCliente(Cliente cliente) {
        Objects.requireNonNull(cliente, "El cliente no puede ser nulo.");
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return getVehiculo();
    }

    private void setVehiculo( Vehiculo vehiculo) {
        Objects.requireNonNull(vehiculo, "El vehiculo no puede ser nulo.");
        this.vehiculo = vehiculo;
    }

    public LocalDate getFechaInicio() {
        return getFechaInicio();
    }

    private void setFechaInicio(LocalDate fechaInicio) {
        Objects.requireNonNull(fechaInicio, "La fecha de inicio no puede ser nula.");
        if(fechaInicio.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("la fecha de inicio no puede ser futura.");
        }

        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return getFechaFin();
    }

    private void setFechaFin(LocalDate fechaFin) {
        Objects.requireNonNull(fechaFin, "La fecha de fin no puede ser nula.");
        if(fechaFin.isBefore(fechaInicio)) {
            throw new IllegalArgumentException("La fecha fin no puede ser anterior a la fecha de inicio.");
        }
        if(fechaFin.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de fin no puede ser futura.");
        }
        this.fechaFin = fechaFin;

    }

    public int getHoras() {
        return getHoras();
    }

    public void añadirHoras(int horas) throws TallerMecanicoExcepcion {
        if(horas <= 0) {
            throw new IllegalArgumentException("Las horas a añadir deben ser mayores que cero.");
        }
        if(estaCerrada()) {
            throw new TallerMecanicoExcepcion("No se puede añadir horas, ya que la revision está cerrada.");
        }
        this.horas = horas;

    }

    public float getPrecioMaterial() {
        return getPrecioMaterial();
    }

    public void añadirPrecioMaterial(float precioMaterial) throws

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
