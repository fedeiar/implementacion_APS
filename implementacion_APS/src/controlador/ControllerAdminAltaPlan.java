package controlador;

import modelo.Plan;
import vista.ViewAdminAltaPlan;
import vista.ViewPrincipalAdministrador;

public interface ControllerAdminAltaPlan {
    

    public void setViewAdminAltaPlan(ViewAdminAltaPlan viewAdminAltaPlan);

    public void darDeAltaPlan(Plan plan);

    public void regresarMenuPrincipalAdmin();

    public void setViewPrincipalAdministrador(ViewPrincipalAdministrador viewPrincipalAdministrador);
}
