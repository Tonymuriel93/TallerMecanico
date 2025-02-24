package org.iesalandalus.programacion.tallermecanico.dominio;

import java.util.Objects;

public record Vehiculo(String marca, String modelo, String matricula) {

        private static final String ER_MARCA = "^[a-z][A-Z]*(?:[-]?[A-Z][a-z]+)?|[A-Z]+";
        private static final String ER_MATRICULA = "\\d{4}[^\\W_AEIOUa-z]{3}";



        public Vehiculo {

            validarMarca(marca);
            validarModelo(modelo);
            validarMatricula(matricula);
        }

        private void validarMarca(String marca) {
            Objects.requireNonNull(marca, "La marca no puede ser nula.");
            if(!marca.matches(ER_MARCA)) {
                throw new IllegalArgumentException("La marca no tiene un formato no valido.");


            }
        }

        private void validarModelo(String modelo) {
                Objects.requireNonNull(modelo, "El modelo no puede ser nulo.");
                if (modelo.isBlank()) {
                    throw new IllegalArgumentException("El modelo no puede estar en blanco.");
                }




        }

        private void validarMatricula(String matricula){
                Objects.requireNonNull(matricula, "La matricula no puede ser nula.");
                if (matricula.matches(ER_MATRICULA)) {
                    throw new IllegalArgumentException("La matricula no tiene un formato valido.")
                }
            }

            public static Vehiculo get(String matricula) {return new Vehiculo("Seat", "Leon", matricula);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehiculo vehiculo  return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(marca, vehiculo.marca) && Objects.equals(modelo, vehiculo.modelo) && Objects.equals(matricula, vehiculo.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo, matricula);
    }
}



