package controlador;

import vista.ViewAdminAltaAlumno;
import vista.ViewLoginUsuario;
import vista.ViewAdminAltaCarrera;
import vista.ViewAdminAltaCursada;
import vista.ViewAdminAltaPlan;
import vista.ViewAdminPrincipal;
import vista.ViewAdminModificarPlan;

public class ControllerAdminPrincipal{

    private ViewAdminPrincipal viewAdminPrincipal;
    private ViewAdminAltaAlumno viewAdminAltaAlumno;
    private ViewLoginUsuario viewLoginUsuario;
    private ViewAdminAltaCarrera viewAdminAltaCarrera;
    private ViewAdminAltaPlan viewAdminAltaPlan;
    private ViewAdminModificarPlan viewAdminAgregarMatAPlan;
    private ViewAdminAltaCursada viewAdminAltaCursada;
    
    public ControllerAdminPrincipal(){

    }

    public void setViewPrincipalAdministrador(ViewAdminPrincipal viewPrincipalAdministrador){
        this.viewAdminPrincipal = viewPrincipalAdministrador;
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

    public void setViewAdminAgregarMatAPlan(ViewAdminModificarPlan viewAdminAgregarMatAPlan){
        this.viewAdminAgregarMatAPlan = viewAdminAgregarMatAPlan;
    }

    public void setViewAdminAltaCursada(ViewAdminAltaCursada viewAdminAltaCursada){
        this.viewAdminAltaCursada = viewAdminAltaCursada;
    }

    public void cambiarVentanaAltaAlumno(){
        this.viewAdminAltaAlumno.mostrarse();
    }

    public void cambiarVentanaLoginUsuario(){
        viewLoginUsuario.mostrarse();
    }
    
    public void cambiarVentanaAltaCarrera(){
        this.viewAdminAltaCarrera.mostrarse();
    }

    public void cambiarVentanaAltaPlan(){
        this.viewAdminAltaPlan.mostrarse();
    }

    public void cambiarVentanaAgregarMatAPlan(){
        this.viewAdminAgregarMatAPlan.mostrarse();
    }

    public void cambiarVentanaAdminAltaCursada(){
        viewAdminAltaCursada.mostrarse();
    }
}
