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


public class ViewAlumnoPrincipal extends JPanel{
    

    private MainWindow mainWindow;
    private ControllerAlumnoPrincipal controllerPrincipalAlumno;

    private JLabel lblBienvenidoAlumno;
    private JButton btnLogOut, btnInscripcionCarrera, btnInscripcionCursada;

    public Alumno alumno;

    public ViewAlumnoPrincipal(MainWindow mainWindow, ControllerAlumnoPrincipal controllerPrincipalAlumno){
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

        btnInscripcionCarrera = new JButton("Inscribirse a una carrera");
        btnInscripcionCarrera.setBounds(70, 450, 200, 23);
        add(btnInscripcionCarrera);

        btnInscripcionCursada = new JButton("Inscribirse a una cursada");
        btnInscripcionCursada.setBounds(300, 450, 200, 23);
        add(btnInscripcionCursada);

        btnLogOut = new JButton("Logout");
        btnLogOut.setBounds(70, 500, 162, 23);
        add(btnLogOut);
    }

    private void inicializarListeners(){
        btnInscripcionCarrera.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                controllerPrincipalAlumno.cambiarVentanaInscripcionCarrera();
            }
        });

        btnInscripcionCursada.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                controllerPrincipalAlumno.cambiarVentanaInscripcionCursada();
            }
        });


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

    // TODO: nose que les parece esto, pero necesitamos almacenar al alumno actual para inscribirlo a la carrera.
    public void setAlumno(Alumno alumno){
        this.alumno = alumno;
        lblBienvenidoAlumno.setSize(alumno.nombre.length() + alumno.apellido.length() * 50, 60);
        lblBienvenidoAlumno.setText("Bienvenido alumno " + alumno.nombre + " " + alumno.apellido);
    }
}
