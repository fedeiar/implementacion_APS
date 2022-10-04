package modelo;

public class Carrera {
    private String nombre;
    private int codigo;

    public Carrera(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }
    
}
