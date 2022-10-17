package controlador;

import vista.ViewAlumnoInscripcionCarrera;
import vista.ViewAlumnoPrincipal;
import vista.ViewLoginUsuario;

public class ControllerAlumnoPrincipal{
    
    private ViewAlumnoPrincipal viewPrincipalAlumno;
    private ViewLoginUsuario viewLoginUsuario;

    private ViewAlumnoInscripcionCarrera viewAlumnoInscripcionCarrera;

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

    public void cambiarVentanaLogin() {
        this.viewLoginUsuario.mostrarse();
    }

    public void cambiarVentanaInscripcionCarrera(){
        viewAlumnoInscripcionCarrera.setAlumno(viewPrincipalAlumno.alumno);
        viewAlumnoInscripcionCarrera.mostrarse();
    }
}
