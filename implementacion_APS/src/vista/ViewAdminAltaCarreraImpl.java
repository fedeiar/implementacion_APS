package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import controlador.ControllerAdminAltaCarrera;
import modelo.Carrera;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAdminAltaCarreraImpl extends JPanel implements ViewAdminAltaCarrera {

	private MainWindow mainWindow;
    private ControllerAdminAltaCarrera controllerAdminAltaCarrera;

	private JTextField TFNombre, TFCodigo;
    private JButton btnRegistrar, btnCancelar;
    private JLabel lblNombre, lblCodigo, lblAltaCarrera;
    
	
	public ViewAdminAltaCarreraImpl(MainWindow mainWindow, ControllerAdminAltaCarrera controllerAdminAltaCarrera) {
        this.mainWindow = mainWindow;
        this.controllerAdminAltaCarrera = controllerAdminAltaCarrera;
        this.setBounds(100, 100, 1000, 600);
        setLayout(null);
                
        inicializarComponentes();
        inicializarListeners();
	}
	
	private void inicializarComponentes(){
        lblAltaCarrera = new JLabel("Alta de Carrera");
        lblAltaCarrera.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblAltaCarrera.setHorizontalAlignment(SwingConstants.CENTER);
        lblAltaCarrera.setBounds(358, 31, 210, 29);
        add(lblAltaCarrera);

		TFNombre = new JTextField();
        TFNombre.setBounds(389, 133, 160, 20);
        add(TFNombre);
        TFNombre.setColumns(10);
        
        TFCodigo = new JTextField();
        TFCodigo.setColumns(10);
        TFCodigo.setBounds(389, 167, 160, 20);
        add(TFCodigo);

        lblNombre = new JLabel("Nombre de la carrera:");
        lblNombre.setBounds(260, 136, 200, 17);
        add(lblNombre);
        
        lblCodigo = new JLabel("Código de la carrera:");
        lblCodigo.setBounds(260, 169, 200, 17);
        add(lblCodigo);
        
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
                if(!utils.Utilities.isFieldInteger(TFCodigo.getText())){ 
                    operacionFallida("Error: codigo", "El codigo debe ser un numero entero");
                    return;
                }
                int codigo = Integer.parseInt(TFCodigo.getText());

                Carrera carrera = new Carrera(nombre, codigo);
                controllerAdminAltaCarrera.darDeAltaCarrera(carrera);
            }
        });

        btnCancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                controllerAdminAltaCarrera.regresarMenuPrincipalAdmin();
            }
        });
    }

    public void mostrarse(){
        mainWindow.setContentPane(this);
        mainWindow.revalidate();
    }

    public  void operacionExitosa(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null,mensaje,titulo,JOptionPane.INFORMATION_MESSAGE);
    }

    public  void operacionFallida(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }
}
