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
    private ControllerAdminModificarPlan controllerAdminModificarPlan;

    private JButton btnCancelar, btnAgregarMateria, btnEliminarMateria;
    private JLabel lblAgregarMatAPlan, lblElegirPlanCarrera, lblElegirMateria;
    private JComboBox<String> cbElegirPlan;
    private JComboBox<String> cbElegirMateria;

    private List<Plan> planes;
    private List<Materia> materias;
    
	
	public ViewAdminModificarPlan(MainWindow mainWindow, ControllerAdminModificarPlan controllerAdminAgregarMatAPlan) {
        this.mainWindow = mainWindow;
        this.controllerAdminModificarPlan = controllerAdminAgregarMatAPlan;
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
        lblElegirMateria.setBounds(230, 169, 200, 17);
        add(lblElegirMateria);

        armarComboBoxMaterias();
        
        btnAgregarMateria = new JButton("Agregar materia seleccionada");
        btnAgregarMateria.setBounds(250, 350, 220, 23);
        add(btnAgregarMateria);

        btnEliminarMateria = new JButton("Quitar materia seleccionada");
        btnEliminarMateria.setBounds(500, 350, 220, 23);
        add(btnEliminarMateria);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(61, 500, 89, 23);
        add(btnCancelar);
	}

    private void inicializarListeners(){

        btnAgregarMateria.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent) {
                Plan plan = planes.get(cbElegirPlan.getSelectedIndex());
                Materia materia = materias.get(cbElegirMateria.getSelectedIndex());

                controllerAdminModificarPlan.agregarMateriaAPlan(plan, materia);
            }
        });

        btnEliminarMateria.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent) {
                Plan plan = planes.get(cbElegirPlan.getSelectedIndex());
                Materia materia = materias.get(cbElegirMateria.getSelectedIndex());

                controllerAdminModificarPlan.eliminarMateriaDePlan(plan, materia);
            }
        });

        btnCancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                controllerAdminModificarPlan.regresarMenuPrincipalAdmin();
            }
        });
    }

    private void armarComboBoxPlanes(){
        cbElegirPlan = new JComboBox<String>();
        cbElegirPlan.setBounds(389, 137, 300, 21);
        add(cbElegirPlan);
        try{
            planes = DatabaseImpl.getPlanesDeCarreras();
            for(Plan plan : planes){
                cbElegirPlan.addItem("codigo carrera: " + plan.codCarrera +" - año plan: "+ plan.anio);
            }
        } catch(Exception e){
            this.operacionFallida("Error", e.getMessage());
        }
    }

    private void armarComboBoxMaterias(){
        cbElegirMateria = new JComboBox<String>();
        cbElegirMateria.setBounds(389, 167, 300, 21);
        add(cbElegirMateria);
        try{
            materias = DatabaseImpl.getMaterias();
            for(Materia materia : materias){
                cbElegirMateria.addItem("Nombre: "+ materia.nombre + " - codigo : " + materia.codigo);
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
