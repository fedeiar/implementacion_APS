package controlador;

import vista.ViewAdminAltaAlumno;
import vista.ViewPrincipalAdministrador;

public class ControllerPrincipalAdministradorImpl implements ControllerPrincipalAdministrador{

    private ViewPrincipalAdministrador viewPrincipalAdministrador;
    private ViewAdminAltaAlumno viewAdminAltaAlumno;
    

    public ControllerPrincipalAdministradorImpl(){

    }

    public void setViewPrincipalAdministrador(ViewPrincipalAdministrador viewPrincipalAdministrador){
        this.viewPrincipalAdministrador = viewPrincipalAdministrador;
    }

    public void setViewAdminAltaAlumno(ViewAdminAltaAlumno viewAdminAltaAlumno){
        this.viewAdminAltaAlumno = viewAdminAltaAlumno;
    }

    public void cambiarVentanaAltaAlumno(){
        this.viewAdminAltaAlumno.mostrarse();
    }
}
