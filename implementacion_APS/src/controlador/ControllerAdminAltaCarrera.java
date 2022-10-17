package controlador;

import modelo.Carrera;
import vista.ViewAdminAltaCarrera;
import vista.ViewAdminPrincipal;

public interface ControllerAdminAltaCarrera {
    
    public void setViewAdminAltaCarrera(ViewAdminAltaCarrera viewAdminAltaPlan);

    public void setViewPrincipalAdministrador(ViewAdminPrincipal viewPrincipalAdministrador);

    public void darDeAltaCarrera(Carrera carrera);

    public void regresarMenuPrincipalAdmin();
}
