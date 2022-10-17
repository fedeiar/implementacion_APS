package controlador;

import vista.ViewLoginUsuario;
import vista.ViewAdminPrincipal;
import vista.ViewAlumnoPrincipal;

public interface ControllerLoginUsuario {
    

    public void setViewLoginUsuario(ViewLoginUsuario viewLoginUsuario);

    public void setViewPrincipalAdministrador(ViewAdminPrincipal viewPrincipalAdministrador);

    public void setViewPrincipalAlumno(ViewAlumnoPrincipal viewAlumnoPrincipal);

    public void autenticarUsuarioAdministrador(int username, String password);

    public void autenticarUsuarioAlumno(int username, String password);
}
