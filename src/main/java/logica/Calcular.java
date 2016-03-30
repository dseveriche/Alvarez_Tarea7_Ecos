package logica;

import java.util.*;
/**
* Nombre: Daniel m Alvarez                                                                       
* Fecha :  27/03/2016       
* Descripción: este programa genera una tabla de tamaños relativos para una lsiat de valores pregarcados       
*/


/**
 * Clase que genera los calculos para estimar el tamaño de una lista de valores
 * @author Daniel m Alvarez 
 *
 */


public class Calcular {
	/**
	 * Metodo Xi
	 * @param recive un dato tipo double y un dato i double
	 * @return retorna un arrayList
	 */
	public ArrayList<Double> Xi( double dato, double i){
		ArrayList<Double> resultado = new ArrayList<Double>();
		resultado.add(0.0);
		
		for( int x = 1; x <= i; x++)
			resultado.add( resultado.get(x - 1)  + ( dato / i));
		
		return resultado;
	}
	
	/**
	 * Metodo UnoMasX2SobreDof
	 * @param recive un dato tipo double y un dato i double y un dato dof tipo double
	 * @return retorna un arrayList
	 */
	public ArrayList<Double> UnoMasX2SobreDof( double dato, double i, double dof){
		
		ArrayList<Double> valorXi = Xi( dato, i);
				
		ArrayList<Double> resultado = new ArrayList<Double>();
		for( double x: valorXi)
			resultado.add( 1 + ((x * x) / dof));
		
		return resultado;
	}
	/**
	 * Metodo NegativoDofMasUnoSobreDos
	 * @param recive  un dato i double y un dato dof tipo double
	 * @return retorna un double 
	 */
	public double NegativoDofMasUnoSobreDos( double dof, double i){
		
		return ( -1 * (( dof + 1) / 2));
	}
	/**
	 * Metodo ListaPotenciacion
	 * @param recive un dato tipo double y un dato i double y un dato dof tipo double
	 * @return retorna un arraylist
	 */
	public ArrayList<Double> ListaPotenciacion( double dato, double i, double dof){
		
		ArrayList<Double> valorUnoMasX2SobreDof = UnoMasX2SobreDof( dato, i, dof);
		double potencia = NegativoDofMasUnoSobreDos( dof, i);
		
		ArrayList<Double> resultado = new ArrayList<Double>();
		
		for( double x: valorUnoMasX2SobreDof)
			resultado.add( Math.pow(x, potencia));
		
		return resultado;
	}
	
	/**
	 * Metodo LogGamma
	 * @param recive un dato X tipo double 
	 * @return retorna un double 
	 */
	public double LogGamma( double x){
	      double tmp = (x - 0.5) * Math.log(x + 4.5) - (x + 4.5);
	      double ser = 1.0 + 76.18009173 / (x + 0) - 86.50532033 / (x + 1) + 24.01409822 / (x + 2) - 1.231739516 / (x + 3) + 0.00120858003 / (x + 4) - 0.00000536382 / (x + 5);
	      return tmp + Math.log(ser * Math.sqrt(2 * Math.PI));
	}
	/**
	 * Metodo Gamma
	 * @param recive un dato X tipo double 
	 * @return retorna un double 
	 */
	public double Gamma( double x){
		return Math.exp(LogGamma(x));
	}
	/**
	 * Metodo  GammaDofMasUnoSobreDos
	 * @param recive un dato dof tipo double 
	 * @return retorna un double 
	 */
	public double GammaDofMasUnoSobreDos( double dof){
		
		return Gamma((( dof + 1) / 2));
	}
	/**
	 * Metodo  DofPorPiElevadoUnoymedio
	 * @param recive un dato dof tipo double 
	 * @return retorna un double 
	 */
	public double DofPorPiElevadoUnoymedio( double dof){
		return Math.pow((dof * Math.PI), 0.5);
	}
	/**
	 * Metodo  GammaDofSobreDos
	 * @param recive un dato dof tipo double 
	 * @return retorna un double 
	 */
	public double GammaDofSobreDos( double dof){
		double mitadDof = dof / 2;
		return Gamma( mitadDof);
	}
	/**
	 * Metodo  GammaDofSobreDosSobreDofPorPiElevadoUnoymedioPorGammaDofSobreDos
	 * @param recive un dato dof tipo double 
	 * @return retorna un double 
	 */
	public double GammaDofSobreDosSobreDofPorPiElevadoUnoymedioPorGammaDofSobreDos( double dof){
		return GammaDofMasUnoSobreDos(dof) / ((DofPorPiElevadoUnoymedio(dof) * GammaDofSobreDos( dof)));
	}
	/**
	 * Metodo  FXi
	 * @param recive un dato tipo double y un dato i double y un dato dof tipo double
	 * @return retorna un arraylist 
	 */
	public ArrayList<Double> FXi( double dato, double i, double dof){
		
		ArrayList<Double> valorListaPotenciacion = ListaPotenciacion( dato, i, dof);
		double valorGammaDofSobreDosSobreDofPorPiElevadoUnoymedioPorGammaDofSobreDos = GammaDofSobreDosSobreDofPorPiElevadoUnoymedioPorGammaDofSobreDos( dof);
		
		ArrayList<Double> resultado = new ArrayList<Double>();
		for( double x: valorListaPotenciacion)
				resultado.add( x * valorGammaDofSobreDosSobreDofPorPiElevadoUnoymedioPorGammaDofSobreDos);			
				
		return resultado;
	}
	/**
	 * Metodo  w
	 * @param recive un dato tipo double y un dato i double 
	 * @return retorna un arraylist 
	 */
	public double w(double dato, double i){
		ArrayList<Double> valorXi = Xi( dato, i);
		return valorXi.get(valorXi.size() - 1) / ( valorXi.size() - 1);
	}
	/**
	 * Metodo  Terms
	 * @param recive un dato tipo double y un dato i double y un dato dof tipo double una dato doble multiplier
	 * @return retorna un double
	 */
	public ArrayList<Double> Terms( double dato, double i, double dof, double[] multiplier){
		double valorW = w( dato, i);
		ArrayList<Double> valorFxi = FXi( dato, i, dof);
		
		ArrayList<Double> resultado = new ArrayList<Double>();
			
		int selectMultiplier = 0;	
		for( int x = 0; x < valorFxi.size(); x++)
			resultado.add( (w( dato, i) / 3) * multiplier[x] * valorFxi.get(x));
		return resultado;
	}
	/**
	 * Metodo  Terms
	 * @param recive un dato tipo double y un dato i double y un dato dof tipo double una dato doble multiplier
	 * @return retorna un double
	 */
	public double resultadoFinal( double dato, double i, double dof, double[] multiplier){
		double resultado = 0;
		for( double x: Terms( dato, i, dof, multiplier))
			resultado += x;
		return resultado;
	}
	
}
