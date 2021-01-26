package formulas;

import objetos.Punto;

public class Geometria {
	
	public static double hipotenusa( double catetoAdyacente, double catetoOpuesto ) {
		double aCuadrada = Math.pow( catetoAdyacente, 2);
		double bCuadrada = Math.pow( catetoOpuesto, 2);
		return Math.sqrt( aCuadrada + bCuadrada );
	}
	
	public static double hipotenusa( Punto A, Punto B) {
		double aCuadrada = Math.pow( B.x - A.x, 2);
		double bCuadrada = Math.pow( B.y - A.y, 2);
		return Math.sqrt( aCuadrada + bCuadrada );
	}
	
	public static double pendiente( Punto A, Punto B ) {
		// NOTA VERIFICAR LA DIVISION POR CERO
		return (B.y - A.y) / (B.x - A.x);
	}
	
	public static boolean esAnguloRecto(  int angulo ) {
		return ( angulo == 90) ? true : false;
	}

	public static boolean esAnguloAgudo(  int angulo ) {
		 return ( angulo > 0 && angulo < 90) ? true : false;
	}

	public static boolean esAnguloNulo(  int angulo ) {
		return ( angulo == 0 ) ? true : false;
	}

	public static boolean esAnguloObtuso(  int angulo ) {
		return ( angulo > 90 && angulo < 180) ? true : false; 
	}

	public static boolean esAnguloLlano(  int angulo ) {
		return ( angulo == 180) ? true : false;
	}

	public static boolean sonAngulosComplementarios(int a, int b){
		return (a+b == 180 ) ? true : false;
	}
}