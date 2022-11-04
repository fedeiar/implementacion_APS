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

import controlador.ControllerAlumnoInscripcionCursada;
import modelo.Alumno;
import modelo.Cursada;
import modelo.DatabaseImpl;

public class ViewAlumnoInscripcionCursada extends JPanel{
    
    private MainWindow mainWindow;
    private ControllerAlumnoInscripcionCursada controllerAlumnoInscripcionCursada;
    private Alumno alumno;

    private JButton btnCancelar, btnInscribirse;
    private JLabel lblInscribirseCursada, lblElijaMateria;
    private JComboBox<String> cbElegirCursada;

    private List<Cursada> cursadas;

    public ViewAlumnoInscripcionCursada(MainWindow mainWindow, ControllerAlumnoInscripcionCursada controllerAlumnoInscripcionCursada){
        this.mainWindow = mainWindow;
        this.controllerAlumnoInscripcionCursada = controllerAlumnoInscripcionCursada;
        this.setBounds(100, 100, 1000, 600);
        setLayout(null);

        inicializarComponentes();
        inicializarListeners();
    }

    private void inicializarComponentes(){
        lblInscribirseCursada = new JLabel("Inscribirse a una cursada.");
        lblInscribirseCursada.setHorizontalAlignment(SwingConstants.LEFT);
        lblInscribirseCursada.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblInscribirseCursada.setBounds(365, 36, 255, 60);
        add(lblInscribirseCursada);

        lblElijaMateria = new JLabel("Elija una materia:");
        lblElijaMateria.setBounds(265, 169, 200, 17);
        add(lblElijaMateria);

        btnInscribirse = new JButton("Inscribirse");
        btnInscribirse.setBounds(811, 500, 106, 23);
        add(btnInscribirse);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(61, 500, 89, 23);
        add(btnCancelar);
    }

    private void inicializarListeners(){

        btnInscribirse.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                Cursada cursada = cursadas.get(cbElegirCursada.getSelectedIndex());
                controllerAlumnoInscripcionCursada.inscribirAlumnoEnCursada(cursada, alumno.legajo_alumno);
            }
        });

        btnCancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                controllerAlumnoInscripcionCursada.regresarMenuPrincipalAlumno();
            }
        });
    }

    private void armarComboBox() throws Exception{
        cbElegirCursada = new JComboBox<String>();
        cbElegirCursada.setBounds(389, 167, 160, 21);
        add(cbElegirCursada);
        
        cursadas = DatabaseImpl.getCursadasParaAlumno(alumno.legajo_alumno);
        for(Cursada cursada : cursadas){
            cbElegirCursada.addItem(cursada.nombreMateria+" - código: "+cursada.codigoMateria);
        }
    }

    public void mostrarse(){
        try{
            armarComboBox();

            mainWindow.setContentPane(this);
            mainWindow.revalidate();
        } catch(Exception e){
            this.operacionFallida("Error", e.getMessage());
        }
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
