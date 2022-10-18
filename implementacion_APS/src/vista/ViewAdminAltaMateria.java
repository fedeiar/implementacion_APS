package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import controlador.ControllerAdminAltaMateria;
import modelo.Materia;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAdminAltaMateria extends JPanel{

	private MainWindow mainWindow;
    private ControllerAdminAltaMateria controllerAdminAltaMateria;

	private JTextField TFNombre;
    private JButton btnRegistrar, btnCancelar;
    private JLabel lblAltaMateria, lblNombre;
    
	
	public ViewAdminAltaMateria(MainWindow mainWindow, ControllerAdminAltaMateria controllerAdminAltaMateria) {
        this.mainWindow = mainWindow;
        this.controllerAdminAltaMateria = controllerAdminAltaMateria;
        this.setBounds(100, 100, 1000, 600);
        setLayout(null);
                
        inicializarComponentes();
        inicializarListeners();
	}
	
	private void inicializarComponentes(){
        lblAltaMateria = new JLabel("Alta de Materia");
        lblAltaMateria.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblAltaMateria.setHorizontalAlignment(SwingConstants.CENTER);
        lblAltaMateria.setBounds(358, 31, 210, 29);
        add(lblAltaMateria);

		TFNombre = new JTextField();
        TFNombre.setBounds(389, 133, 160, 20);
        add(TFNombre);
        TFNombre.setColumns(10);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(295, 133, 70, 17);
        add(lblNombre);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(61, 500, 89, 23);
        add(btnCancelar);
        
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(811, 500, 106, 23);
        add(btnRegistrar);
	}

    private void inicializarListeners(){

        btnRegistrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                String nombre = TFNombre.getText();
                Materia materia = new Materia(nombre);

                controllerAdminAltaMateria.darDeAltaMateria(materia);
            }
        });

        btnCancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                controllerAdminAltaMateria.regresarMenuPrincipalAdmin();
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
