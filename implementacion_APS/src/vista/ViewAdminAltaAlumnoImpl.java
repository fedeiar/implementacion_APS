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
    private JButton btnRegistrar, btnCancelar;
    private JLabel lblEmail, lblAltaUsuario, lblContrasena, lblApellido, lblNombre, lblLegajo;
	
	public ViewAdminAltaAlumnoImpl(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.setBounds(100, 100, 1000, 600);
        setLayout(null);
                
        inicializarComponentes();
        inicializarListeners();
	}
	
	private void inicializarComponentes(){
        lblAltaUsuario = new JLabel("Alta de Usuario");
        lblAltaUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblAltaUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        lblAltaUsuario.setBounds(358, 31, 210, 29);
        add(lblAltaUsuario);

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

        TFLegajo = new JTextField();
        TFLegajo.setColumns(10);
        TFLegajo.setBounds(389, 268, 160, 20);
        add(TFLegajo);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(295, 136, 56, 17);
        add(lblNombre);
        
        lblApellido = new JLabel("Apellido");
        lblApellido.setBounds(295, 169, 56, 17);
        add(lblApellido);

        lblEmail = new JLabel("Email:");
        lblEmail.setBounds(295, 202, 56, 17);
        add(lblEmail);

        lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(295, 233, 70, 17);
        add(lblContrasena);
        
        lblLegajo = new JLabel("Legajo:");
        lblLegajo.setBounds(295, 271, 70, 17);
        add(lblLegajo);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(61, 500, 89, 23);
        add(btnCancelar);
        
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(811, 500, 106, 23);
        add(btnRegistrar);
	}

    private void inicializarListeners(){

        btnRegistrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                String nombre = TFNombre.getText();
                String apellido = TFApellido.getText();
                String email = TFEmail.getText();
                // SEGUIR
            }
        });
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
