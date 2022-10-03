package modelo;

public class Alumno {
    private String email;
    private String password;
    private String apellido;
    private String nombre;
    private int legajo_alumno;

    public Alumno(String email, String password, String nombre, String apellido, int legajo_alumno) {
        this.email = email;
        this.password = password;
        this.apellido = apellido;
        this.nombre = apellido;
        this.legajo_alumno = legajo_alumno;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String surname) {
        this.apellido = surname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String name) {
        this.nombre = name;
    }

    public int getLegajo_alumno() {
        return legajo_alumno;
    }

    public void setLegajo_alumno(int legajo_alumno) {
        this.legajo_alumno = legajo_alumno;
    }

    
}
