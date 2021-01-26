package formulas;

import objetos.Fuerza;
import objetos.Punto;

public class Fisica {

	public static double magnitud( Punto A, Punto B) {
		double x = B.x - A.x;
		double y = B.y - A.y;
		double xCuadrada = Math.pow(x, 2);
		double yCuadrada = Math.pow(y, 2);
		return Math.sqrt( xCuadrada + yCuadrada );
	}
	
	public static double direccionEnGrados( Punto A, Punto B ) {
		double alfa;
		double x = B.x - A.x;
		double y = B.y - A.y;
		alfa = Math.atan( y/x );
		return Math.toDegrees(alfa);
	}
	
	public static double direccionEnRadianes( Punto A, Punto B ) {
		double x = B.x - A.x;
		double y = B.y - A.y;
		return Math.atan( y/x );
	}
	
	public static double ComponenteFx_Radianes( double magnitud, double radianes ) {
		return magnitud * Math.cos( radianes );
	}
	
	public static double ComponenteFy_Radianes( double magnitud, double radianes ) {
		return magnitud * Math.sin( radianes ); 
	}
	
	public static double ComponenteFx_Grados( double magnitud, double grados) {
		double radianes = Math.toRadians(grados);
		return magnitud * Math.cos( radianes );  
	}
	
	public static double ComponenteFy_Grados( double magnitud, double grados ) {
		double radianes = Math.toRadians(grados);
		return magnitud * Math.sin( radianes ); 
	}
	
	public static double ComponenteFx_Catetos(double magnitud, double catetoOpuesto, double catetoAdyacente ) {
		double hipotenusa = Geometria.hipotenusa(catetoAdyacente, catetoOpuesto);
		return magnitud * ( catetoAdyacente / hipotenusa );
	}
	
	public static double ComponenteFy_Catetos(double magnitud, double catetoOpuesto, double catetoAdyacente ) {
		double hipotenusa = Geometria.hipotenusa(catetoAdyacente, catetoOpuesto);
		return magnitud * ( catetoOpuesto / hipotenusa );
	}
	
	public static double SumaDeFuerzasCoplanares( Fuerza[] fuerza ) {
		return 0;
	}
	
	public static double SumaDeFuerzasCoplanares( double[] fuerza, double[] grados ) {
		double SigmaX = 0;		// Suma de Fuerzas en X
		double SigmaY = 0;		// Suma de Fuerzas en Y
		for(int i = 0; i< fuerza.length; i++) {
			SigmaX += ComponenteFx_Grados( fuerza[i], grados[i] );
			SigmaY += ComponenteFy_Grados( fuerza[i], grados[i] );
		}
		double hipotenusa = Geometria.hipotenusa( SigmaX, SigmaY );
		return hipotenusa;
	}
}