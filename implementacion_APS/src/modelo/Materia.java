package modelo;

public class Materia{

    public int codigo;
    public String nombre;
    

    public Materia(String nombre){
        this.nombre = nombre;
    }

    public Materia(int codigo, String nombre){
        this.codigo = codigo;
        this.nombre = nombre;
    }
}