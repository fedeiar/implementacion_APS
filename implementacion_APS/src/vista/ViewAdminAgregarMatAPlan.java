package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controlador.ControllerAdminAgregarMatAPlan;
import modelo.DatabaseImpl;

public class ViewAdminAgregarMatAPlan extends JPanel {

	private MainWindow mainWindow;
    private ControllerAdminAgregarMatAPlan controllerAdminAgregarMatAPlan;

    private JButton btnCancelar, btnCrearYAgregarMateria;
    private JLabel lblAgregarMatAPlan, lblElegirPlanCarrera;
    private JComboBox<String> cbElegirPlan;
    
	
	public ViewAdminAgregarMatAPlan(MainWindow mainWindow, ControllerAdminAgregarMatAPlan controllerAdminAgregarMatAPlan) {
        this.mainWindow = mainWindow;
        this.controllerAdminAgregarMatAPlan = controllerAdminAgregarMatAPlan;
        this.setBounds(100, 100, 1000, 600);
        setLayout(null);
                
        inicializarComponentes();
        inicializarListeners();
	}
	
	private void inicializarComponentes(){
        lblAgregarMatAPlan = new JLabel("Agregar materia a plan");
        lblAgregarMatAPlan.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblAgregarMatAPlan.setHorizontalAlignment(SwingConstants.CENTER);
        lblAgregarMatAPlan.setBounds(358, 31, 210, 29);
        add(lblAgregarMatAPlan);

        armarComboBoxPlanesAsocACarrera();

        lblElegirPlanCarrera = new JLabel("Elija un plan de la carrera:");
        lblElegirPlanCarrera.setBounds(295, 136, 200, 17);
        add(lblElegirPlanCarrera);
        
        btnCrearYAgregarMateria = new JButton("Crear y agregar materia");
        btnCrearYAgregarMateria.setBounds(300, 500, 300, 23);
        add(btnCrearYAgregarMateria);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(61, 500, 89, 23);
        add(btnCancelar);
	}

    private void inicializarListeners(){

        btnCrearYAgregarMateria.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent) {
                String plan = cbElegirPlan.getSelectedItem().toString();
                try{
                    int i = 6; String anio_plan = "";
                    while(plan.charAt(i) != ' ') {
                        anio_plan += plan.charAt(i);
                        System.out.println(anio_plan);
                        i++;
                    }
                    i += 9;
                    String nombre_carrera = "";
                    while(i < plan.length()-1) {
                        nombre_carrera += plan.charAt(i);
                        System.out.println(nombre_carrera);
                        i++;
                    }
                } catch(Exception e){
                    operacionFallida("Error", e.getMessage());
                }

                //controllerAdminAgregarMatAPlan.agregarMateriaAPlan( );
            }
        });

        btnCancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                controllerAdminAgregarMatAPlan.regresarMenuPrincipalAdmin();
            }
        });
    }

    private void armarComboBoxPlanesAsocACarrera(){
        cbElegirPlan = new JComboBox<String>();
        cbElegirPlan.setBounds(389, 167, 160, 21);
        add(cbElegirPlan);
        try{
            for(String plan : DatabaseImpl.getPlansOfCareers()){
                cbElegirPlan.addItem(plan);
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
