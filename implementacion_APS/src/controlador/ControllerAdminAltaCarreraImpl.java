package controlador;

import modelo.Alumno;
import modelo.DatabaseImpl;
import vista.ViewAdminAltaAlumno;
import vista.ViewAdminAltaCarreraImpl;
import vista.ViewPrincipalAdministrador;

public class ControllerAdminAltaCarreraImpl {
    

    private ViewAdminAltaCarreraImpl viewAdminAltaCarrera;
    private ViewPrincipalAdministrador viewPrincipalAdministrador;


    public ControllerAdminAltaCarreraImpl(){

    }

    public void setViewAdminAltaCarrera(ViewAdminAltaCarreraImpl viewAdminAltaCarrera){
        this.viewAdminAltaCarrera = viewAdminAltaCarrera;
    }

    public void setViewPrincipalAdministrador(ViewPrincipalAdministrador viewPrincipalAdministrador){
        this.viewPrincipalAdministrador = viewPrincipalAdministrador;
    }

    public void regresarMenuPrincipalAdmin(){
        viewPrincipalAdministrador.mostrarse();
    }

    public void darDeAltaCarrera(String nombre, int codigo){ 
        try {
            DatabaseImpl.saveCarreer(codigo,nombre);
            viewAdminAltaCarrera.operacionExitosa("Registro exitoso", "Carrera registrado exitosamente.");
        } catch (Exception e) {
            viewAdminAltaCarrera.operacionFallida("Error: ", e.getMessage());
        }
    }

    
}
