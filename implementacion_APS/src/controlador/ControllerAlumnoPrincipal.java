package controlador;

import vista.ViewAlumnoInscripcionCarrera;
import vista.ViewAlumnoInscripcionCursada;
import vista.ViewAlumnoPrincipal;
import vista.ViewLoginUsuario;

public class ControllerAlumnoPrincipal{
    
    private ViewAlumnoPrincipal viewPrincipalAlumno;
    private ViewLoginUsuario viewLoginUsuario;

    private ViewAlumnoInscripcionCarrera viewAlumnoInscripcionCarrera;
    private ViewAlumnoInscripcionCursada viewAlumnoInscripcionCursada;

    public ControllerAlumnoPrincipal(){
        
    }

    public void setViewPrincipalAlumno(ViewAlumnoPrincipal viewAlumnoPrincipal){
        this.viewPrincipalAlumno = viewAlumnoPrincipal;
    }

    public void setViewLoginUsuario(ViewLoginUsuario viewLoginUsuario){
        this.viewLoginUsuario = viewLoginUsuario;
    }

    public void setViewAlumnoInscripcionCarrera(ViewAlumnoInscripcionCarrera viewAlumnoInscripcionCarrera){
        this.viewAlumnoInscripcionCarrera = viewAlumnoInscripcionCarrera;
    }

    public void setViewAlumnoInscripcionCursada(ViewAlumnoInscripcionCursada viewAlumnoInscripcionCursada){
        this.viewAlumnoInscripcionCursada = viewAlumnoInscripcionCursada;
    }

    public void cambiarVentanaLogin() {
        this.viewLoginUsuario.mostrarse();
    }

    public void cambiarVentanaInscripcionCarrera(){
        viewAlumnoInscripcionCarrera.setAlumno(viewPrincipalAlumno.alumno);
        viewAlumnoInscripcionCarrera.mostrarse();
    }

    public void cambiarVentanaInscripcionCursada(){
        viewAlumnoInscripcionCursada.setAlumno(viewPrincipalAlumno.alumno);
        viewAlumnoInscripcionCursada.mostrarse();
    }
}
