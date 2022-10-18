package vista;

import javax.swing.JFrame;

import controlador.ControllerAdminAltaMateria;
import controlador.ControllerAdminAltaAlumno;
import controlador.ControllerAdminAltaCarrera;
import controlador.ControllerAdminAltaCursada;
import controlador.ControllerAdminAltaPlan;
import controlador.ControllerAdminModificarPlan;
import controlador.ControllerLoginUsuario;
import controlador.ControllerAdminPrincipal;
import controlador.ControllerAlumnoInscripcionCarrera;
import controlador.ControllerAlumnoPrincipal;
import modelo.DatabaseImpl;

public class MainWindow extends JFrame{

	public MainWindow() {
		super("Sistema Universitario");
		this.setBounds(100, 100, 1000, 600);
        this.getContentPane().setBounds(100, 100, 1000, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
        this.setResizable(false);
        
        crearVistas();
	}

    private void crearVistas(){
        DatabaseImpl.createDatabase();

        // FUNCIONALIDAD DEL LOGIN

        ControllerLoginUsuario controllerLoginUsuario = new ControllerLoginUsuario();
        ViewLoginUsuario viewLoginUsuario = new ViewLoginUsuario(this, controllerLoginUsuario);
        controllerLoginUsuario.setViewLoginUsuario(viewLoginUsuario);

        // FUNCIONALIDAD DEL ADMINISTRADOR

        ControllerAdminPrincipal controllerAdminPrincipal = new ControllerAdminPrincipal();
        ViewAdminPrincipal viewAdminPrincipal = new ViewAdminPrincipal(this, controllerAdminPrincipal);
        controllerAdminPrincipal.setViewPrincipalAdministrador(viewAdminPrincipal);
        controllerAdminPrincipal.setViewLoginUsuario(viewLoginUsuario);
        controllerLoginUsuario.setViewPrincipalAdministrador(viewAdminPrincipal);

        ControllerAdminAltaAlumno controllerAdminAltaAlumno = new ControllerAdminAltaAlumno();
        ViewAdminAltaAlumno viewAdminAltaAlumno = new ViewAdminAltaAlumno(this, controllerAdminAltaAlumno);
        controllerAdminAltaAlumno.setViewAdminAltaAlumno(viewAdminAltaAlumno);
        controllerAdminAltaAlumno.setViewPrincipalAdministrador(viewAdminPrincipal);
        controllerAdminPrincipal.setViewAdminAltaAlumno(viewAdminAltaAlumno);

        ControllerAdminAltaCarrera controllerAdminAltaCarrera = new ControllerAdminAltaCarrera();
        ViewAdminAltaCarrera viewAdminAltaCarrera = new ViewAdminAltaCarrera(this, controllerAdminAltaCarrera);
        controllerAdminAltaCarrera.setViewAdminAltaCarrera(viewAdminAltaCarrera);
        controllerAdminAltaCarrera.setViewPrincipalAdministrador(viewAdminPrincipal);
        controllerAdminPrincipal.setViewAdminAltaCarrera(viewAdminAltaCarrera);

        ControllerAdminAltaPlan controllerAdminAltaPlan = new ControllerAdminAltaPlan();
        ViewAdminAltaPlan viewAdminAltaPlan = new ViewAdminAltaPlan(this, controllerAdminAltaPlan);
        controllerAdminAltaPlan.setViewAdminAltaPlan(viewAdminAltaPlan);
        controllerAdminAltaPlan.setViewPrincipalAdministrador(viewAdminPrincipal);
        controllerAdminPrincipal.setViewAdminAltaPlan(viewAdminAltaPlan);

        ControllerAdminModificarPlan controllerAdminModificarPlan = new ControllerAdminModificarPlan();
        ViewAdminModificarPlan viewAdminAgregarMatAPlan = new ViewAdminModificarPlan(this, controllerAdminModificarPlan);
        controllerAdminModificarPlan.setViewAdminAgregarMatAPlan(viewAdminAgregarMatAPlan);
        controllerAdminModificarPlan.setViewPrincipalAdministrador(viewAdminPrincipal);
        controllerAdminPrincipal.setViewAdminModificarPlan(viewAdminAgregarMatAPlan);

        ControllerAdminAltaCursada controllerAdminAltaCursada = new ControllerAdminAltaCursada();
        ViewAdminAltaCursada viewAdminAltaCursada = new ViewAdminAltaCursada(this, controllerAdminAltaCursada);
        controllerAdminAltaCursada.setViewAdminAltaCursada(viewAdminAltaCursada);
        controllerAdminAltaCursada.setViewAdminPrincipal(viewAdminPrincipal);
        controllerAdminPrincipal.setViewAdminAltaCursada(viewAdminAltaCursada);

        ControllerAdminAltaMateria controllerAdminAltaMateria = new ControllerAdminAltaMateria();
        ViewAdminAltaMateria viewAdminAltaMateria = new ViewAdminAltaMateria(this, controllerAdminAltaMateria);
        controllerAdminAltaMateria.setViewAdminAltaMateria(viewAdminAltaMateria);
        controllerAdminAltaMateria.setViewPrincipalAdministrador(viewAdminPrincipal);
        controllerAdminPrincipal.setViewAdminAltaMateria(viewAdminAltaMateria);


        // FUNCIONALIDAD DEL ALUMNO

        ControllerAlumnoPrincipal controllerPrincipalAlumno = new ControllerAlumnoPrincipal();
        ViewAlumnoPrincipal viewAlumnoPrincipal = new ViewAlumnoPrincipal(this, controllerPrincipalAlumno);
        controllerPrincipalAlumno.setViewPrincipalAlumno(viewAlumnoPrincipal);
        controllerPrincipalAlumno.setViewLoginUsuario(viewLoginUsuario);
        controllerLoginUsuario.setViewPrincipalAlumno(viewAlumnoPrincipal);

        ControllerAlumnoInscripcionCarrera controllerAlumnoInscripcionPlan = new ControllerAlumnoInscripcionCarrera();
        ViewAlumnoInscripcionCarrera viewAlumnoInscripcionCarrera = new ViewAlumnoInscripcionCarrera(this, controllerAlumnoInscripcionPlan);
        controllerAlumnoInscripcionPlan.setViewAlumnoInscripcionPlan(viewAlumnoInscripcionCarrera);
        controllerAlumnoInscripcionPlan.setViewAlumnoPrincipal(viewAlumnoPrincipal);
        controllerPrincipalAlumno.setViewAlumnoInscripcionCarrera(viewAlumnoInscripcionCarrera);

        viewLoginUsuario.mostrarse();
        
    }

	
}
