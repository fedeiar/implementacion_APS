package controlador;

import modelo.DatabaseImpl;
import modelo.Materia;
import modelo.Plan;
import vista.ViewAdminAgregarMatAPlan;
import vista.ViewPrincipalAdministrador;

public class ControllerAdminAgregarMatAPlanImpl implements ControllerAdminAgregarMatAPlan{
    

    private ViewAdminAgregarMatAPlan viewAdminAgregarMatAPlan;
    private ViewPrincipalAdministrador viewPrincipalAdministrador;


    public ControllerAdminAgregarMatAPlanImpl(){

    }

    public void setViewAdminAgregarMatAPlan(ViewAdminAgregarMatAPlan viewAdminAgregarMatAPlan){
        this.viewAdminAgregarMatAPlan = viewAdminAgregarMatAPlan;
    }

    public void setViewPrincipalAdministrador(ViewPrincipalAdministrador viewPrincipalAdministrador){
        this.viewPrincipalAdministrador = viewPrincipalAdministrador;
    }

    public void regresarMenuPrincipalAdmin(){
        viewPrincipalAdministrador.mostrarse();
    }

    public void agregarMatAPlan(Materia materia, Plan plan){ 
        try {
            DatabaseImpl.savePlanMateria(plan, materia);
            viewAdminAgregarMatAPlan.operacionExitosa("Registro exitoso", "Materia agregada en plan.");
        } catch (Exception e) {
            viewAdminAgregarMatAPlan.operacionFallida("Error: ", e.getMessage());
        }
    }

    
}
