package controlador;

import modelo.Alumno;
import vista.ViewAdminAltaAlumno;
import vista.ViewPrincipalAdministrador;

public interface ControllerAdminAltaAlumno {
    

    public void setViewAdminAltaAlumno(ViewAdminAltaAlumno viewAdminAltaAlumno);

    public void darDeAltaAlumno(Alumno alumno);

    public void regresarMenuPrincipalAdmin();

    public void setViewPrincipalAdministrador(ViewPrincipalAdministrador viewPrincipalAdministrador);
}
