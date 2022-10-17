package controlador;

import vista.ViewLoginUsuario;
import vista.ViewAlumnoPrincipal;

public interface ControllerAlumnoPrincipal {
    
    public void cambiarVentanaLogin();

    public void setViewLoginUsuario(ViewLoginUsuario viewLoginUsuario);

    public void setViewPrincipalAlumno(ViewAlumnoPrincipal viewPrincipalAlumno);

}
