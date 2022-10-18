package controlador;

import modelo.Alumno;
import modelo.DatabaseImpl;
import modelo.Materia;
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

    public void darDeAltaMateria(Materia materia){ 
        try {
            //TODO: habria que registrar que no estemos pisando a un alumno que ya existia? o ya fue?
            DatabaseImpl.saveMateria(materia);
            viewAdminAltaMateria.operacionExitosa("Registro exitoso", "Una materia registrado exitosamente.");
        } catch (Exception e) {
            viewAdminAltaMateria.operacionFallida("Error: ", e.getMessage());
        }
    }

    
}
