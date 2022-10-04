package vista;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.ControllerAdminAltaAlumno;
import controlador.ControllerAdminAltaAlumnoImpl;
import controlador.ControllerAdminAltaCarrera;
import controlador.ControllerAdminAltaCarreraImpl;
import controlador.ControllerAdminAltaPlan;
import controlador.ControllerAdminAltaPlanImpl;
import controlador.ControllerLoginUsuario;
import controlador.ControllerLoginUsuarioImpl;
import controlador.ControllerPrincipalAdministrador;
import controlador.ControllerPrincipalAdministradorImpl;
import controlador.ControllerPrincipalAlumno;
import controlador.ControllerPrincipalAlumnoImpl;
import modelo.DatabaseImpl;

public class MainWindow extends JFrame{

	public MainWindow() {
		super("Obra social SanAr");
		this.setBounds(100, 100, 1000, 600);
        this.getContentPane().setBounds(100, 100, 1000, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
        this.setResizable(false);

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
        controllerPrincipalAdministrador.setViewLoginUsuario(viewLoginUsuario);
        controllerLoginUsuario.setViewPrincipalAdministrador(viewPrincipalAdministrador);
        
        // controller para la ventana principal del alumno
        ControllerPrincipalAlumno controllerPrincipalAlumno = new ControllerPrincipalAlumnoImpl();
        ViewPrincipalAlumno viewPrincipalAlumno = new ViewPrincipalAlumnoImpl(this, controllerPrincipalAlumno);
        controllerPrincipalAlumno.setViewPrincipalAlumno(viewPrincipalAlumno);
        controllerPrincipalAlumno.setViewLoginUsuario(viewLoginUsuario);
        // pasarle al controller el viewprincipalAlumno
        controllerLoginUsuario.setViewPrincipalAlumno(viewPrincipalAlumno);

        ControllerAdminAltaAlumno controllerAdminAltaAlumno = new ControllerAdminAltaAlumnoImpl();
        ViewAdminAltaAlumno viewAdminAltaAlumno = new ViewAdminAltaAlumnoImpl(this, controllerAdminAltaAlumno);
        controllerAdminAltaAlumno.setViewAdminAltaAlumno(viewAdminAltaAlumno);
        controllerAdminAltaAlumno.setViewPrincipalAdministrador(viewPrincipalAdministrador);
        controllerPrincipalAdministrador.setViewAdminAltaAlumno(viewAdminAltaAlumno);

        ControllerAdminAltaCarrera controllerAdminAltaCarrera = new ControllerAdminAltaCarreraImpl();
        ViewAdminAltaCarrera viewAdminAltaCarrera = new ViewAdminAltaCarreraImpl(this, controllerAdminAltaCarrera);
        controllerAdminAltaCarrera.setViewAdminAltaCarrera(viewAdminAltaCarrera);
        controllerAdminAltaCarrera.setViewPrincipalAdministrador(viewPrincipalAdministrador);
        controllerPrincipalAdministrador.setViewAdminAltaCarrera(viewAdminAltaCarrera);

        ControllerAdminAltaPlan controllerAdminAltaPlan = new ControllerAdminAltaPlanImpl();
        ViewAdminAltaPlan viewAdminAltaPlan = new ViewAdminAltaPlanImpl(this, controllerAdminAltaPlan);
        controllerAdminAltaPlan.setViewAdminAltaPlan(viewAdminAltaPlan);
        controllerAdminAltaPlan.setViewPrincipalAdministrador(viewPrincipalAdministrador);
        controllerPrincipalAdministrador.setViewAdminAltaPlan(viewAdminAltaPlan);

        viewLoginUsuario.mostrarse();
        
    }

	
}
