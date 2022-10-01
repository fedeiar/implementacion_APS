package controlador;

import vista.ViewLoginUsuario;
import vista.ViewPrincipalAdministrador;

public class ControllerLoginUsuarioImpl implements ControllerLoginUsuario{
    
    private ViewPrincipalAdministrador viewPrincipalAdministrador;
    private ViewLoginUsuario viewLoginUsuario;

    public ControllerLoginUsuarioImpl(){

    }

    public void setViewLoginUsuario(ViewLoginUsuario viewLoginUsuario){
        this.viewLoginUsuario = viewLoginUsuario;
    }

    public void setViewPrincipalAdministrador(ViewPrincipalAdministrador viewPrincipalAdministrador){
        this.viewPrincipalAdministrador = viewPrincipalAdministrador;
    }

    public void autenticarUsuario(String username, String password){
        if(true){ // habria q chequear si existe el usuario
            if(true){ //habria q chequear q matchie la contrasena
                viewPrincipalAdministrador.mostrarse();
            }
        }
    }

}
