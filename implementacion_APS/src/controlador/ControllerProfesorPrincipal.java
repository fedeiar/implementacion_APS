package controlador;

import vista.ViewLoginUsuario;
import vista.ViewProfesorPrincipal;

public class ControllerProfesorPrincipal {
        
    private ViewProfesorPrincipal viewProfesorPrincipal;
    private ViewLoginUsuario viewLoginUsuario;

    public ControllerProfesorPrincipal(){
        
    }

    public void setViewProfesorPrincipal(ViewProfesorPrincipal viewProfesorPrincipal){
        this.viewProfesorPrincipal = viewProfesorPrincipal;
    }

    public void setViewLoginUsuario(ViewLoginUsuario viewLoginUsuario){
        this.viewLoginUsuario = viewLoginUsuario;
    }

    public void cambiarVentanaLogin() {
        this.viewLoginUsuario.mostrarse();
    }
}
