package vista;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import javax.swing.SwingConstants;

import controlador.ControllerLoginUsuario;
import controlador.ControllerPrincipalAdministrador;


public class ViewPrincipalAdministradorImpl extends JPanel implements ViewPrincipalAdministrador{

    private MainWindow mainWindow;
    private ControllerPrincipalAdministrador controllerPrincipalAdministrador;

    private JLabel lblBienvenido;
    private JButton btnDarDeAltaAlumno;

	public ViewPrincipalAdministradorImpl(MainWindow mainWindow, ControllerPrincipalAdministrador controllerPrincipalAdministrador) {
        this.mainWindow = mainWindow;
        this.controllerPrincipalAdministrador = controllerPrincipalAdministrador;
        this.setBounds(100, 100, 1000, 600);
        setLayout(null);
        
        inicializarComponentes();
        inicializarListeners();
	}

    private void inicializarComponentes(){
        lblBienvenido = new JLabel("Bienvenido Administrador.");
        lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
        lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblBienvenido.setBounds(365, 36, 255, 60);
        add(lblBienvenido);

        btnDarDeAltaAlumno = new JButton("Dar de alta alumno");
        btnDarDeAltaAlumno.setBounds(174, 445, 162, 23);
        add(btnDarDeAltaAlumno);
    }

    private void inicializarListeners(){
        btnDarDeAltaAlumno.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                controllerPrincipalAdministrador.cambiarVentanaAltaAlumno();
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
