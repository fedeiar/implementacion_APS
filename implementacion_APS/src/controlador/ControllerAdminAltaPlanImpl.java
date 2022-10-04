package controlador;

import modelo.Plan;
import modelo.DatabaseImpl;
import vista.ViewAdminAltaPlan;
import vista.ViewPrincipalAdministrador;

public class ControllerAdminAltaPlanImpl implements ControllerAdminAltaPlan{
    

    private ViewAdminAltaPlan viewAdminAltaPlan;
    private ViewPrincipalAdministrador viewPrincipalAdministrador;


    public ControllerAdminAltaPlanImpl(){

    }

    public void setViewAdminAltaPlan(ViewAdminAltaPlan viewAdminAltaPlan){
        this.viewAdminAltaPlan = viewAdminAltaPlan;
    }

    public void setViewPrincipalAdministrador(ViewPrincipalAdministrador viewPrincipalAdministrador){
        this.viewPrincipalAdministrador = viewPrincipalAdministrador;
    }

    public void regresarMenuPrincipalAdmin(){
        viewPrincipalAdministrador.mostrarse();
    }

    public void darDeAltaPlan(Plan plan){ 
        try {
            //TODO: habria que registrar que no estemos pisando a un alumno que ya existia? o ya fue?
            DatabaseImpl.savePlan(plan);
            viewAdminAltaPlan.operacionExitosa("Registro exitoso", "Plan registrado exitosamente.");
        } catch (Exception e) {
            viewAdminAltaPlan.operacionFallida("Error: ", e.getMessage());
        }
    }

    
}
