package controlador;

import modelo.DatabaseImpl;
import modelo.Materia;
import modelo.Plan;
import vista.ViewAdminModificarPlan;
import vista.ViewAdminPrincipal;

public class ControllerAdminModificarPlan{
    

    private ViewAdminModificarPlan viewAdminModificarPlan;
    private ViewAdminPrincipal viewAdminPrincipal;


    public ControllerAdminModificarPlan(){

    }

    public void setViewAdminAgregarMatAPlan(ViewAdminModificarPlan viewAdminAgregarMatAPlan){
        this.viewAdminModificarPlan = viewAdminAgregarMatAPlan;
    }

    public void setViewPrincipalAdministrador(ViewAdminPrincipal viewPrincipalAdministrador){
        this.viewAdminPrincipal = viewPrincipalAdministrador;
    }

    public void regresarMenuPrincipalAdmin(){
        viewAdminPrincipal.mostrarse();
    }

    public void agregarMateriaAPlan(Plan plan, Materia materia){
        try{
            DatabaseImpl.savePlanMateria(plan, materia.codigo);
            viewAdminModificarPlan.operacionExitosa("Exito", "Materia agregada al plan exitosamente.");
        }catch(Exception e){
            viewAdminModificarPlan.operacionFallida("Error al agregar materia", e.getMessage());
        }
    }

    public void eliminarMateriaDePlan(Plan plan, Materia materia){
        try{
            DatabaseImpl.deletePlanMateria(plan, materia);
            viewAdminModificarPlan.operacionExitosa("Exito", "Materia elminiada del plan exitosamente.");
        } catch(Exception e){
            viewAdminModificarPlan.operacionFallida("Error al eliminar materia", e.getMessage());
        }
    }
}
