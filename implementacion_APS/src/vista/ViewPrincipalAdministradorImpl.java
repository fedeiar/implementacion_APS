package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import java.awt.Container;

public class ViewPrincipalAdministradorImpl extends JPanel implements ViewPrincipalAdministrador{

    private MainWindow mainWindow;

    private JLabel lblBienvenido;

	public ViewPrincipalAdministradorImpl(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.setBounds(100, 100, 1000, 600);
        setLayout(null);
        
        inicializarComponentes();
	}

    private void inicializarComponentes(){
        lblBienvenido = new JLabel("Bienvenido Administrador.");
        lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
        lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblBienvenido.setBounds(365, 36, 255, 60);
        add(lblBienvenido);
    }

    public Container getContent(){
        return this;
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
