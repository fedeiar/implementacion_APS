package controlador;

import modelo.Profesor;
import modelo.DatabaseImpl;
import vista.ViewAdminAltaProfesor;
import vista.ViewAdminPrincipal;

public class ControllerAdminAltaProfesor{
    

    private ViewAdminAltaProfesor viewAdminAltaProfesor;
    private ViewAdminPrincipal viewPrincipalAdministrador;


    public ControllerAdminAltaProfesor(){

    }

    public void setViewAdminAltaProfesor(ViewAdminAltaProfesor viewAdminAltaProfesor){
        this.viewAdminAltaProfesor = viewAdminAltaProfesor;
    }

    public void setViewPrincipalAdministrador(ViewAdminPrincipal viewPrincipalAdministrador){
        this.viewPrincipalAdministrador = viewPrincipalAdministrador;
    }

    public void regresarMenuPrincipalAdmin(){
        viewPrincipalAdministrador.mostrarse();
    }

    public void darDeAltaProfesor(Profesor profesor){ 
        try {
            DatabaseImpl.saveProfesor(profesor);
            viewAdminAltaProfesor.operacionExitosa("Registro exitoso", "Usuario profesor registrado exitosamente.");
        } catch (Exception e) {
            viewAdminAltaProfesor.operacionFallida("Error: ", e.getMessage());
        }
    }

    
}
