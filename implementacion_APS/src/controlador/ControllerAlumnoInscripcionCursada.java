package controlador;

import modelo.Cursada;
import modelo.DatabaseImpl;
import vista.ViewAlumnoInscripcionCursada;
import vista.ViewAlumnoPrincipal;

public class ControllerAlumnoInscripcionCursada {
    
    private ViewAlumnoInscripcionCursada viewAlumnoInscripcionCursada;
    private ViewAlumnoPrincipal viewAlumnoPrincipal;

    public ControllerAlumnoInscripcionCursada(){

    }

    public void setViewAlumnoInscripcionCursada(ViewAlumnoInscripcionCursada viewAlumnoInscripcionCursada){
        this.viewAlumnoInscripcionCursada = viewAlumnoInscripcionCursada;
    }

    public void setViewAlumnoPrincipal(ViewAlumnoPrincipal viewAlumnoPrincipal){
        this.viewAlumnoPrincipal = viewAlumnoPrincipal;
    }

    public void regresarMenuPrincipalAlumno(){
        viewAlumnoPrincipal.mostrarse();
    }

    public void inscribirAlumnoEnCursada(Cursada cursada, int legajoAlumno){
        try{
            DatabaseImpl.saveInscripcionCursada(cursada, legajoAlumno);

            viewAlumnoInscripcionCursada.operacionExitosa("Inscripcion Exitosa", "Se ha inscrito a la materia "+cursada.nombreMateria+ " exitosamente");
        } catch(Exception e){
            viewAlumnoInscripcionCursada.operacionFallida("Error", e.getMessage());
        }
    }

}
