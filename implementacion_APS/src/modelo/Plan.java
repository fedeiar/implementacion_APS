package modelo;

public class Plan {
    private int anio;
    private int codCarrera;

    public Plan(int anio, int carrera) {
        this.anio = anio;
        this.codCarrera = carrera;
    }

    public int getAnio() {
        return anio;
    }

    public int getCodCarrera() {
        return codCarrera;
    }
}
