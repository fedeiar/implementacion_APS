package controlador;

import modelo.Plan;
import vista.ViewAdminAltaPlan;
import vista.ViewAdminPrincipal;

public interface ControllerAdminAltaPlan {
    

    public void setViewAdminAltaPlan(ViewAdminAltaPlan viewAdminAltaPlan);

    public void darDeAltaPlan(Plan plan);

    public void regresarMenuPrincipalAdmin();

    public void setViewPrincipalAdministrador(ViewAdminPrincipal viewPrincipalAdministrador);
}
