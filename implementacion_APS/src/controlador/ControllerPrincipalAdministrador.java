package controlador;

import vista.ViewAdminAltaAlumno;
import vista.ViewLoginUsuario;
import vista.ViewAdminAltaCarrera;
import vista.ViewAdminAltaPlan;
import vista.ViewPrincipalAdministrador;

public interface ControllerPrincipalAdministrador{


    public void setViewPrincipalAdministrador(ViewPrincipalAdministrador viewPrincipalAdministrador);

    public void setViewAdminAltaAlumno(ViewAdminAltaAlumno viewAdminAltaAlumno);

    public void setViewLoginUsuario(ViewLoginUsuario viewLoginUsuario);

    public void cambiarVentanaAltaAlumno();

    public void CambiarVentanaLogin();
    public void setViewAdminAltaCarrera(ViewAdminAltaCarrera viewAdminAltaCarrera);

    public void setViewAdminAltaPlan(ViewAdminAltaPlan viewAdminAltaPlan);

    public void cambiarVentanaAltaCarrera();

    public void cambiarVentanaAltaPlan();
}