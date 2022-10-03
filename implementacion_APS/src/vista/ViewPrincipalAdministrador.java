package vista;

import java.awt.Container;

public interface ViewPrincipalAdministrador{

    public void mostrarse();

    public void operacionExitosa(String titulo, String mensaje);

    public void operacionFallida(String titulo, String mensaje);

}