package vista;

import javax.swing.JFrame;

import controlador.ControllerAdminAltaAlumno;
import controlador.ControllerAdminAltaAlumnoImpl;
import controlador.ControllerAdminAgregarMatAPlanImpl;
import controlador.ControllerAdminAltaCarrera;
import controlador.ControllerAdminAltaCarreraImpl;
import controlador.ControllerAdminAltaPlan;
import controlador.ControllerAdminAltaPlanImpl;
import controlador.ControllerAdminAgregarMatAPlan;
import controlador.ControllerLoginUsuario;
import controlador.ControllerLoginUsuarioImpl;
import controlador.ControllerAdminPrincipal;
import controlador.ControllerAdminPrincipalImpl;
import controlador.ControllerAlumnoPrincipal;
import controlador.ControllerAlumnoPrincipalImpl;
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

        ControllerAdminPrincipal controllerPrincipalAdministrador = new ControllerAdminPrincipalImpl();
        ViewAdminPrincipal viewPrincipalAdministrador = new ViewAdminPrincipalImpl(this, controllerPrincipalAdministrador);
        controllerPrincipalAdministrador.setViewPrincipalAdministrador(viewPrincipalAdministrador);
        controllerPrincipalAdministrador.setViewLoginUsuario(viewLoginUsuario);
        controllerLoginUsuario.setViewPrincipalAdministrador(viewPrincipalAdministrador);
        
        ControllerAlumnoPrincipal controllerPrincipalAlumno = new ControllerAlumnoPrincipalImpl();
        ViewAlumnoPrincipal viewAlumnoPrincipal = new ViewAlumnoPrincipalImpl(this, controllerPrincipalAlumno);
        controllerPrincipalAlumno.setViewPrincipalAlumno(viewAlumnoPrincipal);
        controllerPrincipalAlumno.setViewLoginUsuario(viewLoginUsuario);
        controllerLoginUsuario.setViewPrincipalAlumno(viewAlumnoPrincipal);

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

        ControllerAdminAgregarMatAPlan controllerAdminAgregarMatAPlan = new ControllerAdminAgregarMatAPlanImpl();
        ViewAdminAgregarMatAPlan viewAdminAgregarMatAPlan = new ViewAdminAgregarMatAPlanImpl(this, controllerAdminAgregarMatAPlan);
        controllerAdminAgregarMatAPlan.setViewAdminAgregarMatAPlan(viewAdminAgregarMatAPlan);
        controllerAdminAgregarMatAPlan.setViewPrincipalAdministrador(viewPrincipalAdministrador);
        controllerPrincipalAdministrador.setViewAdminAgregarMatAPlan(viewAdminAgregarMatAPlan);

        viewLoginUsuario.mostrarse();
        
    }

	
}
