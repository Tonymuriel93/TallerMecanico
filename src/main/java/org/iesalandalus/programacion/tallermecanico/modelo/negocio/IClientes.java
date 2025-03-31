package org.iesalandalus.programacion.tallermecanico.modelo.negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;

import java.util.ArrayList;
import java.util.Objects;

public interface IClientes {

    public Cliente get() {
    }

    public insertar(Cliente cliente) {

    }

    public Cliente modificar(Cliente cliente, String nombre, String telefono) {

    }

    public Cliente buscar(Cliente cliente) {
        public Cliente buscar(Cliente cliente) {
            Objects.requireNonNull(cliente, "No se puede buscar un cliente nulo.");
            int indice = coleccionClientes.indexOf(cliente);
            return (indice == -1) ? null: coleccionClientes.get(indice);
    }

    public borrar (Cliente cliente) {


    }
}
