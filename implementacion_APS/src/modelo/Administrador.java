package modelo;

public class Administrador{
    public String email;
    public String password;
    public String nombre;
    public String apellido;
    public int legajo_administrador;

    public Administrador(String email, String password, String nombre, String apellido, int legajo_administrador) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo_administrador = legajo_administrador;
    }
    
}