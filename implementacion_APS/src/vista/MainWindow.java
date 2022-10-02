package vista;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.ControllerAdminAltaAlumno;
import controlador.ControllerAdminAltaAlumnoImpl;
import controlador.ControllerLoginUsuario;
import controlador.ControllerLoginUsuarioImpl;
import controlador.ControllerPrincipalAdministrador;
import controlador.ControllerPrincipalAdministradorImpl;
import modelo.DatabaseImpl;

public class MainWindow extends JFrame{

	public MainWindow() {
		super("Obra social SanAr");
		this.setBounds(100, 100, 1000, 600);
        this.getContentPane().setBounds(100, 100, 1000, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

        crearVistas();
	}

    private void crearVistas(){
        DatabaseImpl.createDatabase();

        ControllerLoginUsuario controllerLoginUsuario = new ControllerLoginUsuarioImpl();
        ViewLoginUsuario viewLoginUsuario = new ViewLoginUsuarioImpl(this, controllerLoginUsuario);
        controllerLoginUsuario.setViewLoginUsuario(viewLoginUsuario);

        ControllerPrincipalAdministrador controllerPrincipalAdministrador = new ControllerPrincipalAdministradorImpl();
        ViewPrincipalAdministrador viewPrincipalAdministrador = new ViewPrincipalAdministradorImpl(this, controllerPrincipalAdministrador);
        controllerPrincipalAdministrador.setViewPrincipalAdministrador(viewPrincipalAdministrador);
        controllerLoginUsuario.setViewPrincipalAdministrador(viewPrincipalAdministrador);

        ControllerAdminAltaAlumno controllerAdminAltaAlumno = new ControllerAdminAltaAlumnoImpl();
        ViewAdminAltaAlumno viewAdminAltaAlumno = new ViewAdminAltaAlumnoImpl(this);
        controllerAdminAltaAlumno.setViewAdminAltaAlumno(viewAdminAltaAlumno);
        controllerPrincipalAdministrador.setViewAdminAltaAlumno(viewAdminAltaAlumno);

        viewLoginUsuario.mostrarse();
        
    }

	
}
