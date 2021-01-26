package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu_Help_Tutorials extends JFrame {

	private JPanel contentPane;
	private int WIDTH  = 800;
	private int HEIGHT = 500;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Help_Tutorials frame = new Menu_Help_Tutorials();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu_Help_Tutorials() {
		
		setResizable(false);
		setTitle("Tutorials");
		setSize(WIDTH,HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
	}

}
