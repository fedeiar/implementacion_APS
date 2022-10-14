package controlador;

import vista.ViewAdminAltaAlumno;
import vista.ViewLoginUsuario;
import vista.ViewAdminAltaCarrera;
import vista.ViewAdminAltaPlan;
import vista.ViewAdminAgregarMatAPlan;
import vista.ViewPrincipalAdministrador;

public interface ControllerPrincipalAdministrador{


    public void setViewPrincipalAdministrador(ViewPrincipalAdministrador viewPrincipalAdministrador);

    public void setViewAdminAltaAlumno(ViewAdminAltaAlumno viewAdminAltaAlumno);

    public void setViewLoginUsuario(ViewLoginUsuario viewLoginUsuario);

    public void cambiarVentanaAltaAlumno();

    public void cambiarVentanaLogin();
    public void setViewAdminAltaCarrera(ViewAdminAltaCarrera viewAdminAltaCarrera);

    public void setViewAdminAltaPlan(ViewAdminAltaPlan viewAdminAltaPlan);

    public void cambiarVentanaAltaCarrera();

    public void cambiarVentanaAltaPlan();

    public void setViewAdminAgregarMatAPlan(ViewAdminAgregarMatAPlan viewAdminAgregarMatAPlan);

    public void cambiarVentanaAgregarMatAPlan();
}