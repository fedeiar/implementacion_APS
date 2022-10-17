package controlador;

import modelo.Administrador;
import modelo.Alumno;
import modelo.DatabaseImpl;
import vista.ViewLoginUsuario;
import vista.ViewAdminPrincipal;
import vista.ViewAlumnoPrincipal;

public class ControllerLoginUsuarioImpl implements ControllerLoginUsuario{
    
    private ViewLoginUsuario viewLoginUsuario;
    private ViewAdminPrincipal viewPrincipalAdministrador;
    private ViewAlumnoPrincipal viewPrincipalAlumno;

    private Administrador admin;
    private Alumno alumno;

    public ControllerLoginUsuarioImpl(){

    }

    public void setViewLoginUsuario(ViewLoginUsuario viewLoginUsuario){
        this.viewLoginUsuario = viewLoginUsuario;
    }

    public void setViewPrincipalAdministrador(ViewAdminPrincipal viewPrincipalAdministrador){
        this.viewPrincipalAdministrador = viewPrincipalAdministrador;
    }

    public void setViewPrincipalAlumno(ViewAlumnoPrincipal viewPrincipalAlumno){
        this.viewPrincipalAlumno = viewPrincipalAlumno;
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
            viewLoginUsuario.operacionFallida("Error", e.getMessage());
        }
        return encontrado;
    }

    public void autenticarUsuarioAlumno(int username, String password){
        try{
            if(existeAlumno(username)){
                if(DatabaseImpl.checkAlumnoPassword(username, password)){
                    viewPrincipalAlumno.setAlumno(alumno);
                    viewPrincipalAlumno.mostrarse();
                } else{
                    viewLoginUsuario.operacionFallida("Error: contraseña incorrecta", "Reingrese su contraseña");
                }
            }else{
                viewLoginUsuario.operacionFallida("Error: usuario alumno inexistente", "El usuario alumno ingresado no existe o no está registrado");
            }
        } catch(Exception e){
            viewLoginUsuario.operacionFallida("Error", e.getMessage());
        }
    }

    private boolean existeAlumno(int legajo){
        boolean encontrado = false;
        try{
            alumno = DatabaseImpl.getStudent(legajo);
            encontrado = alumno != null;
        }catch(Exception e){
            viewLoginUsuario.operacionFallida("Error", e.getMessage());
        }
        return encontrado;
    }

}
