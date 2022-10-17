package controlador;

import modelo.Plan;
import modelo.DatabaseImpl;
import vista.ViewAdminAltaPlan;
import vista.ViewAdminPrincipal;

public class ControllerAdminAltaPlan{
    

    private ViewAdminAltaPlan viewAdminAltaPlan;
    private ViewAdminPrincipal viewPrincipalAdministrador;


    public ControllerAdminAltaPlan(){

    }

    public void setViewAdminAltaPlan(ViewAdminAltaPlan viewAdminAltaPlan){
        this.viewAdminAltaPlan = viewAdminAltaPlan;
    }

    public void setViewPrincipalAdministrador(ViewAdminPrincipal viewPrincipalAdministrador){
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

    //TODO: un metodo que actualice el comboBox de la vista cuando se agrega una carrera.

    
}
