package org.iesalandalus.programacion.tallermecanico.modelo.dominio;

import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Trabajo {

    static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final float FACTOR_DIA = 10F;

    private Cliente cliente;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int horas;
    private Vehiculo vehiculo;


    protected Trabajo(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio) {
        setCliente(cliente);
        setVehiculo(vehiculo);
        setFechaInicio(fechaInicio);
        fechaFin = null;
        horas = 0;
    }

    protected Trabajo(Trabajo trabajo) {
        Objects.requireNonNull(trabajo, "El trabajo no puede ser nulo.");
        cliente = new Cliente(trabajo.cliente);
        vehiculo = trabajo.vehiculo;
        fechaInicio = trabajo.fechaInicio;
        fechaFin = trabajo.fechaFin;
        horas = trabajo.horas;

    }

    public Trabajo copiar(Trabajo trabajo) {
        Objects.requireNonNull(trabajo, "El trabajo no puede ser nulo.");
        Trabajo trabajoCopiado = null;
        if ( trabajo instanceof  Revision revision) {
            trabajoCopiado = new Revision(revision);
        } else if (trabajo instanceof Mecanico mecanico) {
            trabajoCopiado = new Mecanico(mecanico);
        }
        return trabajoCopiado;
    }

    public Trabajo get(Vehiculo vehiculo) {
        Objects.requireNonNull(vehiculo, "El vehiculo no puede ser nulo.");
        return new Revision(Cliente.get("11111111H"), vehiculo, LocalDate.now());
    }

    public Cliente getCliente() {

    }

    private setCliente(Cliente cliente) {

    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    private setVehiculo() {

    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    private setFechaInicio() {

    }
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    }

    private setFechaFin(LocalDate fechaFin) {
        private void setFechaFin(LocalDate fechaFin) {
            Objects.requireNonNull(fechaFin, "La fecha de fin no puede ser nula.");
            if(fechaFin.isBefore(fechaInicio)) {
                throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la fecha de inicio.");
            }
            if(fechaFin.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("La fecha de fin no puede ser futura.");
            }
            this.fechaFin = fechaFin;
    }
        public int getHoras() {
            return horas;
        }

    }
            public void anadirHoras(int horas) throws TallerMecanicoExcepcion {
                if(horas <= 0) {
                    throw new IllegalArgumentException("Las horas a añadir deben ser mayores que cero.");
                }
                if(estaCerrada()) {
                    throw new TallerMecanicoExcepcion("No se puede añadir horas, ya que la revisión está cerrada.");
                }
                this.horas += horas;

    }
        public boolean estaCerrado() {
            return fechaFin != null;
        }

        public void cerrar (LocalDate fechaFin) throws TallerMecanicoExcepcion {
            if (estaCerrada()) {
                throw new TallerMecanicoExcepcion("La revisión ya está cerrada.");
            }
            setFechaFin(fechaFin);


    }

    public float getPrecio() {

    }



}


