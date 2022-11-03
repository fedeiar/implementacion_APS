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
import controlador.ControllerProfesorPrincipal;
import modelo.Alumno;
import modelo.Profesor;


public class ViewProfesorPrincipal extends JPanel{
    

    private MainWindow mainWindow;
    private ControllerProfesorPrincipal controllerProfesorPrincipal;

    private JLabel lblBienvenidoProfesor;
    private JButton btnLogOut;

    public Profesor profesor;

    public ViewProfesorPrincipal(MainWindow mainWindow, ControllerProfesorPrincipal controllerProfesorPrincipal){
        this.mainWindow = mainWindow;
        this.controllerProfesorPrincipal = controllerProfesorPrincipal;

        this.setBounds(100, 100, 1000, 600);
        setLayout(null);
        
        inicializarComponentes();
        inicializarListeners();
    }

    private void inicializarComponentes(){
        lblBienvenidoProfesor = new JLabel("Bienvenido Profesor.");
        lblBienvenidoProfesor.setHorizontalAlignment(SwingConstants.LEFT);
        lblBienvenidoProfesor.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblBienvenidoProfesor.setBounds(365, 36, 255, 60);
        add(lblBienvenidoProfesor);

        btnLogOut = new JButton("Logout");
        btnLogOut.setBounds(70, 500, 162, 23);
        add(btnLogOut);
    }

    private void inicializarListeners(){
        btnLogOut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                controllerProfesorPrincipal.cambiarVentanaLogin();
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

    public void setProfesor(Profesor profesor){
        this.profesor = profesor;
        lblBienvenidoProfesor.setSize(profesor.nombre.length() + profesor.apellido.length() * 50, 60);
        lblBienvenidoProfesor.setText("Bienvenido profesor " + profesor.nombre + " " + profesor.apellido);
    }
}
