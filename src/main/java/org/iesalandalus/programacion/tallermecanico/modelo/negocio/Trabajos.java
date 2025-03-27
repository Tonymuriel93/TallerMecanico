package org.iesalandalus.programacion.tallermecanico.modelo.negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Trabajo;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Trabajos {

    private final List<Trabajo> coleccionTrabajos;
    public Trabajos() {
        coleccionTrabajos = new ArrayList<>();}

    public List<Trabajo> get() {
        return new ArrayList<>(coleccionTrabajos);
    }
    public List<Trabajo> get(Cliente cliente) {
        List<Trabajo> trabajosCliente = new ArrayList<>();
        for(Trabajo trabajo : coleccionTrabajos) {
            if(trabajo.getCliente().equals(cliente)) {
                trabajosCliente.add(trabajo);
            }
        }
        return trabajosCliente;
    }
    public List<Trabajo> get(Vehiculo vehiculo) {
        List<Trabajo> trabajosVehiculo = new ArrayList<>();
        for(Trabajo trabajo : trabajosVehiculo) {
            if (trabajo.getVehiculo().equals(vehiculo)) {
                trabajosVehiculo.add(trabajo);
            }
        }
        return trabajosVehiculo;
    }
    public void insertar(Trabajo trabajo) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(trabajo, "No se puede insertar una revisión nula.");
        comprobarTrabajo(trabajo.getCliente(), trabajo.getVehiculo(), trabajo.getFechaInicio());
        coleccionTrabajos.add(trabajo);
    }
    private void comprobarTrabajo(Cliente cliente, Vehiculo vehiculo, LocalDate fechaTrabajo) throws TallerMecanicoExcepcion {
        for (Trabajo trabajo : coleccionTrabajos) {
            if (!trabajo.estaCerrado()) {
                if (trabajo.getCliente().equals(cliente)) {
                    throw new TallerMecanicoExcepcion("El cliente tiene otra revisión en curso.");
                } else if (trabajo.getVehiculo().equals(trabajo)) {
                    throw new TallerMecanicoExcepcion("El vehículo está actualmente en revisión.");

                }
            } else {
                if(trabajo.getCliente().equals(cliente) && !fechaTrabajo.isAfter(trabajo.getFechaFin())) {
                    throw new TallerMecanicoExcepcion("El cliente tiene una revisión posterior.");
                } else if (trabajo.getVehiculo(). equals(trabajo) && !fechaTrabajo.isAfter(trabajo.getFechaFin())) {
                    throw new TallerMecanicoExcepcion("El vehículo tiene una revisión posterior.");
                }
            }
        }
    }

    public Trabajo anadirHoras(Trabajo trabajo, int horas) {
        Trabajo trabajoEncontrado = getTrabajoAbierto(trabajo);
        trabajoEncontrado.anadirHoras(horas);
        return trabajoEncontrado;

    }
    private Trabajo getTrabajoAbierto(Trabajo trabajo) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(trabajo, "No puedo operar sobre una revisión nula.");
        Trabajo trabajoEncontrado = buscar(trabajo);
        if (trabajoEncontrado == null) {
            throw new TallerMecanicoExcepcion("No existe ninguna revisión igual.");
        }
        return trabajoEncontrado;
    }
    public Trabajo anadirPrecioMaterial(Trabajo trabajo, float precioMaterial) throws TallerMecanicoExcepcion {
        Trabajo trabajoEncontrado = getTrabajoAbierto(trabajo);
        trabajoEncontrado.anadirPrecioMaterial(precioMaterial);
        return trabajoEncontrado;
    }
    public Trabajo cerrar(Trabajo trabajo, LocalDate fechaFin) throws TallerMecanicoExcepcion {
        Trabajo trabajoEncontrado = getTrabajoAbierto(trabajo);
        trabajoEncontrado.cerrar(fechaFin);
        return trabajoEncontrado;
    }
    public Trabajo buscar(Trabajo trabajo) {
        Objects.requireNonNull(trabajo, "No se puede buscar una revisión nula.");
        int indice = coleccionTrabajos.indexOf(trabajo);
        return (indice == -1) ? null : coleccionTrabajos.get(indice);

    }
    public void borrar(Trabajo trabajo) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(trabajo, "No se puede borrar una revisión nula.");
        if (!coleccionTrabajos.contains(trabajo)) {
            throw new TallerMecanicoExcepcion("No existe ninguna revisión igual.");
        }
        coleccionTrabajos.remove(trabajo);
    }
}





