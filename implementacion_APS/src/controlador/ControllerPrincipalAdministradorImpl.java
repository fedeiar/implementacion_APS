package controlador;

import vista.ViewPrincipalAdministrador;

public class ControllerPrincipalAdministradorImpl implements ControllerPrincipalAdministrador{

    private ViewPrincipalAdministrador viewPrincipalAdministrador;
    

    public ControllerPrincipalAdministradorImpl(){

    }

    public void setViewPrincipalAdministrador(ViewPrincipalAdministrador viewPrincipalAdministrador){
        this.viewPrincipalAdministrador = viewPrincipalAdministrador;
    }
}
