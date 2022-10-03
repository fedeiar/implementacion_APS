package modelo;

public class Administrador{
    private String email;
    private String password;
    private String nombre;
    private String apellido;
    private int legajo_administrador;

    public Administrador(String email, String password, String nombre, String apellido, int legajo_administrador) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo_administrador = legajo_administrador;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String surname) {
        this.nombre = surname;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String name) {
        this.apellido = name;
    }
    public int getLegajo_administrador() {
        return legajo_administrador;
    }
    public void setLegajo_administrador(int legajo_administrador) {
        this.legajo_administrador = legajo_administrador;
    }    
}