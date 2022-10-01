package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.ControllerLoginUsuario;
import controlador.ControllerLoginUsuarioImpl;

public class MainWindow extends JFrame{


    private ViewLoginUsuario viewLoginUsuario;
    private ViewPrincipalAdministrador viewPrincipalAdministrador;


	public MainWindow() {
		super("Obra social SanAr");
		this.setBounds(100, 100, 1000, 600);
        this.getContentPane().setBounds(100, 100, 1000, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

        crearVistas();
	}

    private void crearVistas(){

        ControllerLoginUsuario controllerLoginUsuario = new ControllerLoginUsuarioImpl();
        viewLoginUsuario = new ViewLoginUsuarioImpl(this, controllerLoginUsuario);
        controllerLoginUsuario.setViewLoginUsuario(viewLoginUsuario);

        // aca crear el controller del viewprincipalAdmin
        viewPrincipalAdministrador = new ViewPrincipalAdministradorImpl(this);
        // y aca setearselo
        controllerLoginUsuario.setViewPrincipalAdministrador(viewPrincipalAdministrador);
       
        viewLoginUsuario.mostrarse();
    }

	
}
