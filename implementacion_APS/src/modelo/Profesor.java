package modelo;

public class Profesor {
    
    public String email;
    public String password;
    public String apellido;
    public String nombre;
    public int legajo_docente;

    public Profesor(String email, String password, String nombre, String apellido, int legajo_docente) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo_docente = legajo_docente;
    }
}

