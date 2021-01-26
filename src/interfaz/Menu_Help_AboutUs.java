package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class Menu_Help_AboutUs extends JFrame {

	private JPanel contentPane;
	private final int WIDTH  = 800;
	private final int HEIGHT = 500;
	private final int PADDING = 10;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Help_AboutUs frame = new Menu_Help_AboutUs();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu_Help_AboutUs() {
		
		setResizable(false);
		setTitle("About Us");
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JPanel foto = new JPanel() {
			@Override
			public void paintComponent( Graphics g) {
				super.paintComponent(g);
				setBackground(Color.RED);
			}
		};
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, foto, PADDING, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST,  foto, PADDING, SpringLayout.WEST,  contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, foto, 125, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST,  foto, 117, SpringLayout.WEST, contentPane);
		contentPane.add(foto);
		
		JLabel JLabel_Nombre = new JLabel("Bayron Jonathan Vazquez");
		sl_contentPane.putConstraint(SpringLayout.NORTH, JLabel_Nombre, PADDING, SpringLayout.NORTH, foto);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JLabel_Nombre, 50, SpringLayout.NORTH, foto);
		sl_contentPane.putConstraint(SpringLayout.WEST,  JLabel_Nombre, PADDING, SpringLayout.EAST, foto);
		sl_contentPane.putConstraint(SpringLayout.EAST,  JLabel_Nombre, -PADDING, SpringLayout.EAST, contentPane);
		JLabel_Nombre.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_Nombre.setFont(new Font("Arial", Font.PLAIN, 20));
		contentPane.add(JLabel_Nombre);
		
		JLabel JLabel_Titulo = new JLabel("Ing. Sistemas Computacionales");
		sl_contentPane.putConstraint(SpringLayout.NORTH, JLabel_Titulo, 10, SpringLayout.SOUTH, JLabel_Nombre);
		sl_contentPane.putConstraint(SpringLayout.WEST,  JLabel_Titulo, 0,  SpringLayout.WEST,  JLabel_Nombre);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JLabel_Titulo, 30, SpringLayout.SOUTH, JLabel_Nombre);
		sl_contentPane.putConstraint(SpringLayout.EAST,  JLabel_Titulo, 0,  SpringLayout.EAST, JLabel_Nombre);
		JLabel_Titulo.setFont(new Font("Arial", Font.PLAIN, 14));
		JLabel_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(JLabel_Titulo);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textArea,  PADDING, SpringLayout.SOUTH, foto);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textArea, -PADDING, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST,  textArea,  PADDING, SpringLayout.WEST,  contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST,  textArea, -PADDING, SpringLayout.EAST,  contentPane);
		contentPane.add(textArea);
		setVisible(true);
	}
}
