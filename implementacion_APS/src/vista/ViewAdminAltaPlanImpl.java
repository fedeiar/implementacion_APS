package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.ControllerAdminAltaPlan;
import modelo.Plan;

public class ViewAdminAltaPlanImpl extends JPanel implements ViewAdminAltaPlan {

	private MainWindow mainWindow;
    private ControllerAdminAltaPlan controllerAdminAltaPlan;

	private JTextField TFAnio;
	private JTextField TFCodCarrera;
    private JButton btnRegistrar, btnCancelar;
    private JLabel lblAltaPlan, lblCodCarrera, lblAnio;
    
	
	public ViewAdminAltaPlanImpl(MainWindow mainWindow, ControllerAdminAltaPlan controllerAdminAltaPlan) {
        this.mainWindow = mainWindow;
        this.controllerAdminAltaPlan = controllerAdminAltaPlan;
        this.setBounds(100, 100, 1000, 600);
        setLayout(null);
                
        inicializarComponentes();
        inicializarListeners();
	}
	
	private void inicializarComponentes(){
        lblAltaPlan = new JLabel("Alta de Plan");
        lblAltaPlan.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblAltaPlan.setHorizontalAlignment(SwingConstants.CENTER);
        lblAltaPlan.setBounds(358, 31, 210, 29);
        add(lblAltaPlan);

		TFAnio = new JTextField();
        TFAnio.setColumns(10);
        TFAnio.setBounds(389, 133, 160, 20);
        add(TFAnio);
        
        TFCodCarrera = new JTextField();
        TFCodCarrera.setColumns(10);
        TFCodCarrera.setBounds(389, 167, 160, 20);
        add(TFCodCarrera);

        lblAnio = new JLabel("Año del plan:");
        lblAnio.setBounds(295, 136, 56, 17);
        add(lblAnio);
        
        lblCodCarrera = new JLabel("Código de Carrera");
        lblCodCarrera.setBounds(295, 169, 56, 17);
        add(lblCodCarrera);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(61, 500, 89, 23);
        add(btnCancelar);
        
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(811, 500, 106, 23);
        add(btnRegistrar);
	}

    private void inicializarListeners(){

        btnRegistrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent) {
                if(!utils.Utilities.isFieldInteger(TFAnio.getText())){ //TODO: en realidad habría que obtener el legajo mas alto de la DB, sumarle 1 y colocarlo pero paja, si alguno lo quiere hacer joya.
                    operacionFallida("Error: año", "El año debe ser un numero entero");
                    return;
                }
                int anio = Integer.parseInt(TFAnio.getText());
                if(!utils.Utilities.isFieldInteger(TFCodCarrera.getText())){ //TODO: en realidad habría que obtener el legajo mas alto de la DB, sumarle 1 y colocarlo pero paja, si alguno lo quiere hacer joya.
                    operacionFallida("Error: código de carrera", "El código de la carrera debe ser un numero entero");
                    return;
                }
                int codCarrera = Integer.parseInt(TFCodCarrera.getText());
                Plan plan = new Plan(anio, codCarrera);

                controllerAdminAltaPlan.darDeAltaPlan(plan);
            }
        });

        btnCancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                controllerAdminAltaPlan.regresarMenuPrincipalAdmin();
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
