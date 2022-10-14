package controlador;

import modelo.Carrera;
import modelo.DatabaseImpl;
import vista.ViewAdminAltaCarrera;
import vista.ViewPrincipalAdministrador;

public class ControllerAdminAltaCarreraImpl implements ControllerAdminAltaCarrera {
    

    private ViewAdminAltaCarrera viewAdminAltaCarrera;
    private ViewPrincipalAdministrador viewPrincipalAdministrador;


    public ControllerAdminAltaCarreraImpl(){

    }

    public void setViewAdminAltaCarrera(ViewAdminAltaCarrera viewAdminAltaCarrera){
        this.viewAdminAltaCarrera = viewAdminAltaCarrera;
    }

    public void setViewPrincipalAdministrador(ViewPrincipalAdministrador viewPrincipalAdministrador){
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
