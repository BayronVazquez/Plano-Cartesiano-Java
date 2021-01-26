package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu_Configuration_Colors extends JFrame {

	private JPanel contentPane;
	
	private int WIDTH  = 800;
	private int HEIGHT = 500;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Configuration_Colors frame = new Menu_Configuration_Colors();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu_Configuration_Colors() {
		setResizable(false);
		setSize(WIDTH,HEIGHT);
		setTitle("Configuracion De Colores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
	}
}
