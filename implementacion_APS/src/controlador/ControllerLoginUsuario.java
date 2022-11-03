package controlador;

import modelo.Administrador;
import modelo.Alumno;
import modelo.DatabaseImpl;
import modelo.Profesor;
import vista.ViewLoginUsuario;
import vista.ViewProfesorPrincipal;
import vista.ViewAdminPrincipal;
import vista.ViewAlumnoPrincipal;

public class ControllerLoginUsuario{
    
    private ViewLoginUsuario viewLoginUsuario;
    private ViewAdminPrincipal viewAdminPrincipal;
    private ViewAlumnoPrincipal viewAlumnoPrincipal;
    private ViewProfesorPrincipal viewProfesorPrincipal;

    private Administrador admin;
    private Alumno alumno;
    private Profesor profesor;

    public ControllerLoginUsuario(){

    }

    public void setViewLoginUsuario(ViewLoginUsuario viewLoginUsuario){
        this.viewLoginUsuario = viewLoginUsuario;
    }

    public void setViewAdminPrincipal(ViewAdminPrincipal viewAdminPrincipal){
        this.viewAdminPrincipal = viewAdminPrincipal;
    }

    public void setViewAlumnoPrincipal(ViewAlumnoPrincipal viewAlumnoPrincipal){
        this.viewAlumnoPrincipal = viewAlumnoPrincipal;
    }

    public void setViewProfesorPrincipal(ViewProfesorPrincipal viewProfesorPrincipal){
        this.viewProfesorPrincipal = viewProfesorPrincipal;
    }

    public void autenticarUsuarioAdministrador(int legajo, String password) {
        try{
            if(existeAdministrador(legajo)){ 
                if(DatabaseImpl.checkAdminPassword(legajo, password)){ 
                    // si necesitacemos los datos del admin, podriamos pasarselos aca a la vista.
                    viewAdminPrincipal.mostrarse();
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
                    viewAlumnoPrincipal.setAlumno(alumno);
                    viewAlumnoPrincipal.mostrarse();
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
            alumno = DatabaseImpl.getAlumno(legajo);
            encontrado = alumno != null;
        }catch(Exception e){
            viewLoginUsuario.operacionFallida("Error", e.getMessage());
        }
        return encontrado;
    }

    public void autenticarUsuarioProfesor(int username, String password){
        try{
            if(existeProfesor(username)){
                if(DatabaseImpl.checkProfesorPassword(username, password)){
                    viewProfesorPrincipal.setProfesor(profesor);
                    viewProfesorPrincipal.mostrarse();
                } else{
                    viewProfesorPrincipal.operacionFallida("Error: contraseña incorrecta", "Reingrese su contraseña");
                }
            }else{
                viewProfesorPrincipal.operacionFallida("Error: usuario profesor inexistente", "El usuario profesor ingresado no existe o no está registrado");
            }
        } catch(Exception e){
            viewLoginUsuario.operacionFallida("Error", e.getMessage());
        }
    }

    private boolean existeProfesor(int legajo){
        boolean encontrado = false;
        try{
            profesor = DatabaseImpl.getProfesor(legajo);
            encontrado = profesor != null;
        }catch(Exception e){
            viewLoginUsuario.operacionFallida("Error", e.getMessage());
        }
        return encontrado;
    }

}
