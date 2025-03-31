package org.iesalandalus.programacion.tallermecanico.vista;

import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Trabajo;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

import java.time.LocalDate;

public interface Modelo {
    void comenzar();

    void terminar();

    void insertar(Cliente cliente) throws TallerMecanicoExcepcion;

    void insertar(Vehiculo vehiculo) throws TallerMecanicoExcepcion;

    void insertar(Trabajo trabajo) throws TallerMecanicoExcepcion;

    Cliente buscar(Cliente cliente);

    Vehiculo buscar(Vehiculo vehiculo);

    Trabajo buscar(Trabajo trabajo);

    Cliente modificar(Cliente cliente, String nombre, String telefono) throws TallerMecanicoExcepcion;

    Trabajo anadirHoras(Trabajo trabajo, int horas) throws TallerMecanicoExcepcion;

    Trabajo anadirPrecioMaterial(Trabajo trabajo, float precioMaterial) throws  TallerMecanicoExcepcion;

    Trabajo cerrar(Trabajo trabajo, LocalDate fechaFin) throws TallerMecanicoExcepcion;

    void borrar(Cliente cliente) throws TallerMecanicoExcepcion;

    void borrar(Vehiculo vehiculo) throws TallerMecanicoExcepcion;

    void borrar(Trabajo trabajo) throws TallerMecanicoExcepcion;
}
