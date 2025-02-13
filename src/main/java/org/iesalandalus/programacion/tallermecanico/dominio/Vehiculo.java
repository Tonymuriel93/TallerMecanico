package org.iesalandalus.programacion.tallermecanico.dominio;

import java.util.Objects;

public record Vehiculo() {

        private static String ER_MARCA;
        private static String ER_MATRICULA;
        private String marca;
        private String modelo;
        private String matricula;

        public Vehiculo(String marca, String modelo, String matricula) {

            setMarca(marca);
            setModelo(modelo);
            setMatricula(matricula);
        }

        private validarMarca(String marca) {

            if()



        }

        private validarModelo(String modelo) {


        }

        private validarMatricula(String matricula) {


        }

        public static getVehiculo( String matricula) {

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            org.iesalandalus.programacion.tallermecanico.dominio.Vehiculo vehiculo = (org.iesalandalus.programacion.tallermecanico.dominio.Vehiculo) o;
            return Objects.equals(marca, vehiculo.marca) && Objects.equals(modelo, vehiculo.modelo) && Objects.equals(matricula, vehiculo.matricula);
        }

        @Override
        public int hashCode() {
            return Objects.hash(marca, modelo, matricula);
        }

        @Override
        public String toString() {
            return String.format("[marca=%s, modelo=%s, matricula=%s]", marca, modelo, matricula);
        }
    }

}
