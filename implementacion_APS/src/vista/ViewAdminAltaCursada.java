package vista;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import controlador.ControllerAdminAltaCursada;
import modelo.Cursada;
import modelo.DatabaseImpl;
import modelo.Materia;
import modelo.Profesor;


public class ViewAdminAltaCursada extends JPanel{
    
    private MainWindow mainWindow;
    private ControllerAdminAltaCursada controllerAdminAltaCursada;

    private JButton btnCancelar, btnDarDeAltaCursada;
    private JLabel lblAltaCursada, lblElijaMateria, lblElijaProfesor, lblIngreseAnio, lblIngreseCuatrimestre;
    private JTextField tfAnio;
    private JComboBox<String> cbElegirMateria, cbProfesores, cbElegirCuatrimestre;

    private List<Materia> materias;
    private List<Profesor> profesores;

    public ViewAdminAltaCursada(MainWindow mainWindow, ControllerAdminAltaCursada controllerAdminAltaCursada){
        this.mainWindow = mainWindow;
        this.controllerAdminAltaCursada = controllerAdminAltaCursada;
        this.setBounds(100, 100, 1000, 600);
        setLayout(null);

        inicializarComponentes();
        inicializarListeners();
    }

    private void inicializarComponentes(){
        lblAltaCursada = new JLabel("Dar de alta cursada.");
        lblAltaCursada.setHorizontalAlignment(SwingConstants.LEFT);
        lblAltaCursada.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblAltaCursada.setBounds(365, 36, 255, 60);
        add(lblAltaCursada);

        lblElijaMateria = new JLabel("Elija una materia:");
        lblElijaMateria.setBounds(265, 169, 200, 17);
        add(lblElijaMateria);

        armarComboBoxMaterias();

        lblElijaProfesor = new JLabel("Elija un profesor:");
        lblElijaProfesor.setBounds(265, 210, 200, 17);
        add(lblElijaProfesor);

        armarComboBoxProfesores();

        lblIngreseAnio = new JLabel("Ingrese año de la cursada:");
        lblIngreseAnio.setBounds(220, 250, 200, 17);
        add(lblIngreseAnio);

        tfAnio = new JTextField();
        tfAnio.setBounds(389, 250, 160, 20);
        add(tfAnio);
        tfAnio.setColumns(10);

        lblIngreseCuatrimestre = new JLabel("Ingrese cuatrimestre de la cursada:");
        lblIngreseCuatrimestre.setBounds(160, 290, 220, 17);
        add(lblIngreseCuatrimestre);

        cbElegirCuatrimestre = new JComboBox<String>();
        cbElegirCuatrimestre.setBounds(389, 290, 200, 21);
        add(cbElegirCuatrimestre);
        cbElegirCuatrimestre.addItem("1");
        cbElegirCuatrimestre.addItem("2");

        btnDarDeAltaCursada = new JButton("Registrar");
        btnDarDeAltaCursada.setBounds(811, 500, 106, 23);
        add(btnDarDeAltaCursada);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(61, 500, 89, 23);
        add(btnCancelar);
    }

    private void inicializarListeners(){

        btnDarDeAltaCursada.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                int codigo_materia = materias.get(cbElegirMateria.getSelectedIndex()).codigo;
                int legajo_profesor = profesores.get(cbProfesores.getSelectedIndex()).legajo_docente;
                if(!utils.Utilities.isFieldInteger(tfAnio.getText())){ 
                    operacionFallida("Error: año", "El año debe ser un numero entero");
                    return;
                }
                int anio = Integer.parseInt(tfAnio.getText());
                int cuatrimestre = Integer.parseInt(cbElegirCuatrimestre.getSelectedItem().toString());

                Cursada cursada = new Cursada(codigo_materia, legajo_profesor, anio, cuatrimestre);

                controllerAdminAltaCursada.darDeAltaCursada(cursada);
            }
        });

        btnCancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                controllerAdminAltaCursada.regresarMenuPrincipalAdmin();
            }
        });
    }

    private void armarComboBoxMaterias(){
        cbElegirMateria = new JComboBox<String>();
        cbElegirMateria.setBounds(389, 167, 200, 21);
        add(cbElegirMateria);
        try{
            materias = DatabaseImpl.getMaterias();
            for(Materia materia : materias){
                cbElegirMateria.addItem(materia.nombre);
            }
        } catch(Exception e){
            this.operacionFallida("Error", e.getMessage());
        }
    }

    private void armarComboBoxProfesores(){
        cbProfesores = new JComboBox<String>();
        cbProfesores.setBounds(389, 210, 200, 21);
        add(cbProfesores);
        try{
            profesores = DatabaseImpl.getProfesores();
            for(Profesor profesor : profesores){
                cbProfesores.addItem(profesor.nombre + " " + profesor.apellido + " - LU: " + profesor.legajo_docente);
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

}
