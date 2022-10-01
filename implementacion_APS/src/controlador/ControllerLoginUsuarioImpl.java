package controlador;

import modelo.Administrador;
import modelo.DataBaseImpl;
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

    public void autenticarUsuario(int legajo, String password) {
        if(comprobrarAdministrador(legajo)){ // habria q chequear si existe el usuario
            if(true){ //habria q chequear q matchie la contrasena
                viewPrincipalAdministrador.mostrarse();
            }
        }
    }

    private boolean comprobrarAdministrador(int legajo) {
        boolean encontrado = false;
        try{
            Administrador admin= DataBaseImpl.getAdmin(legajo);
            encontrado = admin != null;
        }catch(Exception e){
            //todo
        }
        return encontrado;
    }

}
