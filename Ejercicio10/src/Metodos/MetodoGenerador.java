package Metodos;

import java.util.UUID;

import static Clases.UID.uuidSet;
import static Metodos.MetodoAlmacenamiento.storeInDatabase;

public class MetodoGenerador {
    public static void generateAndStoreUUID(){
        UUID newUUID = UUID.randomUUID();

        if(!uuidSet.contains(newUUID)){
            uuidSet.add(newUUID);
            storeInDatabase(newUUID);
        }
    }
}
