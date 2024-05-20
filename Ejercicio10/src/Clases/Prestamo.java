package Clases;
import java.time.LocalDate;
public class Prestamo {
    private final Usuario usuario;
    private final Libro libro;
    private final LocalDate fechaInicio;

    public Prestamo(Usuario  usuario, Libro libro, LocalDate fechaInicio){
        this.usuario = usuario;
        this.libro = libro;
        this.fechaInicio = fechaInicio;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @return Información del préstamo
     */
    @Override
    public String toString() {
        return "Usuario: " + usuario.getNombre() + " (" + usuario.getId() + ")\n" +
                "Libro: " + libro.getTitulo() + " (" + libro.getId() + ")\n" +
                "Fecha de inicio: " + fechaInicio;
    }
}
