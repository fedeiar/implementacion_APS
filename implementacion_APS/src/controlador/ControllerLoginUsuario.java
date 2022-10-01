package controlador;

import vista.ViewLoginUsuario;
import vista.ViewPrincipalAdministrador;

public interface ControllerLoginUsuario {
    

    public void setViewLoginUsuario(ViewLoginUsuario viewLoginUsuario);

    public void setViewPrincipalAdministrador(ViewPrincipalAdministrador viewPrincipalAdministrador);

    public boolean isUsernameInteger(String legajo);

    public void autenticarUsuarioAdministrador(int username, String password);

}
