package controlador;

import modelo.Cursada;
import vista.ViewAdminAltaCursada;
import vista.ViewAdminPrincipal;

public class ControllerAdminAltaCursada {
    
    private ViewAdminAltaCursada viewAdminAltaCursada;
    private ViewAdminPrincipal viewAdminPrincipal;

    public ControllerAdminAltaCursada(){

    }

    public void setViewAdminAltaCursada(ViewAdminAltaCursada viewAdminAltaCursada){
        this.viewAdminAltaCursada = viewAdminAltaCursada;
    }

    public void setViewAdminPrincipal(ViewAdminPrincipal viewAdminPrincipal){
        this.viewAdminPrincipal = viewAdminPrincipal;
    }

    public void regresarMenuPrincipalAdmin(){
        viewAdminPrincipal.mostrarse();
    }

    public void darDeAltaCursada(Cursada cursada){
        //TODO: hacer
    }
}
