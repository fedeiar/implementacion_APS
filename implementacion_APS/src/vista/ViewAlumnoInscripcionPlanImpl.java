package vista;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controlador.ControllerAlumnoInscripcionPlan;

public class ViewAlumnoInscripcionPlanImpl extends JPanel implements ViewAlumnoInscripcionPlan{
    
    private MainWindow mainWindow;
    private ControllerAlumnoInscripcionPlan controllerAlumnoInscripcionPlan;

    private JButton btnCancelar;

    public ViewAlumnoInscripcionPlanImpl(MainWindow mainWindow, ControllerAlumnoInscripcionPlan controllerAlumnoInscripcionPlan){
        this.mainWindow = mainWindow;
        this.controllerAlumnoInscripcionPlan = controllerAlumnoInscripcionPlan;
        this.setBounds(100, 100, 1000, 600);
        setLayout(null);

        inicializarComponentes();
        inicializarListeners();
    }

    private void inicializarComponentes(){

        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(61, 500, 89, 23);
        add(btnCancelar);
    }

    private void inicializarListeners(){



        btnCancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                controllerAlumnoInscripcionPlan.regresarMenuPrincipalAlumno();
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
