package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controlador.ControllerAdminModificarPlan;
import modelo.DatabaseImpl;
import modelo.Materia;
import modelo.Plan;

public class ViewAdminModificarPlan extends JPanel {

	private MainWindow mainWindow;
    private ControllerAdminModificarPlan controllerAdminAgregarMatAPlan;

    private JButton btnCancelar, btnCrearYAgregarMateria;
    private JLabel lblAgregarMatAPlan, lblElegirPlanCarrera, lblElegirMateria;
    private JComboBox<String> cbElegirPlan;
    private JComboBox<String> cbElegirMateria;

    private List<Plan> planes;
    private List<Materia> materias;
    
	
	public ViewAdminModificarPlan(MainWindow mainWindow, ControllerAdminModificarPlan controllerAdminAgregarMatAPlan) {
        this.mainWindow = mainWindow;
        this.controllerAdminAgregarMatAPlan = controllerAdminAgregarMatAPlan;
        this.setBounds(100, 100, 1000, 600);
        setLayout(null);
                
        inicializarComponentes();
        inicializarListeners();
	}
	
	private void inicializarComponentes(){
        lblAgregarMatAPlan = new JLabel("Modificar plan");
        lblAgregarMatAPlan.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblAgregarMatAPlan.setHorizontalAlignment(SwingConstants.CENTER);
        lblAgregarMatAPlan.setBounds(358, 31, 210, 29);
        add(lblAgregarMatAPlan);

        lblElegirPlanCarrera = new JLabel("Elija un plan de la carrera:");
        lblElegirPlanCarrera.setBounds(230, 139, 200, 17);
        add(lblElegirPlanCarrera);

        armarComboBoxPlanes();

        lblElegirMateria = new JLabel("Elija una materia:");
        lblElegirMateria.setBounds(230, 119, 200, 17);
        add(lblElegirMateria);

        armarComboBoxMaterias();
        
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

    private void armarComboBoxPlanes(){
        cbElegirPlan = new JComboBox<String>();
        cbElegirPlan.setBounds(389, 137, 200, 21);
        add(cbElegirPlan);
        try{
            planes = DatabaseImpl.getPlanesDeCarreras();
            for(Plan plan : planes){
                cbElegirPlan.addItem("codigo carrera: " + plan.codCarrera +" - año:"+ plan.anio);
            }
        } catch(Exception e){
            this.operacionFallida("Error", e.getMessage());
        }
    }

    private void armarComboBoxMaterias(){
        cbElegirMateria = new JComboBox<String>();
        cbElegirMateria.setBounds(389, 119, 200, 21);
        add(cbElegirMateria);
        try{
            materias = DatabaseImpl.getMaterias();
            for(Materia materia : materias){
                cbElegirMateria.addItem(" - nombre: "+ materia.nombre + "codigo : " + materia.codigo);
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
