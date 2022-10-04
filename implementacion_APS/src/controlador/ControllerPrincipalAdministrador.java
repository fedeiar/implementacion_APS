package controlador;

import vista.ViewAdminAltaAlumno;
import vista.ViewLoginUsuario;
import vista.ViewPrincipalAdministrador;

public interface ControllerPrincipalAdministrador{


    public void setViewPrincipalAdministrador(ViewPrincipalAdministrador viewPrincipalAdministrador);

    public void setViewAdminAltaAlumno(ViewAdminAltaAlumno viewAdminAltaAlumno);

    public void setViewLoginUsuario(ViewLoginUsuario viewLoginUsuario);

    public void cambiarVentanaAltaAlumno();

    public void CambiarVentanaLogin();
}