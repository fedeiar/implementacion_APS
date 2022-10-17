package vista;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import controlador.ControllerAlumnoPrincipal;
import modelo.Alumno;


public class ViewAlumnoPrincipalImpl extends JPanel implements ViewAlumnoPrincipal{
    

    private MainWindow mainWindow;
    private ControllerAlumnoPrincipal controllerPrincipalAlumno;

    private JLabel lblBienvenidoAlumno;
    private JButton btnLogOut;

    public Alumno alumno;

    public ViewAlumnoPrincipalImpl(MainWindow mainWindow, ControllerAlumnoPrincipal controllerPrincipalAlumno){
        this.mainWindow = mainWindow;
        this.controllerPrincipalAlumno = controllerPrincipalAlumno;

        this.setBounds(100, 100, 1000, 600);
        setLayout(null);
        
        inicializarComponentes();
        inicializarListeners();
    }

    private void inicializarComponentes(){
        lblBienvenidoAlumno = new JLabel("Bienvenido Alumno.");
        lblBienvenidoAlumno.setHorizontalAlignment(SwingConstants.LEFT);
        lblBienvenidoAlumno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblBienvenidoAlumno.setBounds(365, 36, 255, 60);
       
        add(lblBienvenidoAlumno);

        btnLogOut = new JButton("Logout");
        btnLogOut.setBounds(100, 500, 162, 23);
        add(btnLogOut);
    }

    private void inicializarListeners(){
        btnLogOut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                controllerPrincipalAlumno.cambiarVentanaLogin();
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

    public void setAlumno(Alumno alumno){
        this.alumno = alumno;
        lblBienvenidoAlumno.setSize(alumno.nombre.length() + alumno.apellido.length() * 50, 36);
        lblBienvenidoAlumno.setText("Bienvenido alumno " + alumno.nombre + " " + alumno.apellido);
    }
}
