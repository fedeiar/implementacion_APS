package controlador;

import vista.ViewAlumnoPrincipal;
import vista.ViewLoginUsuario;

public class ControllerAlumnoPrincipalImpl implements ControllerAlumnoPrincipal{
    
    private ViewAlumnoPrincipal viewPrincipalAlumno;
    private ViewLoginUsuario viewLoginUsuario;

    public ControllerAlumnoPrincipalImpl(){
        
    }

    public void setViewPrincipalAlumno(ViewAlumnoPrincipal viewAlumnoPrincipal){
        this.viewPrincipalAlumno = viewAlumnoPrincipal;
    }

    public void setViewLoginUsuario(ViewLoginUsuario viewLoginUsuario){
        this.viewLoginUsuario = viewLoginUsuario;
    }

    public void cambiarVentanaLogin() {
        this.viewLoginUsuario.mostrarse();
    }
}
