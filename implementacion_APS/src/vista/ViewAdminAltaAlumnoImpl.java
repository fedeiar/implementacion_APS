package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAdminAltaAlumnoImpl extends JPanel implements ViewAdminAltaAlumno{

	private MainWindow mainWindow;
	private JTextField TFNombre;
	private JTextField TFApellido;
	private JTextField TFEmail;
	private JTextField TFContrasena;
	private JTextField TFLegajo;
	
	public ViewAdminAltaAlumnoImpl(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.setBounds(100, 100, 1000, 600);
        setLayout(null);
                
        inicializarComponentes();
        inicializarListeners();
	}
	
	private void inicializarComponentes(){
		TFNombre = new JTextField();
        TFNombre.setBounds(389, 133, 160, 20);
        add(TFNombre);
        TFNombre.setColumns(10);
        
        TFApellido = new JTextField();
        TFApellido.setColumns(10);
        TFApellido.setBounds(389, 167, 160, 20);
        add(TFApellido);
        
        TFEmail = new JTextField();
        TFEmail.setColumns(10);
        TFEmail.setBounds(389, 200, 160, 20);
        add(TFEmail);
        
        TFContrasena = new JTextField();
        TFContrasena.setColumns(10);
        TFContrasena.setBounds(389, 231, 160, 20);
        add(TFContrasena);
        
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(295, 202, 56, 17);
        add(lblEmail);
        
        JLabel lblNewLabel = new JLabel("Alta de Usuario");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(358, 31, 210, 29);
        add(lblNewLabel);
        
        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(295, 233, 70, 17);
        add(lblContrasena);
        
        JLabel lblApellido = new JLabel("Apellido");
        lblApellido.setBounds(295, 169, 56, 17);
        add(lblApellido);
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(295, 136, 56, 17);
        add(lblNombre);
        
        TFLegajo = new JTextField();
        TFLegajo.setColumns(10);
        TFLegajo.setBounds(389, 268, 160, 20);
        add(TFLegajo);
        
        JLabel lblLegajo = new JLabel("Legajo:");
        lblLegajo.setBounds(295, 271, 70, 17);
        add(lblLegajo);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(61, 546, 89, 23);
        add(btnCancelar);
        
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(811, 546, 106, 23);
        add(btnRegistrar);
	}

    private void inicializarListeners(){

    }

    public Container getContent(){
        return this;
    }

    public void mostrarse(){
        mainWindow.setContentPane(this);
        mainWindow.revalidate();
    }

    public void operacionExitosa(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null,mensaje,titulo,JOptionPane.INFORMATION_MESSAGE);
    }

    public void operacionFallida(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }
}
