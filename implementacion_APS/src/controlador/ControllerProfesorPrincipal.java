package controlador;

import vista.ViewLoginUsuario;
import vista.ViewProfesorPrincipal;
import vista.ViewProfesorAltaExamenFinal;

public class ControllerProfesorPrincipal {
        
    private ViewProfesorPrincipal viewProfesorPrincipal;
    private ViewLoginUsuario viewLoginUsuario;
    private ViewProfesorAltaExamenFinal viewProfesorAltaExamenFinal;

    public ControllerProfesorPrincipal(){
        
    }

    public void setViewProfesorPrincipal(ViewProfesorPrincipal viewProfesorPrincipal){
        this.viewProfesorPrincipal = viewProfesorPrincipal;
    }

    public void setViewLoginUsuario(ViewLoginUsuario viewLoginUsuario){
        this.viewLoginUsuario = viewLoginUsuario;
    }

    public void setViewProfesorAltaExamenFinal(ViewProfesorAltaExamenFinal viewProfesorAltaExamenFinal){
        this.viewProfesorAltaExamenFinal = viewProfesorAltaExamenFinal;
    }

    public void cambiarVentanaLogin() {
        this.viewLoginUsuario.mostrarse();
    }

    public void cambiarVentanaAltaExamenFinal() {
        this.viewProfesorAltaExamenFinal.setProfesor(viewProfesorPrincipal.profesor);
        this.viewProfesorAltaExamenFinal.mostrarse();
    }
}
