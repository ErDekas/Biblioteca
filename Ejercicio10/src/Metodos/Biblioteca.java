package Metodos;

import Clases.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

public class Biblioteca {
    private final ArrayList<Usuario> usuarios;
    private final ArrayList<Libro> libros;
    private final HashMap<String, ArrayList<Prestamo>> historicoPrestamosUsuario;
    private final HashMap<String, ArrayList<Prestamo>> historicoPrestamosLibro;
    private final LinkedHashSet<Prestamo> prestamosActivos;

    public Biblioteca() {
        this.usuarios = new ArrayList<>();
        this.libros = new ArrayList<>();
        this.historicoPrestamosUsuario = new HashMap<>();
        this.historicoPrestamosLibro = new HashMap<>();
        this.prestamosActivos = new LinkedHashSet<>();
    }

    public void registrarUsuario(String id, String nombre, String correo) {
        // Verificar si el ID ya está en uso
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                throw new IllegalArgumentException("El ID de usuario ya está en uso.");
            }
        }
        // Verificar si el correo ya está en uso
        for (Usuario usuario : usuarios) {
            if (usuario.getCorreo().equals(correo)) {
                throw new IllegalArgumentException("El correo ya está asociado a otro usuario.");
            }
        }
        // Crear y registrar el nuevo usuario
        Usuario nuevoUsuario = new Usuario(id, nombre, correo);
        usuarios.add(nuevoUsuario);
        historicoPrestamosUsuario.put(id, new ArrayList<>());
    }

    public Usuario buscarUsuario(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    public void registrarLibro(String id, String titulo, String autor) {
        // Verificar si el ID ya está en uso
        for (Libro libro : libros) {
            if (libro.getId().equals(id)) {
                throw new IllegalArgumentException("El ID de libro ya está en uso.");
            }
        }
        // Crear y registrar el nuevo libro
        Libro nuevoLibro = new Libro(id, titulo, autor);
        libros.add(nuevoLibro);
        historicoPrestamosLibro.put(id, new ArrayList<>());
    }

    public Libro buscarLibro(String id) {
        for (Libro libro : libros) {
            if (libro.getId().equals(id)) {
                return libro;
            }
        }
        return null;
    }

    public void realizarPrestamo(String idUsuario, String idLibro) {
        Usuario usuario = buscarUsuario(idUsuario);
        if (usuario == null) {
            throw new IllegalArgumentException("No se encontró ningún usuario con ese ID.");
        }

        Libro libro = buscarLibro(idLibro);
        if (libro == null) {
            throw new IllegalArgumentException("No se encontró ningún libro con ese ID.");
        }

        if (!libro.isDisponible()) {
            throw new IllegalArgumentException("El libro no está disponible en este momento.");
        }

        Prestamo prestamo = new Prestamo(usuario, libro, LocalDate.now());
        historicoPrestamosUsuario.get(idUsuario).add(prestamo);
        historicoPrestamosLibro.get(idLibro).add(prestamo);
        prestamosActivos.add(prestamo);

        libro.setDisponible(false);
    }

    public void finalizarPrestamo(String idUsuario, String idLibro) {
        for (Prestamo prestamo : prestamosActivos) {
            if (prestamo.getUsuario().getId().equals(idUsuario) && prestamo.getLibro().getId().equals(idLibro)) {
                prestamosActivos.remove(prestamo);
                prestamo.getLibro().setDisponible(true);
                return;
            }
        }
        throw new IllegalArgumentException("No se encontró ningún préstamo activo con esos ID de usuario y libro.");
    }

    public List<Libro> consultarLibrosDisponibles() {
        List<Libro> disponibles = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                disponibles.add(libro);
            }
        }
        return disponibles;
    }

    public List<Prestamo> consultarPrestamosActivos() {
        return new ArrayList<>(prestamosActivos);
    }

    // Otros métodos según sea necesario
}
