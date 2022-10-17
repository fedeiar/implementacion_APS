package controlador;

import modelo.Alumno;
import modelo.DatabaseImpl;
import vista.ViewAdminAltaAlumno;
import vista.ViewAdminPrincipal;

public class ControllerAdminAltaAlumnoImpl implements ControllerAdminAltaAlumno{
    

    private ViewAdminAltaAlumno viewAdminAltaAlumno;
    private ViewAdminPrincipal viewPrincipalAdministrador;


    public ControllerAdminAltaAlumnoImpl(){

    }

    public void setViewAdminAltaAlumno(ViewAdminAltaAlumno viewAdminAltaAlumno){
        this.viewAdminAltaAlumno = viewAdminAltaAlumno;
    }

    public void setViewPrincipalAdministrador(ViewAdminPrincipal viewPrincipalAdministrador){
        this.viewPrincipalAdministrador = viewPrincipalAdministrador;
    }

    public void regresarMenuPrincipalAdmin(){
        viewPrincipalAdministrador.mostrarse();
    }

    public void darDeAltaAlumno(Alumno alumno){ 
        try {
            //TODO: habria que registrar que no estemos pisando a un alumno que ya existia? o ya fue?
            DatabaseImpl.saveStudent(alumno);
            viewAdminAltaAlumno.operacionExitosa("Registro exitoso", "Usuario alumno registrado exitosamente.");
        } catch (Exception e) {
            viewAdminAltaAlumno.operacionFallida("Error: ", e.getMessage());
        }
    }

    
}
