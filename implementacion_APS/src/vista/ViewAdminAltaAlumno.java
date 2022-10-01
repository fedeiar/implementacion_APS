package vista;

import java.awt.Container;

public interface ViewAdminAltaAlumno {
    
    public Container getContent();

    public void mostrarse();

    public void operacionExitosa(String titulo, String mensaje);

    public void operacionFallida(String titulo, String mensaje);
}
