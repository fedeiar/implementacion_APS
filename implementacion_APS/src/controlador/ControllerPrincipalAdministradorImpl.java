package controlador;

import vista.ViewAdminAltaAlumno;
import vista.ViewLoginUsuario;
import vista.ViewAdminAltaCarrera;
import vista.ViewAdminAltaPlan;
import vista.ViewPrincipalAdministrador;

public class ControllerPrincipalAdministradorImpl implements ControllerPrincipalAdministrador{

    private ViewPrincipalAdministrador viewPrincipalAdministrador;
    private ViewAdminAltaAlumno viewAdminAltaAlumno;
    private ViewLoginUsuario viewLoginUsuario;
    private ViewAdminAltaCarrera viewAdminAltaCarrera;
    private ViewAdminAltaPlan viewAdminAltaPlan;
    

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
    
    public void setViewAdminAltaCarrera(ViewAdminAltaCarrera viewAdminAltaCarrera){
        this.viewAdminAltaCarrera = viewAdminAltaCarrera;
    }

    public void setViewAdminAltaPlan(ViewAdminAltaPlan viewAdminAltaPlan){
        this.viewAdminAltaPlan = viewAdminAltaPlan;
    }

    public void cambiarVentanaAltaAlumno(){
        this.viewAdminAltaAlumno.mostrarse();
    }

    public void CambiarVentanaLogin(){
        viewLoginUsuario.mostrarse();
    }
    
    public void cambiarVentanaAltaCarrera(){
        this.viewAdminAltaCarrera.mostrarse();
    }

    public void cambiarVentanaAltaPlan(){
        this.viewAdminAltaPlan.mostrarse();
    }
}
