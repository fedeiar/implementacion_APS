package controlador;

import vista.ViewAdminAltaMateria;
import vista.ViewLoginUsuario;
import vista.ViewAdminAltaAlumno;
import vista.ViewAdminAltaCarrera;
import vista.ViewAdminAltaCursada;
import vista.ViewAdminAltaPlan;
import vista.ViewAdminAltaProfesor;
import vista.ViewAdminPrincipal;
import vista.ViewAdminModificarPlan;

public class ControllerAdminPrincipal{

    private ViewAdminPrincipal viewAdminPrincipal;
    private ViewAdminAltaAlumno viewAdminAltaAlumno;
    private ViewLoginUsuario viewLoginUsuario;
    private ViewAdminAltaCarrera viewAdminAltaCarrera;
    private ViewAdminAltaPlan viewAdminAltaPlan;
    private ViewAdminModificarPlan viewAdminAgregarModificarPlan;
    private ViewAdminAltaCursada viewAdminAltaCursada;
    private ViewAdminAltaMateria viewAdminAltaMateria;
    private ViewAdminAltaProfesor viewAdminAltaProfesor;
    
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

    public void setViewAdminModificarPlan(ViewAdminModificarPlan viewAdminModificarPlan){
        this.viewAdminAgregarModificarPlan = viewAdminModificarPlan;
    }

    public void setViewAdminAltaCursada(ViewAdminAltaCursada viewAdminAltaCursada){
        this.viewAdminAltaCursada = viewAdminAltaCursada;
    }

    public void setViewAdminAltaMateria(ViewAdminAltaMateria viewAdminAltaMateria){
        this.viewAdminAltaMateria = viewAdminAltaMateria;
    }

    public void setViewAdminAltaProfesor(ViewAdminAltaProfesor viewAdminAltaProfesor){
        this.viewAdminAltaProfesor = viewAdminAltaProfesor;
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

    public void cambiarVentanaModificarPlan(){
        this.viewAdminAgregarModificarPlan.mostrarse();
    }

    public void cambiarVentanaAltaMateria(){
        this.viewAdminAltaMateria.mostrarse();
    }

    public void cambiarVentanaAdminAltaCursada(){
        viewAdminAltaCursada.mostrarse();
    }

    public void cambiarVentanaAdminAltaProfesor(){
        viewAdminAltaProfesor.mostrarse();
    }
}
