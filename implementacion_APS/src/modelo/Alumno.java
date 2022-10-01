package modelo;

public class Alumno {
    private String email;
    private String password;
    private String surname;
    private String name;
    private int legajo_alumno;

    public Alumno(String email, String password, String surname, String name, int legajo_alumno) {
        this.email = email;
        this.password = password;
        this.surname = surname;
        this.name = name;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLegajo_alumno() {
        return legajo_alumno;
    }

    public void setLegajo_alumno(int legajo_alumno) {
        this.legajo_alumno = legajo_alumno;
    }

    
}
