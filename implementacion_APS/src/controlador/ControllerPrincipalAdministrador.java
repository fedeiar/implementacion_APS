package controlador;

import vista.ViewAdminAltaAlumno;
import vista.ViewPrincipalAdministrador;

public interface ControllerPrincipalAdministrador{


    public void setViewPrincipalAdministrador(ViewPrincipalAdministrador viewPrincipalAdministrador);

    public void setViewAdminAltaAlumno(ViewAdminAltaAlumno viewAdminAltaAlumno);

    public void cambiarVentanaAltaAlumno();
}