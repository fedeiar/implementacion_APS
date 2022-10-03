package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;


public class ViewPrincipalAlumnoImpl extends JPanel implements ViewPrincipalAlumno{
    

    private MainWindow mainWindow;



    public ViewPrincipalAlumnoImpl(MainWindow mainWindow){
        this.mainWindow = mainWindow;

        this.setBounds(100, 100, 1000, 600);
        setLayout(null);
        
        inicializarComponentes();
        inicializarListeners();
    }

    private void inicializarComponentes(){

    }

    private void inicializarListeners(){
        
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
