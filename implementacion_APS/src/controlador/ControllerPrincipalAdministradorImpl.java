package controlador;

import vista.ViewAdminAltaAlumno;
import vista.ViewLoginUsuario;
import vista.ViewPrincipalAdministrador;

public class ControllerPrincipalAdministradorImpl implements ControllerPrincipalAdministrador{

    private ViewPrincipalAdministrador viewPrincipalAdministrador;
    private ViewAdminAltaAlumno viewAdminAltaAlumno;
    private ViewLoginUsuario viewLoginUsuario;
    

    public ControllerPrincipalAdministradorImpl(){

    }

    public void setViewPrincipalAdministrador(ViewPrincipalAdministrador viewPrincipalAdministrador){
        this.viewPrincipalAdministrador = viewPrincipalAdministrador;
    }

    public void setViewAdminAltaAlumno(ViewAdminAltaAlumno viewAdminAltaAlumno){
        this.viewAdminAltaAlumno = viewAdminAltaAlumno;
    }

    public void setViewLoginUsuario(ViewLoginUsuario viewLoginUsuario){
        this.viewLoginUsuario = viewLoginUsuario;
    }

    public void cambiarVentanaAltaAlumno(){
        this.viewAdminAltaAlumno.mostrarse();
    }

    public void CambiarVentanaLogin(){
        viewLoginUsuario.mostrarse();
    }
}
