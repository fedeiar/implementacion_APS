package controlador;

import modelo.Carrera;
import modelo.DatabaseImpl;
import vista.ViewAdminAltaCarrera;
import vista.ViewAdminPrincipal;

public class ControllerAdminAltaCarrera{
    

    private ViewAdminAltaCarrera viewAdminAltaCarrera;
    private ViewAdminPrincipal viewPrincipalAdministrador;


    public ControllerAdminAltaCarrera(){

    }

    public void setViewAdminAltaCarrera(ViewAdminAltaCarrera viewAdminAltaCarrera){
        this.viewAdminAltaCarrera = viewAdminAltaCarrera;
    }

    public void setViewPrincipalAdministrador(ViewAdminPrincipal viewPrincipalAdministrador){
        this.viewPrincipalAdministrador = viewPrincipalAdministrador;
    }

    public void regresarMenuPrincipalAdmin(){
        viewPrincipalAdministrador.mostrarse();
    }

    public void darDeAltaCarrera(Carrera carrera){ 
        try {
            DatabaseImpl.saveCarrera(carrera);
            viewAdminAltaCarrera.operacionExitosa("Registro exitoso", "Carrera registrada exitosamente.");
        } catch (Exception e) {
            viewAdminAltaCarrera.operacionFallida("Error: ", e.getMessage());
        }
    }

    
}
