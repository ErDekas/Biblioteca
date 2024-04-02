package Clases;
import java.util.HashSet;
public abstract class usuario {
    protected String nombre;
    private String password;
    public String getNombre(){
        return nombre;
    }
    public String getPassword(){
        return password;
    }
    public void setNombre(){
        this.nombre = nombre;
    }
    public void setPassword(){
        this.password = password;
    }
    public usuario(String nombre, String password){
        this.nombre = nombre;
        this.password = password;
    }
}
