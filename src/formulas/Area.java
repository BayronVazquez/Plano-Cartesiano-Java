package formulas;

public class Area {
	
	public static double circuloConRadio( double radio ) {
		return Math.PI * Math.pow(radio, 2);
	}
	
	public static double circuloConDiametro( double diametro ) {
		return (Math.PI * Math.pow(diametro, 2))/4;
	}
	
	public static double triangulo(double base, double altura) {
		return (base * altura )/ 2;
	}
	
	public static double rectangulo( double base, double altura) {
		return base * altura;
	}
}
