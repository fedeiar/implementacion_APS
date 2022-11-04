package controlador;

import modelo.DatabaseImpl;
import vista.ViewAdminAltaMateria;
import vista.ViewAdminPrincipal;

public class ControllerAdminAltaMateria{
    

    private ViewAdminAltaMateria viewAdminAltaMateria;
    private ViewAdminPrincipal viewPrincipalAdministrador;


    public ControllerAdminAltaMateria(){

    }

    public void setViewAdminAltaMateria(ViewAdminAltaMateria viewAdminAltaMateria){
        this.viewAdminAltaMateria = viewAdminAltaMateria;
    }

    public void setViewPrincipalAdministrador(ViewAdminPrincipal viewPrincipalAdministrador){
        this.viewPrincipalAdministrador = viewPrincipalAdministrador;
    }

    public void regresarMenuPrincipalAdmin(){
        viewPrincipalAdministrador.mostrarse();
    }

    public void darDeAltaMateria(String nombre){ 
        try {
            DatabaseImpl.saveMateria(nombre);
            viewAdminAltaMateria.operacionExitosa("Registro exitoso", "Una materia registrado exitosamente.");
        } catch (Exception e) {
            viewAdminAltaMateria.operacionFallida("Error: ", e.getMessage());
        }
    }

    
}
