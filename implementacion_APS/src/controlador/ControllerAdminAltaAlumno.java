package controlador;

import modelo.Alumno;
import vista.ViewAdminAltaAlumno;
import vista.ViewAdminPrincipal;

public interface ControllerAdminAltaAlumno {
    

    public void setViewAdminAltaAlumno(ViewAdminAltaAlumno viewAdminAltaAlumno);

    public void darDeAltaAlumno(Alumno alumno);

    public void regresarMenuPrincipalAdmin();

    public void setViewPrincipalAdministrador(ViewAdminPrincipal viewPrincipalAdministrador);
}
