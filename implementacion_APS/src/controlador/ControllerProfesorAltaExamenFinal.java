package controlador;

import modelo.DatabaseImpl;
import modelo.ExamenFinal;
import vista.ViewProfesorAltaExamenFinal;
import vista.ViewProfesorPrincipal;

public class ControllerProfesorAltaExamenFinal{
    

    private ViewProfesorAltaExamenFinal viewProfesorAltaExamenFinal;
    private ViewProfesorPrincipal viewProfesorPrincipal;


    public ControllerProfesorAltaExamenFinal(){

    }

    public void setViewProfesorAltaExamenFinal(ViewProfesorAltaExamenFinal viewProfesorAltaExamenFinal){
        this.viewProfesorAltaExamenFinal = viewProfesorAltaExamenFinal;
    }

    public void setViewProfesorPrincipal(ViewProfesorPrincipal viewProfesorPrincipal){
        this.viewProfesorPrincipal = viewProfesorPrincipal;
    }

    public void regresarMenuPrincipalProfesor(){
        viewProfesorPrincipal.mostrarse();
    }

    public void darDeAltaExamenFinal(ExamenFinal examenFinal){ 
        try {
            DatabaseImpl.saveExamenFinal(examenFinal);
            viewProfesorAltaExamenFinal.operacionExitosa("Registro exitoso", "Un examen final fue registrado exitosamente.");
        } catch (Exception e) {
            viewProfesorAltaExamenFinal.operacionFallida("Error: ", e.getMessage());
        }
    }

    
}
