package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import panels.CanvasDCL;
import panels.ToolbarDCL;
import objetos.Fuerza;
import objetos.Punto;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Plano2D Es el JFrame encargado de comunicarse entre el usuario y multiples clases que se encargan de renderizar el Plano
 * Cartesiano, esta clase incluye una instancia de JPanel CanvasDCL
 * 
 * @author Bayron Jonathan Vazquez
 * @see CanvasDCL
 */

public class Plano2D extends JFrame {

	private final String TITLE = "Plano Cartesiano";
	private final String LINKEDIN = "https://www.linkedin.com/in/bayron-jonathan-vazquez/";
	private final String YOUTUBE  = "https://www.youtube.com/channel/UC0c6M9vcV3jPbYEK2UHJk6w";
	private JPanel contentPane;
	private boolean TOOLBAR_VISIBLE = true;
	
	public int WIDTH  = 800;
	public int HEIGHT = 800;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Plano2D frame = new Plano2D();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Plano2D() {
		setTitle(TITLE);
		setSize(WIDTH, HEIGHT);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setMinimumSize(new Dimension( 800, 800) );
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground( Color.WHITE );
		setContentPane(contentPane);
		
		CanvasDCL plano = new CanvasDCL( );
		plano.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				System.out.println( e.getPoint().x );
			}
		});
		plano.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println( "move" );
			}
		});
		ToolbarDCL toolbar = new ToolbarDCL();
		
		//plano.addVector( new Punto(0,0), new Punto(2.5, 2.5) );
		//plano.addVector( new Punto(0,0), new Punto(0, 3.5) );
		//plano.addVector( new Fuerza(90, 2.5) );
		contentPane.add( plano, BorderLayout.CENTER );
		
		toolbar.setPreferredSize(new Dimension(200,500) );
		contentPane.add( toolbar, BorderLayout.EAST );
		
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem itemToolbar = new JMenuItem("Toolbar");
		itemToolbar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( TOOLBAR_VISIBLE ) {
					toolbar.setVisible(false);
					TOOLBAR_VISIBLE = false;
				}
				else {
					toolbar.setVisible(true);
					TOOLBAR_VISIBLE = true;
				}
			}
		});
		mnView.add(itemToolbar);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem itemAboutUs = new JMenuItem("About Us");
		itemAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					java.awt.Desktop.getDesktop().browse( java.net.URI.create(LINKEDIN));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnHelp.add(itemAboutUs);
		
		JMenuItem itemTutorials = new JMenuItem("Tutorials");
		itemTutorials.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					java.awt.Desktop.getDesktop().browse( java.net.URI.create(YOUTUBE));
				} catch (IOException error) {
				    error.printStackTrace();
				}
			}
		});
		mnHelp.add(itemTutorials);
		
		JMenuItem itemVersion = new JMenuItem("Version");
		itemVersion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Mensaje", "Version", JOptionPane.PLAIN_MESSAGE);
			}
		});
		mnHelp.add(itemVersion);
		
		setVisible(true);
	}	
}
