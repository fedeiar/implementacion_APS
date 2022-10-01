package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame{


    private ViewLoginUsuario viewLoginUsuario;

	public MainWindow() {
		super("Obra social SanAr");
		this.setBounds(100, 100, 1000, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

        crearVistas();
	}

    private void crearVistas(){

        viewLoginUsuario = new ViewLoginUsuarioImpl();
        this.setContentPane(viewLoginUsuario.getContent());
    }

	
}
