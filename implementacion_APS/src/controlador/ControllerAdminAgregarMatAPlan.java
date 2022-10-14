package controlador;

import modelo.Materia;
import modelo.Plan;
import vista.ViewAdminAgregarMatAPlan;
import vista.ViewPrincipalAdministrador;

public interface ControllerAdminAgregarMatAPlan {
    

    public void setViewAdminAgregarMatAPlan(ViewAdminAgregarMatAPlan viewAdminAgregarMatAPlan);

    public void agregarMatAPlan(Materia materia, Plan plan);

    public void regresarMenuPrincipalAdmin();

    public void setViewPrincipalAdministrador(ViewPrincipalAdministrador viewPrincipalAdministrador);
}
