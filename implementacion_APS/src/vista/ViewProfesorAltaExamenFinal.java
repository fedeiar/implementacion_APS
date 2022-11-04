package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import controlador.ControllerProfesorAltaExamenFinal;
import modelo.ExamenFinal;
import modelo.Profesor;
import modelo.Cursada;
import modelo.DatabaseImpl;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ViewProfesorAltaExamenFinal extends JPanel{

	private MainWindow mainWindow;
    private ControllerProfesorAltaExamenFinal controllerProfesorAltaExamenFinal;
    private Profesor profesor;

	private JTextField TFFecha;
    private JButton btnRegistrar, btnCancelar;
    private JLabel lblAltaExamenFinal, lblFecha;
    private JComboBox<String> cbElegirCursadaDictProfesor;

    private List<Cursada> cursadasDictProfesor;
	
	public ViewProfesorAltaExamenFinal(MainWindow mainWindow, ControllerProfesorAltaExamenFinal controllerProfesorAltaExamenFinal) {
        this.mainWindow = mainWindow;
        this.controllerProfesorAltaExamenFinal = controllerProfesorAltaExamenFinal;
        this.setBounds(100, 100, 1000, 600);
        setLayout(null);
                
        inicializarComponentes();
        inicializarListeners();
	}
	
	private void inicializarComponentes(){
        lblAltaExamenFinal = new JLabel("Alta de Examen Final");
        lblAltaExamenFinal.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblAltaExamenFinal.setHorizontalAlignment(SwingConstants.CENTER);
        lblAltaExamenFinal.setBounds(358, 31, 210, 29);
        add(lblAltaExamenFinal);

        TFFecha = new JTextField();
        TFFecha.setBounds(389, 133, 160, 20);
        add(TFFecha);
        TFFecha.setColumns(10);
        
        lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(295, 136, 56, 17);
        add(lblFecha);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(61, 500, 89, 23);
        add(btnCancelar);
        
        btnRegistrar = new JButton("Crear Mesa de Examen Final");
        btnRegistrar.setBounds(750, 500, 200, 23);
        add(btnRegistrar);
	}

    private void inicializarListeners(){
        btnRegistrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                int legajoProfesor = profesor.legajo_docente;
                String fecha = TFFecha.getText();
                Cursada cursada = cursadasDictProfesor.get(cbElegirCursadaDictProfesor.getSelectedIndex());

                ExamenFinal examenFinal = new ExamenFinal(cursada.codigoMateria, legajoProfesor, fecha);
                controllerProfesorAltaExamenFinal.darDeAltaExamenFinal(examenFinal);
            }
        });

        btnCancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                controllerProfesorAltaExamenFinal.regresarMenuPrincipalProfesor();
            }
        });
    }

    private void armarComboBox() throws Exception{
        cbElegirCursadaDictProfesor = new JComboBox<String>();
        cbElegirCursadaDictProfesor.setBounds(389, 167, 160, 21);
        add(cbElegirCursadaDictProfesor);
        
        cursadasDictProfesor = DatabaseImpl.getCursadasDictPorProfesor(profesor.legajo_docente);
        for(Cursada cursada : cursadasDictProfesor){
            cbElegirCursadaDictProfesor.addItem(cursada.nombreMateria+" - código: "+cursada.codigoMateria);
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

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
