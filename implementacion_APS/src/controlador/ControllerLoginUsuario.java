package controlador;

import vista.ViewLoginUsuario;
import vista.ViewPrincipalAdministrador;
import vista.ViewPrincipalAlumno;

public interface ControllerLoginUsuario {
    

    public void setViewLoginUsuario(ViewLoginUsuario viewLoginUsuario);

    public void setViewPrincipalAdministrador(ViewPrincipalAdministrador viewPrincipalAdministrador);

    public void setViewPrincipalAlumno(ViewPrincipalAlumno viewPrincipalAlumno);

    public void autenticarUsuarioAdministrador(int username, String password);

    public void autenticarUsuarioAlumno(int username, String password);
}
