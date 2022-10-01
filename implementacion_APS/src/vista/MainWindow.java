package vista;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.ControllerLoginUsuario;
import controlador.ControllerLoginUsuarioImpl;
import controlador.ControllerPrincipalAdministrador;
import controlador.ControllerPrincipalAdministradorImpl;
import modelo.DatabaseImpl;

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

        try{
            DatabaseImpl.createDatabase();

            ControllerLoginUsuario controllerLoginUsuario = new ControllerLoginUsuarioImpl();
            viewLoginUsuario = new ViewLoginUsuarioImpl(this, controllerLoginUsuario);
            controllerLoginUsuario.setViewLoginUsuario(viewLoginUsuario);

            ControllerPrincipalAdministrador controllerPrincipalAdministrador = new ControllerPrincipalAdministradorImpl();
            viewPrincipalAdministrador = new ViewPrincipalAdministradorImpl(this);
            controllerPrincipalAdministrador.setViewPrincipalAdministrador(viewPrincipalAdministrador);
            controllerLoginUsuario.setViewPrincipalAdministrador(viewPrincipalAdministrador);
        
            viewLoginUsuario.mostrarse();
        } catch(Exception e){
            // TODO: no es lo mas feliz del mundo pero sino nose donde creamos la DB.
            e.printStackTrace();
        }
    }

	
}
