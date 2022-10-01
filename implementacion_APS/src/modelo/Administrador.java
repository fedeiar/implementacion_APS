package modelo;

class Administrador{
    private String email;
    private String password;
    private String surname;
    private String name;
    private int legajo_administrador;

    public Administrador(String email, String password, String surname, String name, int legajo_administrador) {
        this.email = email;
        this.password = password;
        this.surname = surname;
        this.name = name;
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
    public int getLegajo_administrador() {
        return legajo_administrador;
    }
    public void setLegajo_administrador(int legajo_administrador) {
        this.legajo_administrador = legajo_administrador;
    }    
}