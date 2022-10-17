package vista;

import modelo.Alumno;

public interface ViewAlumnoPrincipal {

    public void mostrarse();

    public void operacionExitosa(String titulo, String mensaje);

    public void operacionFallida(String titulo, String mensaje);

    public void setAlumno(Alumno alumno);
}
