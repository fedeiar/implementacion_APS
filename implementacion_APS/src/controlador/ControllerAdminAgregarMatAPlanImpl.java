package controlador;

import modelo.DatabaseImpl;
import modelo.Materia;
import modelo.Plan;
import vista.ViewAdminAgregarMatAPlan;
import vista.ViewAdminPrincipal;

public class ControllerAdminAgregarMatAPlanImpl implements ControllerAdminAgregarMatAPlan{
    

    private ViewAdminAgregarMatAPlan viewAdminAgregarMatAPlan;
    private ViewAdminPrincipal viewPrincipalAdministrador;


    public ControllerAdminAgregarMatAPlanImpl(){

    }

    public void setViewAdminAgregarMatAPlan(ViewAdminAgregarMatAPlan viewAdminAgregarMatAPlan){
        this.viewAdminAgregarMatAPlan = viewAdminAgregarMatAPlan;
    }

    public void setViewPrincipalAdministrador(ViewAdminPrincipal viewPrincipalAdministrador){
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
