package vista;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import controlador.ControllerAdminAltaAlumno;
import modelo.Alumno;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAdminAltaAlumno extends JPanel{

	private MainWindow mainWindow;
    private ControllerAdminAltaAlumno controllerAdminAltaAlumno;

	private JTextField TFNombre;
	private JTextField TFApellido;
	private JTextField TFEmail;
	private JPasswordField TFPassword;
	private JTextField TFLegajo;
    private JButton btnRegistrar, btnCancelar;
    private JLabel lblEmail, lblAltaUsuario, lblContrasena, lblApellido, lblNombre, lblLegajo;
    
	
	public ViewAdminAltaAlumno(MainWindow mainWindow, ControllerAdminAltaAlumno controllerAdminAltaAlumno) {
        this.mainWindow = mainWindow;
        this.controllerAdminAltaAlumno = controllerAdminAltaAlumno;
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
        
        TFPassword = new JPasswordField();
        TFPassword.setColumns(10);
        TFPassword.setBounds(389, 231, 160, 20);
        add(TFPassword);

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
                String password = new String(TFPassword.getPassword());
                if(!utils.Utilities.isFieldInteger(TFLegajo.getText())){ //TODO: en realidad habría que obtener el legajo mas alto de la DB, sumarle 1 y colocarlo pero paja, si alguno lo quiere hacer joya.8
                    operacionFallida("Error: legajo", "El legajo debe ser un numero entero");
                    return;
                }
                int legajo = Integer.parseInt(TFLegajo.getText());
                Alumno alumno = new Alumno(email, password, nombre, apellido, legajo);

                controllerAdminAltaAlumno.darDeAltaAlumno(alumno);
            }
        });

        btnCancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                controllerAdminAltaAlumno.regresarMenuPrincipalAdmin();
            }
        });
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
