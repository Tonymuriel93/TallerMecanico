package org.iesalandalus.programacion.tallermecanico.dominio;

import java.util.Objects;

public class Cliente {

    private static final String ER_NOMBRE = "";
    private static final String ER_DNI = "\\d{8}[^\\W\\da-zOUI]";
    private static final String ER_TELEFONO = "";
    private String nombre;
    private String dni;
    private String telefono;

    public Cliente(String nombre, String dni, String telefono) {

        setNombre(nombre);
        setDni(dni);
        setTelefono(telefono);
    }

    public Cliente(Cliente cliente) {

        Objects.requireNonNull(cliente, "El cliente no puede ser nulo");
        nombre = cliente.nombre;
        dni = cliente.dni;
        telefono = cliente.telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    private void setDni(String dni) {
        this.dni = dni;
    }

    private boolean comprobarLetraDni(String dni) {

        





    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return String.format("[nombre=%s, dni=%s, telefono=%s]", nombre, dni, telefono);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nombre, cliente.nombre) && Objects.equals(dni, cliente.dni) && Objects.equals(telefono, cliente.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, dni, telefono);
    }
}





