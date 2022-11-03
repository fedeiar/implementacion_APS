package modelo;

public class Alumno {
    public String email;
    public String password;
    public String nombre;
    public String apellido;
    public int legajo_alumno;

    public Alumno(String email, String password, String nombre, String apellido, int legajo_alumno) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo_alumno = legajo_alumno;
    }
    
}
