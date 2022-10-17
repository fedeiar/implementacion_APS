package vista;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import controlador.ControllerAdminPrincipal;


public class ViewAdminPrincipal extends JPanel{

    private MainWindow mainWindow;
    private ControllerAdminPrincipal controllerAdminPrincipal;

    private JLabel lblBienvenido;
    private JButton btnLogOut;
    private JButton btnDarDeAltaAlumno;
    private JButton btnDarDeAltaCarrera;
    private JButton btnDarDeAltaPlan;
    private JButton btnAgregarMatAPlan;

	public ViewAdminPrincipal(MainWindow mainWindow, ControllerAdminPrincipal controllerPrincipalAdministrador) {
        this.mainWindow = mainWindow;
        this.controllerAdminPrincipal = controllerPrincipalAdministrador;
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

        btnDarDeAltaCarrera = new JButton("Dar de alta carrera");
        btnDarDeAltaCarrera.setBounds(374, 445, 162, 23);
        add(btnDarDeAltaCarrera);

        btnDarDeAltaPlan = new JButton("Dar de alta plan");
        btnDarDeAltaPlan.setBounds(574, 445, 162, 23);
        add(btnDarDeAltaPlan);

        btnAgregarMatAPlan = new JButton("Agregar nueva materia a Plan");
        btnAgregarMatAPlan.setBounds(274, 500, 300, 23);
        add(btnAgregarMatAPlan);

        btnLogOut = new JButton("Logout");
        btnLogOut.setBounds(100, 500, 162, 23);
        add(btnLogOut);
    }

    private void inicializarListeners(){
        btnDarDeAltaAlumno.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                controllerAdminPrincipal.cambiarVentanaAltaAlumno();
            }
        });

        btnDarDeAltaCarrera.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                controllerAdminPrincipal.cambiarVentanaAltaCarrera();
            }
        });
        btnDarDeAltaPlan.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                controllerAdminPrincipal.cambiarVentanaAltaPlan();
            }
        }); 
        
        btnAgregarMatAPlan.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                controllerAdminPrincipal.cambiarVentanaAgregarMatAPlan();
            }
        });

        btnLogOut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                controllerAdminPrincipal.cambiarVentanaLoginUsuario();
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
