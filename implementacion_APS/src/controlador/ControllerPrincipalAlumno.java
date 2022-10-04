package controlador;

import vista.ViewLoginUsuario;
import vista.ViewPrincipalAlumno;

public interface ControllerPrincipalAlumno {
    
    public void cambiarVentanaLogin();

    public void setViewLoginUsuario(ViewLoginUsuario viewLoginUsuario);

    public void setViewPrincipalAlumno(ViewPrincipalAlumno viewPrincipalAlumno);

}
