package org.iesalandalus.programacion.tallermecanico.vista.eventos;

import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;

import java.util.HashMap;
import java.util.Map;

public enum Evento {
    INSERTAR_CLIENTE(11, "Insertar cliente."),
    BUSCAR_CLIENTE(12, "Buscar cliente."),
    BORRAR_CLIENTE(13, "Borrar cliente."),
    LISTAR_CLIENTES(14, "Listar clientes."),
    MODIFICAR_CLIENTE(15, "Modificar cliente."),
    INSERTAR_VEHICULO(21, "Insertar vehiculo."),
    BUSCAR_VEHICULO(22, "Buscar vehiculo."),
    BORRAR_VEHICULO(23, "Borrar vehiculo."),
    LISTAR_VEHICULOS(24, "Listar vehiculos."),
    INSERTAR_REVISION(31, "Insertar trabajo de revisión."),
    INSERTAR_MECANICO(32,"Insertar trabajo mecánico."),
    BUSCAR_TRABAJO(33, "Buscar trabajo."),
    BORRAR_TRABAJO(34, "Borrar trabajo"),
    LISTAR_TRABAJOS(35, "Listar trabajos."),
    LISTAR_TRABAJOS_CLIENTE(35, "Listar trabajos de un cliente."),
    LISTAR_TRABAJOS_VEHICULO(36, "Listar trabajos de un vehiculo."),
    ANADIR_HORAS_TRABAJO(37, "Añadir horas a un trabajo."),
    ANADIR_PRECIO_MATERIAL_TRABAJO(38, "Añadir precio del material a un trabajo."),
    CERRAR_TRABAJO(39,"Cerrar trabajo."),
    SALIR(0,"Salir.");








    private final int codigo;
    private final String texto;
    private static final Map<Integer>, Evento> eventos = new HashMap();

    static {
        for(Evento evento : values()) {
            eventos.put(evento.codigo,evento);
        }
    }

    private Evento(int codigo, String texto) {
        this.codigo = codigo;
        this.texto = texto;
    }

    public int getCodigo() {return codigo;}

    public static boolean esValido(int codigo) {return eventos.containsKey(codigo);}

    public static Evento get(int codigo) {
        if(!esValido(codigo)) {
            throw new IllegalArgumentException("El código no es correcto.");
        }
        return eventos.get(codigo);
    }

    @Override
    public String toString() {
        return texto;
    }
}
