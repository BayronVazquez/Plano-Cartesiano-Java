package panels;

import objetos.Fuerza;
import objetos.Punto;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * @author Bayron Jonathan Vazquez
 * 
 */

public class CanvasDCL extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private int WIDTH;					// Es el ancho del panel en px
	private int HEIGHT;					// Es el alto del panel en px
	private int FILAS;					// Es el numero de filas 'cuadros verticales' que habra en el lienzo
	private int COLUMNAS;				// Es el numero de columnas 'cuadros horizontales' que habra en el lienzo
	private int PADDING_X;				// Margen en los extremos horizontales
	private int PADDING_Y;				// Margen en los extremos verticales
	private int DIAMETRO = 10;			// Diametro de los Circulos que se usan para los puntos
	private int RADIO = DIAMETRO / 2;	// Radio del Circulo que se usan para los puntos 
	private double SQUARE_WIDTH = 50;	// Ancho en px de cada cuadro 
	
	private Punto Centro;				// Almacena los pixeles del punto de Origen 'el centro del plano'
	private ArrayList<Fuerza> vectores; // Todos los vectores en el plano
	
	private Graphics2D g2;
	private BasicStroke stroke1;
	private BasicStroke stroke2;
	
	//COLORES
	private Color colorMalla;
	private Color colorFondo;
	private Color colorEjes;
	private Color colorTexto;
	private Color colorVector;
	
	public CanvasDCL(){
		Centro = new Punto();
		vectores = new ArrayList<Fuerza>();
		
		colorMalla = new Color(0,0,0);				// NEGRO
		colorFondo = new Color(255,255,255);		// BLANCO
		colorEjes  = new Color(255,139,0);			// NARANJA
		colorTexto = new Color(0,0,0);				// NEGRO

		stroke1 = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		stroke2 = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
	}
	
	public void addVector( Punto A, Punto B) {
		vectores.add( new Fuerza(A,B) );
	}

	public void addVector( Fuerza f) {
		vectores.add( f );
	}

	private void drawGrid() {
		g2.setColor( colorMalla );
		g2.setStroke( stroke1 );
		for( int y=PADDING_Y; y <= getHeight(); y += SQUARE_WIDTH ) {
			for( int x=PADDING_X; x <= getWidth(); x += SQUARE_WIDTH ) {
				g2.drawLine(x, y, WIDTH + PADDING_X, y);			// LINEA HORIZONTAL 
				g2.drawLine(x, y, x, HEIGHT);						// LINEA VERTICAL
			}
		}
	}
	
	private Punto getPointPixels(Punto p) {
		Punto z = new Punto();
		
		z.x = Centro.x + (SQUARE_WIDTH * p.x) - RADIO;
		z.y = Centro.y - (SQUARE_WIDTH * p.y) - RADIO;
		return z;
	}
	
	private void drawVectors()
	{
		if( !vectores.isEmpty() )		// SI HAY VECTORES LOS DIBUJAMOS
		{
			g2.setColor(Color.BLUE);
			g2.setStroke( stroke2 );
			
			for( int i=0; i< vectores.size(); i++ )
			{
				Fuerza segmento = vectores.get(i);
				Punto a = getPointPixels( segmento.getPuntoOrigen() );
				g2.fillOval( (int)a.x , (int)a.y, DIAMETRO, DIAMETRO);
				
				Punto b = getPointPixels( segmento.getPuntoFinal() );
				g2.fillOval( (int)b.x , (int)b.y, DIAMETRO, DIAMETRO);
				
				// LINEA DEL VECTOR, SEGMENTO, ETC
				g2.drawLine((int)a.x + RADIO, (int)a.y + RADIO,
							(int)b.x + RADIO, (int)b.y + RADIO);
			}
		}
	}
	
	private void drawAxis() {		
		g2.setColor( colorEjes );
        g2.setStroke( stroke2 );
		g2.drawLine( PADDING_X, (int)Centro.y, WIDTH + PADDING_X, (int)Centro.y);	// LINEA HORIZONTAL 
		g2.drawLine( (int)Centro.x, PADDING_Y, (int)Centro.x, HEIGHT + PADDING_Y);	// LINEA VERTICAL
	}
	
	private void drawArrows() {
		int[] x = new int[3];		int[] y = new int[3];
		//FLECHA DE LA DERECHA
		// Punto 1					Punto 2							Punto 3
		x[0] = WIDTH + PADDING_X;	x[1] = WIDTH + PADDING_X - 20;	x[2] = WIDTH + PADDING_X - 20;
		y[0] = (int)Centro.y;		y[1] = (int)Centro.y - 20;		y[2] = (int)Centro.y + 20;
		g2.fillPolygon(x, y, 3);
		
		//FLECHA DE LA IZQUIERDA
		// Punto 1					Punto 2							Punto 3
		x[0] = PADDING_X;			x[1] = PADDING_X + 20;			x[2] = PADDING_X + 20;
		g2.fillPolygon(x, y, 3);
		
		//FLECHA DE LA ARRIBA
		// Punto 1					Punto 2							Punto 3
		x[0] = (int)Centro.x;		x[1] = (int)Centro.x - 20;		x[2] = (int)Centro.x + 20;
		y[0] = PADDING_Y; 			y[1] = PADDING_Y + 20;	 		y[2]= PADDING_Y + 20;
		g2.fillPolygon(x, y, 3);
		
		//FLECHA DE LA ABAJO
		// Punto 1					Punto 2							Punto 3
		x[0] = (int)Centro.x;		x[1] = (int)Centro.x - 20;		x[2] = (int)Centro.x + 20;
		y[0] = HEIGHT + PADDING_Y;	y[1] = HEIGHT - 20 + PADDING_Y;	y[2]= HEIGHT - 20 + PADDING_Y;
		g2.fillPolygon(x, y, 3);
	}
	
	private void drawNumbers() {
		int MitadHorizontal = (int)Centro.x;
		int MitadVertical   = (int)Centro.y;
		int numero, i;
		g2.setColor( colorTexto );
		
		// X+
		numero = 0;
		for( i = MitadHorizontal; i < WIDTH - SQUARE_WIDTH; i += SQUARE_WIDTH) {
			g2.drawString( String.valueOf(numero), i+5, MitadVertical-5);
			numero++;
		}
		// X-
		numero = -1;
		for( i = MitadHorizontal - (int)SQUARE_WIDTH; i > SQUARE_WIDTH; i -= SQUARE_WIDTH) {
			g2.drawString( String.valueOf(numero), i+5, MitadVertical-5);
			numero--;
		}
		// Y+
		numero = 1;
		for( i = MitadVertical - (int)SQUARE_WIDTH; i > SQUARE_WIDTH; i -= SQUARE_WIDTH) {
			g2.drawString( String.valueOf(numero), MitadHorizontal + 5, i);
			numero++;
		}
		// Y-
		numero = -1;
		for( i = MitadVertical + (int)SQUARE_WIDTH; i < HEIGHT; i += SQUARE_WIDTH) {
			g2.drawString( String.valueOf(numero), MitadHorizontal + 5, i);
			numero--;
		}
	}
	
	private void calcularCentro() {
		Centro.x = ( (WIDTH  / 2) + PADDING_X);
		Centro.y = ( (HEIGHT / 2) + PADDING_Y);
	}
	
	@Override
	public void paintComponent( Graphics g ) {
		super.paintComponent(g);
		g2 = (Graphics2D) g.create();
		setBackground( colorFondo );
		
		// CALCULAMOS EL NUMERO DE FILAS Y COLUMNAS QUE CABEN EN LA PANTALLA
		FILAS    = getHeight() / (int)SQUARE_WIDTH;
		COLUMNAS = getWidth()  / (int)SQUARE_WIDTH;
		
		if(  FILAS   % 2 != 0)			//VALIDAMOS QUE SEA UN NUMERO PAR
			FILAS--;
		
		if( COLUMNAS % 2 != 0)			//VALIDAMOS QUE SEA UN NUMERO PAR
			COLUMNAS--; 
		
		// CALCULAMOS EL ALTO Y ANCHO PARA UN NUMERO EXACTO DE CUADROS
		WIDTH  = (int)SQUARE_WIDTH * COLUMNAS;
		HEIGHT = (int)SQUARE_WIDTH * FILAS;
		
		//CALCULAMOS EL ESPACIO QUE SOBRA EN LAS ORILLAS 'PADDING' PARA CENTRAR LOS GRAFICOS
		PADDING_X = (getWidth()  - WIDTH)  / 2;
		PADDING_Y = (getHeight() - HEIGHT) / 2;
		
		// CALCULAMOS EL PUNTO DEL CENTRO
		calcularCentro();
		
		//punto de origen
		//g.drawOval((int)(Centro.x), (int)(Centro.y), 5, 5);
	
		drawGrid();				// Dibuja la Cuadricula
		drawNumbers();			// Dibuja los numero de las rectas
		drawAxis();				// Dibuja los Ejes de X y Y
		drawArrows();			// Dibuja las Flechas de los Ejes
		drawVectors();			// Dibuja los Vectores
		g2.dispose();
	}
}