package vista;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controlador.ControllerLoginUsuario;
import utils.Utilities;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import java.awt.event.ActionEvent;

public class ViewLoginUsuarioImpl extends JPanel implements ViewLoginUsuario{

    private MainWindow mainWindow;
    private ControllerLoginUsuario controllerLoginUsuario;

	private JTextField TFLogin;
	private JPasswordField TFContrasena;
    private JLabel lblUsername;
    private JLabel lblContrasena;
    private JLabel lblSeleccionUsuario;
    private JRadioButton RBAdministrador;
    private JRadioButton RBAlumno;
    private ButtonGroup BGgrupoUsuarios;
    private JButton btnLogin;
	
	public ViewLoginUsuarioImpl(MainWindow mainWindow, ControllerLoginUsuario controllerLoginUsuario) {
        this.mainWindow = mainWindow;
        this.controllerLoginUsuario = controllerLoginUsuario;
        this.setBounds(100, 100, 1000, 600);
        setLayout(null);

        inicializarComponentes();
        inicializarListeners();
	}

    private void inicializarComponentes(){
        TFLogin = new JTextField();
        TFLogin.setBounds(422, 161, 164, 20);
        add(TFLogin);
        TFLogin.setColumns(10);
        
        lblUsername = new JLabel("Usuario:");
        lblUsername.setBounds(345, 164, 67, 14);
        add(lblUsername);
        
        TFContrasena = new JPasswordField();
        TFContrasena.setColumns(10);
        TFContrasena.setBounds(422, 192, 164, 20);
        add(TFContrasena);
        
        lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(324, 195, 88, 14);
        add(lblContrasena);
        
        RBAdministrador = new JRadioButton("Administrador");
        RBAdministrador.setBounds(647, 160, 109, 23);
        RBAdministrador.setSelected(true);
        add(RBAdministrador);
        
        RBAlumno = new JRadioButton("Alumno");
        RBAlumno.setBounds(647, 191, 109, 23);
        add(RBAlumno);

        BGgrupoUsuarios = new ButtonGroup();
        BGgrupoUsuarios.add(RBAlumno);
        BGgrupoUsuarios.add(RBAdministrador);
        
        lblSeleccionUsuario = new JLabel("Elija que tipo de usuario es:");
        lblSeleccionUsuario.setBounds(651, 139, 164, 14);
        add(lblSeleccionUsuario);
        
        btnLogin = new JButton("Login");
        btnLogin.setBounds(422, 252, 89, 23);
        add(btnLogin);
    }

    private void inicializarListeners(){
        btnLogin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                if(!Utilities.isFieldInteger(TFLogin.getText())){
                    operacionFallida("Error: username", "El nombre de usuario debe ser un numero entero que represente un legajo");
                    return;
                }
                int legajo = Integer.parseInt(TFLogin.getText());  // TODO: bloquear solo int
                if(RBAdministrador.isSelected()){
                    controllerLoginUsuario.autenticarUsuarioAdministrador(legajo, new String(TFContrasena.getPassword()));
                } else{
                    controllerLoginUsuario.autenticarUsuarioAlumno(legajo, new String(TFContrasena.getPassword()));
                }
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
