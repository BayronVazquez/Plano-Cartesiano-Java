package objetos;

import formulas.Fisica;
import formulas.Geometria;

/**
 * La clase Fuerza representa a un Vector un un Plano Cartesiano o Diagrama de Cuerpo Libre (DCL). El objetivo de esta Clase es
 * representar las partes de dicha fuerza y calcular el resto de manera sencilla e intuitiva.
 * 
 * @author Bayron Jonathan Vazquez
 */

public class Fuerza {
	private double grados;			// Direccion: En Gardos
	private double radianes;		// Direccion: En Radianes
	private double magnitud;		// Fuerza del Vector, Resultante, Hipotenusa
	
	private Punto PuntoOrigen;		// Punto de Origen del Vector
	private Punto PuntoFinal;		// Punto Final del Vector
	
	public Fuerza() {
		this.PuntoOrigen = null;
		this.PuntoFinal  = null;
	}
	
	public Fuerza( double grados, double magnitud ) {
		this.radianes = Math.toRadians(grados);
		this.magnitud = magnitud;
		this.grados = grados;
		this.PuntoOrigen = new Punto(0,0);
		this.PuntoFinal = new Punto( getFx(), getFy() );
	}
	
	public Fuerza( Punto A, Punto B ) {
		this.PuntoOrigen = A;
		this.PuntoFinal  = B;
		this.magnitud = Geometria.hipotenusa( A, B );
		System.out.println("magnitud: " + magnitud);
	}
	
	public void setPuntoOrigen( Punto Origen) {
		this.PuntoOrigen = Origen;
	}

	public void setPuntoFinal( Punto Final) {
		this.PuntoOrigen = Final;
	}
	
	public Punto getPuntoOrigen( ) {
		return this.PuntoOrigen;
	}

	public Punto getPuntoFinal( ) {
		return this.PuntoFinal;
	}
	
	public void setAnguloEnGrados( double grados ) {
		this.grados   = grados;
		this.radianes = Math.toRadians(grados);
	}
	
	public void setAnguloEnRad( double radianes ) {
		this.radianes = radianes;
		this.grados   = Math.toDegrees(radianes); 
	}	
	
	public double getAnguloEnGrados() {
		return grados;
	}
	
	public double getAnguloEnRad() {
		return radianes;
	}
	
	public void setMagnitud( double r ) {
		this.magnitud = r;
	}
	
	public double getMagnitud( ) {
		return this.magnitud;
	}
	
	public double getFx() {
		return Fisica.ComponenteFx_Radianes(magnitud, radianes);
	}
	
	public double getFy() {
		return Fisica.ComponenteFy_Radianes(magnitud, radianes);
	}
}
