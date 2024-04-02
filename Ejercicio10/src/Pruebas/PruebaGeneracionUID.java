package Pruebas;

import java.util.UUID;

import static Clases.UID.uuidSet;
import static Metodos.MetodoGenerador.generateAndStoreUUID;

public class PruebaGeneracionUID {
    public static void main(String[] args){
        generateAndStoreUUID();
        generateAndStoreUUID();
        generateAndStoreUUID();

        System.out.println("UUIDs almacenados en la base de datos");
        for (UUID uuid : uuidSet){
            System.out.println(uuid);
        }
    }
}
