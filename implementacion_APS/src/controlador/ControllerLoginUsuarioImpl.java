package controlador;

import modelo.Administrador;
import modelo.DatabaseImpl;
import vista.ViewLoginUsuario;
import vista.ViewPrincipalAdministrador;

public class ControllerLoginUsuarioImpl implements ControllerLoginUsuario{
    
    private ViewPrincipalAdministrador viewPrincipalAdministrador;
    private ViewLoginUsuario viewLoginUsuario;

    private Administrador admin;

    public ControllerLoginUsuarioImpl(){

    }

    public void setViewLoginUsuario(ViewLoginUsuario viewLoginUsuario){
        this.viewLoginUsuario = viewLoginUsuario;
    }

    public void setViewPrincipalAdministrador(ViewPrincipalAdministrador viewPrincipalAdministrador){
        this.viewPrincipalAdministrador = viewPrincipalAdministrador;
    }

    public boolean isUsernameInteger(String legajo){
        try{
            Integer.parseInt(legajo);
            return true;
        } catch(Exception e){
            viewLoginUsuario.operacionFallida("Error: username", "El nombre de usuario debe ser un numero entero que represente un legajo");
            return false;
        }
    }

    public void autenticarUsuarioAdministrador(int legajo, String password) {
        try{
            if(existeAdministrador(legajo)){ 
                if(DatabaseImpl.checkAdminPassword(legajo, password)){ 
                    // si necesitacemos los datos del admin, podriamos pasarselos aca a la vista.
                    viewPrincipalAdministrador.mostrarse();
                } else{
                    viewLoginUsuario.operacionFallida("Error: contraseña incorrecta", "Reingrese su contraseña");
                }
            } else{
                viewLoginUsuario.operacionFallida("Error: usuario administrador inexistente", "El usuario administrador ingresado no existe o no está registrado");
            }
        } catch(Exception e){
            viewLoginUsuario.operacionFallida("Error", e.getMessage());
        }
    }

    private boolean existeAdministrador(int legajo) {
        boolean encontrado = false;
        try{
            admin = DatabaseImpl.getAdmin(legajo);
            encontrado = admin != null;
        }catch(Exception e){
            System.out.println("entre");
            viewLoginUsuario.operacionFallida("Error", e.getMessage());
        }
        return encontrado;
    }

}
