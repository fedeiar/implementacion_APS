package vista;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import controlador.ControllerAlumnoInscripcionCarrera;
import modelo.Alumno;
import modelo.Carrera;
import modelo.DatabaseImpl;

public class ViewAlumnoInscripcionCarrera extends JPanel{
    
    private MainWindow mainWindow;
    private ControllerAlumnoInscripcionCarrera controllerAlumnoInscripcionCarrera;
    private Alumno alumno;

    private JButton btnCancelar, btnInscribirse;
    private JLabel lblInscribirseCarrera, lblElijaCarrera;
    private JComboBox<String> cbElegirCarrera;

    private List<Carrera> carreras;

    public ViewAlumnoInscripcionCarrera(MainWindow mainWindow, ControllerAlumnoInscripcionCarrera controllerAlumnoInscripcionPlan){
        this.mainWindow = mainWindow;
        this.controllerAlumnoInscripcionCarrera = controllerAlumnoInscripcionPlan;
        this.setBounds(100, 100, 1000, 600);
        setLayout(null);

        inicializarComponentes();
        inicializarListeners();
    }

    private void inicializarComponentes(){
        lblInscribirseCarrera = new JLabel("Inscribirse a una carrera.");
        lblInscribirseCarrera.setHorizontalAlignment(SwingConstants.LEFT);
        lblInscribirseCarrera.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblInscribirseCarrera.setBounds(365, 36, 255, 60);
        add(lblInscribirseCarrera);

        lblElijaCarrera = new JLabel("Elija una carrera:");
        lblElijaCarrera.setBounds(265, 169, 200, 17);
        add(lblElijaCarrera);

        armarComboBox();

        btnInscribirse = new JButton("Registrar");
        btnInscribirse.setBounds(811, 500, 106, 23);
        add(btnInscribirse);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(61, 500, 89, 23);
        add(btnCancelar);
    }

    private void inicializarListeners(){

        btnInscribirse.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                String nombreCarrera = cbElegirCarrera.getSelectedItem().toString();
                //TODO: pasar el objeto carrera directamente.
                controllerAlumnoInscripcionCarrera.inscribirAlumnoEnCarrera(alumno.legajo_alumno, nombreCarrera);
            }
        });

        btnCancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                controllerAlumnoInscripcionCarrera.regresarMenuPrincipalAlumno();
            }
        });
    }

    private void armarComboBox(){
        cbElegirCarrera = new JComboBox<String>();
        cbElegirCarrera.setBounds(389, 167, 160, 21);
        add(cbElegirCarrera);
        try{
            carreras = DatabaseImpl.getCarreras();
            for(Carrera carrera : carreras){
                cbElegirCarrera.addItem(carrera.nombre);
            }
        } catch(Exception e){
            this.operacionFallida("Error", e.getMessage());
        }
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
    }
}
