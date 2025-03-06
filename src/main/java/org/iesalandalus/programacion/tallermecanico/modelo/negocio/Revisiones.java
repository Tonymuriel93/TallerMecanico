package org.iesalandalus.programacion.tallermecanico.modelo.negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Revisiones {

    private final List<Revision> coleccionRevisiones;
    public Revisiones() {coleccionRevisiones = new ArrayList<>();}

    public List<Revision> get() {
        return new ArrayList<>(coleccionRevisiones);
    }
    public List<Revision> get(Cliente cliente) {
        List<Revision> revisionesCliente = new ArrayList<>();
        for(Revision revision = coleccionRevisiones) {
            if(revision.getCliente().equals(cliente)) {
                revisionesCliente.add(revision);
            }
        }
        return revisionesCliente;
    }
    public List<Revision> get(Vehiculo vehiculo) {
        List<Revision> revisionesVehiculo = new ArrayList<>();
        for(Revision revision : coleccionRevisiones) {
            if (revision.getVehiculo().equals(vehiculo)) {
                revisionesVehiculo.add(revision);
            }
        }
        return revisionesVehiculo;
    }
    public void insertar(Revision revision) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(revision, "No se puede insertar una revision nula.");
        comprobarRevision(revision.getCliente(), revision.getVehiculo(), revision.getFechaInicio());
        coleccionRevisiones.add(revision);
    }
    private void comprobarRevision(Cliente cliente, Vehiculo vehiculo, LocalDate fechaRevision) throws TallerMecanicoExcepcion {
        for (Revision revision : coleccionRevisiones) {
            if (!revision.estaCerrada()) {
                if (revision.getCliente().equals(cliente)) {
                    throw new TallerMecanicoExcepcion("El cliente tiene otra revisión en curso.");
                } else if (revision.getVehiculo().equals(vehiculo)) {
                    throw new TallerMecanicoExcepcion("El vehiculo esta actualmente en revisión.");
                }
            } else {
                if(revision.getCliente().equals(cliente) && !fechaRevision.isAfter(revision.getFechaFin())) {
                    throw new TallerMecanicoExcepcion("El cliente tiene una revision posterior.");
                } else if (revision.getVehiculo(). equals(vehiculo) && !fechaRevision.isAfter(revision.getFechaFin())) {
                    throw new TallerMecanicoExcepcion("El vehiculo tiene una revision posterior.");
                }
            }
        }
    }

    public Revision anadirHoras(Revision revision, int horas) throws TallerMecanicoExcepcion {
        Revision revisionEncontrada = getRevision(revision);
        revisionEncontrada.anadirHoras(horas);
        return revisionEncontrada;
    }
    private Revision getRevision(Revision revision) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(revision, "No puedo operar sobre una revisión nula.");
        Revision revisionEncontrada = buscar(revision);
        if (revisionEncontrada == null) {
            throw new TallerMecanicoExcepcion("No existe ninguna revision igual.");
        }
        return revisionEncontrada;
    }
    public Revision anadirPrecioMaterial(Revision revision, float precioMaterial) throws TallerMecanicoExcepcion {
        Revision revisionEncontrada = getRevision(revision);
        revisionEncontrada
    }

}

