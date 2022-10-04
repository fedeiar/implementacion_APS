package controlador;

import vista.ViewPrincipalAlumno;
import vista.ViewLoginUsuario;

public class ControllerPrincipalAlumnoImpl implements ControllerPrincipalAlumno{
    
    private ViewPrincipalAlumno viewPrincipalAlumno;
    private ViewLoginUsuario viewLoginUsuario;

    public ControllerPrincipalAlumnoImpl(){
        
    }

    public void setViewPrincipalAlumno(ViewPrincipalAlumno viewPrincipalAlumno){
        this.viewPrincipalAlumno = viewPrincipalAlumno;
    }

    public void setViewLoginUsuario(ViewLoginUsuario viewLoginUsuario){
        this.viewLoginUsuario = viewLoginUsuario;
    }

    public void cambiarVentanaLogin() {
        this.viewLoginUsuario.mostrarse();
    }
}
