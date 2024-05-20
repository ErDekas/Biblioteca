package Clases;

import java.util.ArrayList;

public class Libro {
    private final String id;
    private final String titulo;
    private final String autor;
    private boolean disponible;
    private final ArrayList<Prestamo> historicoPrestamos;

    /**
     *
     * @param id Id Libro
     * @param titulo Titulo Libro
     * @param autor Autor Libro
     */
    public Libro(String id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
        this.historicoPrestamos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public ArrayList<Prestamo> getHistoricoPrestamos() {
        return historicoPrestamos;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * @return Información del libro
     */
    @Override
    public String toString() {
        return "ID: " + id + "\nTítulo: " + titulo + "\nAutor: " + autor + "\nDisponible: " + (disponible ? "Sí" : "No");
    }
}
