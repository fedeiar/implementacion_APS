package controlador;

import modelo.DatabaseImpl;
import modelo.Plan;
import vista.ViewAlumnoInscripcionCarrera;
import vista.ViewAlumnoPrincipal;

public class ControllerAlumnoInscripcionCarrera{
    
    private ViewAlumnoInscripcionCarrera viewAlumnoInscripcionCarrera;
    private ViewAlumnoPrincipal viewAlumnoPrincipal;

    public ControllerAlumnoInscripcionCarrera(){

    }

    public void setViewAlumnoInscripcionCarrera(ViewAlumnoInscripcionCarrera viewAlumnoInscripcionCarrera){
        this.viewAlumnoInscripcionCarrera = viewAlumnoInscripcionCarrera;
    }

    public void setViewAlumnoPrincipal(ViewAlumnoPrincipal viewAlumnoPrincipal){
        this.viewAlumnoPrincipal = viewAlumnoPrincipal;
    }

    public void regresarMenuPrincipalAlumno(){
        viewAlumnoPrincipal.mostrarse();
    }

    public void inscribirAlumnoEnCarrera(int legajo_alumno, String nombreCarrera){
        try{
            int codigoCarrera = DatabaseImpl.getCodigoCarrera(nombreCarrera);
            Plan plan = DatabaseImpl.getPlanMasRecienteDeCarrera(codigoCarrera);

            DatabaseImpl.saveInscripcion(legajo_alumno, plan);
            viewAlumnoInscripcionCarrera.operacionExitosa("Inscripcion Exitosa", "Se ha inscrito a la carrera "+nombreCarrera+ " exitosamente");
        } catch(Exception e){
            viewAlumnoInscripcionCarrera.operacionFallida("Error", e.getMessage());
        }
    }
}
