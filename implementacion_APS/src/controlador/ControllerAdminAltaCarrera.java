package controlador;

import modelo.Carrera;
import vista.ViewAdminAltaCarrera;
import vista.ViewPrincipalAdministrador;

public interface ControllerAdminAltaCarrera {
    

    public void setViewAdminAltaCarrera(ViewAdminAltaCarrera viewAdminAltaPlan);

    public void darDeAltaCarrera(Carrera carrera);

    public void regresarMenuPrincipalAdmin();

    public void setViewPrincipalAdministrador(ViewPrincipalAdministrador viewPrincipalAdministrador);
}
