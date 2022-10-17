package vista;

import javax.swing.JFrame;

import controlador.ControllerAdminAltaAlumno;
import controlador.ControllerAdminAltaAlumno;
import controlador.ControllerAdminAltaCarrera;
import controlador.ControllerAdminAltaPlan;
import controlador.ControllerAdminAgregarMatAPlan;
import controlador.ControllerLoginUsuario;
import controlador.ControllerLoginUsuario;
import controlador.ControllerAdminPrincipal;
import controlador.ControllerAlumnoPrincipal;
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

        ControllerLoginUsuario controllerLoginUsuario = new ControllerLoginUsuario();
        ViewLoginUsuario viewLoginUsuario = new ViewLoginUsuario(this, controllerLoginUsuario);
        controllerLoginUsuario.setViewLoginUsuario(viewLoginUsuario);

        ControllerAdminPrincipal controllerPrincipalAdministrador = new ControllerAdminPrincipal();
        ViewAdminPrincipal viewPrincipalAdministrador = new ViewAdminPrincipalImpl(this, controllerPrincipalAdministrador);
        controllerPrincipalAdministrador.setViewPrincipalAdministrador(viewPrincipalAdministrador);
        controllerPrincipalAdministrador.setViewLoginUsuario(viewLoginUsuario);
        controllerLoginUsuario.setViewPrincipalAdministrador(viewPrincipalAdministrador);
        
        ControllerAlumnoPrincipal controllerPrincipalAlumno = new ControllerAlumnoPrincipal();
        ViewAlumnoPrincipal viewAlumnoPrincipal = new ViewAlumnoPrincipal(this, controllerPrincipalAlumno);
        controllerPrincipalAlumno.setViewPrincipalAlumno(viewAlumnoPrincipal);
        controllerPrincipalAlumno.setViewLoginUsuario(viewLoginUsuario);
        controllerLoginUsuario.setViewPrincipalAlumno(viewAlumnoPrincipal);

        ControllerAdminAltaAlumno controllerAdminAltaAlumno = new ControllerAdminAltaAlumno();
        ViewAdminAltaAlumno viewAdminAltaAlumno = new ViewAdminAltaAlumno(this, controllerAdminAltaAlumno);
        controllerAdminAltaAlumno.setViewAdminAltaAlumno(viewAdminAltaAlumno);
        controllerAdminAltaAlumno.setViewPrincipalAdministrador(viewPrincipalAdministrador);
        controllerPrincipalAdministrador.setViewAdminAltaAlumno(viewAdminAltaAlumno);

        ControllerAdminAltaCarrera controllerAdminAltaCarrera = new ControllerAdminAltaCarrera();
        ViewAdminAltaCarrera viewAdminAltaCarrera = new ViewAdminAltaCarrera(this, controllerAdminAltaCarrera);
        controllerAdminAltaCarrera.setViewAdminAltaCarrera(viewAdminAltaCarrera);
        controllerAdminAltaCarrera.setViewPrincipalAdministrador(viewPrincipalAdministrador);
        controllerPrincipalAdministrador.setViewAdminAltaCarrera(viewAdminAltaCarrera);

        ControllerAdminAltaPlan controllerAdminAltaPlan = new ControllerAdminAltaPlan();
        ViewAdminAltaPlan viewAdminAltaPlan = new ViewAdminAltaPlan(this, controllerAdminAltaPlan);
        controllerAdminAltaPlan.setViewAdminAltaPlan(viewAdminAltaPlan);
        controllerAdminAltaPlan.setViewPrincipalAdministrador(viewPrincipalAdministrador);
        controllerPrincipalAdministrador.setViewAdminAltaPlan(viewAdminAltaPlan);

        ControllerAdminAgregarMatAPlan controllerAdminAgregarMatAPlan = new ControllerAdminAgregarMatAPlan();
        ViewAdminAgregarMatAPlan viewAdminAgregarMatAPlan = new ViewAdminAgregarMatAPlan(this, controllerAdminAgregarMatAPlan);
        controllerAdminAgregarMatAPlan.setViewAdminAgregarMatAPlan(viewAdminAgregarMatAPlan);
        controllerAdminAgregarMatAPlan.setViewPrincipalAdministrador(viewPrincipalAdministrador);
        controllerPrincipalAdministrador.setViewAdminAgregarMatAPlan(viewAdminAgregarMatAPlan);

        viewLoginUsuario.mostrarse();
        
    }

	
}
