package Metodos;

import java.util.UUID;

public class MetodoAlmacenamiento {
    public static void storeInDatabase(UUID uuid){
        System.out.println("Guardando UUID en la base de datos: " + uuid);
    }
}
