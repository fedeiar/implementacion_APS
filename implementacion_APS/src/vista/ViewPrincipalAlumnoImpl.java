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


public class ViewPrincipalAlumnoImpl extends JPanel implements ViewPrincipalAlumno{
    

    private MainWindow mainWindow;
    private JLabel lblBienvenidoAlumno;

    public ViewPrincipalAlumnoImpl(MainWindow mainWindow){
        this.mainWindow = mainWindow;

        this.setBounds(100, 100, 1000, 600);
        setLayout(null);
        
        inicializarComponentes();
        inicializarListeners();
    }

    private void inicializarComponentes(){
        lblBienvenidoAlumno = new JLabel("Bienvenido Alumno.");
        lblBienvenidoAlumno.setHorizontalAlignment(SwingConstants.CENTER);
        lblBienvenidoAlumno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblBienvenidoAlumno.setBounds(365, 36, 255, 60);
        add(lblBienvenidoAlumno);

        
    }

    private void inicializarListeners(){
        
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
