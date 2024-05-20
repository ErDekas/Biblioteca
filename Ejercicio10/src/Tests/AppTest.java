package Tests;

import Metodos.*;
import Clases.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
public class AppTest {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        Biblioteca biblioteca = new Biblioteca();

        int opcion;
        do{
            mostrarMenu();
            try{
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        registrarUsuario(biblioteca);
                        break;
                    case 2:
                        verInformacionUsuario(biblioteca);
                        break;
                    case 3:
                        registrarLibro(biblioteca);
                        break;
                    case 4:
                        verInformacionLibro(biblioteca);
                        break;
                    case 5:
                        realizarPrestamo(biblioteca);
                        break;
                    case 6:
                        finalizarPrestamo(biblioteca);
                        break;
                    case 7:
                        consultarLibrosDisponibles(biblioteca);
                        break;
                    case 8:
                        consultarPrestamosActivos(biblioteca);
                        break;
                    case 9:
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida. Inténtalo de nuevo.");
                }
            }catch (InputMismatchException e) {
                System.out.println("Error: Ingresa un número válido.");
                scanner.nextLine();
                opcion = 0;
            }
        }while (opcion != 9);
    }
    private static void mostrarMenu(){
        System.out.println("----- Menú -----");
        System.out.println("1. Registrar nuevo usuario");
        System.out.println("2. Ver información de usuario");
        System.out.println("3. Registrar nuevo libro");
        System.out.println("4. Ver información de libro");
        System.out.println("5. Realizar préstamo");
        System.out.println("6. Finalizar préstamo");
        System.out.println("7. Consultar libros disponibles");
        System.out.println("8. Consultar préstamos activos");
        System.out.println("9. Salir");
        System.out.print("Elige una opción: ");
    }
    private static void registrarUsuario(Biblioteca biblioteca) {
        System.out.println("Registro de nuevo usuario");
        System.out.print("Ingrese el ID del usuario: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el correo del usuario: ");
        String correo = scanner.nextLine();

        try {
            biblioteca.registrarUsuario(id, nombre, correo);
            System.out.println("Usuario registrado correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void verInformacionUsuario(Biblioteca biblioteca) {
        System.out.println("Ingrese el ID del usuario:");
        String id = scanner.nextLine();
        Usuario usuario = biblioteca.buscarUsuario(id);
        if (usuario != null) {
            System.out.println("Información del usuario:");
            System.out.println(usuario);
        } else {
            System.out.println("No se encontró ningún usuario con ese ID.");
        }
    }

    private static void registrarLibro(Biblioteca biblioteca) {
        System.out.println("Registro de nuevo libro");
        System.out.print("Ingrese el ID del libro: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();

        try {
            biblioteca.registrarLibro(id, titulo, autor);
            System.out.println("Libro registrado correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void verInformacionLibro(Biblioteca biblioteca) {
        System.out.println("Ingrese el ID del libro:");
        String id = scanner.nextLine();
        Libro libro = biblioteca.buscarLibro(id);
        if (libro != null) {
            System.out.println("Información del libro:");
            System.out.println(libro);
        } else {
            System.out.println("No se encontró ningún libro con ese ID.");
        }
    }

    private static void realizarPrestamo(Biblioteca biblioteca) {
        System.out.println("Realizar préstamo");
        System.out.print("Ingrese el ID del usuario: ");
        String idUsuario = scanner.nextLine();
        System.out.print("Ingrese el ID del libro: ");
        String idLibro = scanner.nextLine();

        try {
            biblioteca.realizarPrestamo(idUsuario, idLibro);
            System.out.println("Préstamo realizado correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void finalizarPrestamo(Biblioteca biblioteca) {
        System.out.println("Finalizar préstamo");
        System.out.print("Ingrese el ID del usuario: ");
        String idUsuario = scanner.nextLine();
        System.out.print("Ingrese el ID del libro: ");
        String idLibro = scanner.nextLine();

        try {
            biblioteca.finalizarPrestamo(idUsuario, idLibro);
            System.out.println("Préstamo finalizado correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static void consultarLibrosDisponibles(Biblioteca biblioteca) {
        List<Libro> librosDisponibles = biblioteca.consultarLibrosDisponibles();
        if (librosDisponibles.isEmpty()) {
            System.out.println("No hay libros disponibles en este momento.");
        } else {
            System.out.println("Libros disponibles:");
            for (Libro libro : librosDisponibles) {
                System.out.println(libro);
            }
        }
    }

    private static void consultarPrestamosActivos(Biblioteca biblioteca) {
        List<Prestamo> prestamosActivos = biblioteca.consultarPrestamosActivos();
        if (prestamosActivos.isEmpty()) {
            System.out.println("No hay préstamos activos en este momento.");
        } else {
            System.out.println("Préstamos activos:");
            for (Prestamo prestamo : prestamosActivos) {
                System.out.println(prestamo);
            }
        }
    }
}
