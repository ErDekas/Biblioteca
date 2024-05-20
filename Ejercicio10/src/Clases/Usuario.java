package Clases;

import java.util.ArrayList;


public class Usuario {
    private final String id;
    private final String nombre;
    private final String correo;
    private final ArrayList<Prestamo> historicoPrestamos;

    /**
     *
     * @param id Identificador del Usuario
     * @param nombre Nombre del usuario
     * @param correo Correo del usuario
     */
    public Usuario(String id, String nombre, String correo){
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.historicoPrestamos = new ArrayList<>();
    }

    /**
     *
     * @return Correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     *
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return Historial de prestamos
     */
    public ArrayList<Prestamo> getHistoricoPrestamos() {
        return historicoPrestamos;
    }

    /**
     * @return Información del usuario
     */
    @Override
    public String toString() {
        return "ID: " + id + "\nNombre: " + nombre + "\nCorreo: " + correo;
    }
}
