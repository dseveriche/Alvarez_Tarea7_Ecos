package logica;

import java.util.ArrayList;

public class RegresionLineal {
	/**
	 * Nombre:                       Daniel MAuricio Alvarez                                                                       
	 * Fecha :                       1/5/2016
	 * Descripci�n:                  funcion crear para multipar array list y retornar 
	 * la multiplicacion lista 
	 * */	
	
	// ----------------------------------------------------------
	// M�todos
	// ----------------------------------------------------------

	public static ArrayList<Double> MultiplicarLista( ArrayList<Double> num1, ArrayList<Double> num2){
		
		ArrayList<Double> resultado = new ArrayList<Double>();
		for( int x = 0; x < num1.size(); x++)
			resultado.add( num1.get(x) * num2.get(x));
		return resultado;
	}
	/*
	 * saber el cuadrado de las arraylist devolviendo un arraylist double
	 * */
	// ----------------------------------------------------------
	// Metodos
	// ----------------------------------------------------------

	
	public static double RaizCudrada( double numero){
		return numero * numero;
	}
	
	public static ArrayList<Double> ListaCuadrada( ArrayList<Double> numeros){
		
		ArrayList<Double> resultado = new ArrayList<Double>();
		for( int x = 0; x < numeros.size(); x++)
			resultado.add( RaizCudrada( numeros.get( x)));
		return resultado;
	}
		/**
		* descripcion  crear una un atributo double sumando los numero de la lista
		* @param ArrayList
		* @return sumatoria
		*/
	// ----------------------------------------------------------
	// Metodos
	// ----------------------------------------------------------

	public static double Sumatoria( ArrayList<Double> numeros){
		
		double sumatoria = 0;
		for( double x: numeros)
			sumatoria += x;
		return sumatoria;
	}
	/**
	* descripcion  crear una un atributo double promedio los numero de la lista
	* @param ArrayList
	* @return promedio
	*/
	// ----------------------------------------------------------
	// M�todos
	// ----------------------------------------------------------

	public static double Promedio( ArrayList<Double> numeros){
		return Sumatoria(numeros) / numeros.size();
	}
	/*
	 * return el valor de N para la regresion lineal 
	 * resiviendo como parametro el promedio de la
	 * columna X
	 * */
	// ----------------------------------------------------------
	// M�todos
	// ----------------------------------------------------------

	public static double N( double promedioX){

		return promedioX * promedioX;
	}
	/**
	* descripcion  retorna el valor beta 1 de la regresion lineal
	* resiviendo como parametro dos  ArrayList double 
	* @param ArrayList<Double> num1, ArrayList<Double> num2
	* @return Beta1
	*/
	
	// ----------------------------------------------------------
	// M�todos
	// ----------------------------------------------------------

	public static double Beta1( ArrayList<Double> num1, ArrayList<Double> num2){
		
		int N = num1.size();
		double promedioX = Promedio( num1);
		double promedioY = Promedio( num2);
		double CuadradaPromedioX = promedioX * promedioX;
		double sumatoriaMultiplicarLista = Sumatoria( MultiplicarLista( num1, num2));
		double sumatoriaCuadradaX = Sumatoria(ListaCuadrada( num1));
		return ((sumatoriaMultiplicarLista) - (( N * promedioX) * promedioY)) / (sumatoriaCuadradaX - (N * CuadradaPromedioX ));
	}
	/**
	* descripcion  retorna el valor RYX de la regresion lineal
	* resiviendo como parametro dos  ArrayList double 
	* @param ArrayList<Double> num1, ArrayList<Double> num2
	* @return Beta1
	*/
	
	// ----------------------------------------------------------
	// M�todos
	// ----------------------------------------------------------

	public static double Ryx( ArrayList<Double> num1, ArrayList<Double> num2){
		
		int N = num1.size();
		double sumatoriaMultiplicarXY = Sumatoria( MultiplicarLista( num1, num2)); 
		double sumatoriaX = Sumatoria(num1);
		double sumatoriaY = Sumatoria(num2);
		double sumatoriaCuadradaY = Sumatoria(ListaCuadrada( num2));
		double sumatoriaCuadradaX = Sumatoria(ListaCuadrada( num1));
		return ( (N * ( sumatoriaMultiplicarXY) - ( sumatoriaX * sumatoriaY))/ (Math.sqrt((N*sumatoriaCuadradaX - Math.pow(sumatoriaX,2))*(N*sumatoriaCuadradaY - Math.pow(sumatoriaY,2)))));
	}
	
	/**
	* descripcion  retorna el valor R^2 de la regresion lineal
	* resiviendo como parametro dos  ArrayList double 
	* @param ArrayList<Double> num1, ArrayList<Double> num2
	* @return R2
	*/
	
	// ----------------------------------------------------------
	// M�todos
	// ----------------------------------------------------------

	public static double R2( ArrayList<Double> num1, ArrayList<Double> num2){
		
		double ryx = Ryx( num1, num2);
		
		return ryx * ryx;
	}
	/**
	* descripcion  retorna el valor B0 de la regresion lineal
	* resiviendo como parametro dos  ArrayList double 
	* @param ArrayList<Double> num1, ArrayList<Double> num2
	* @return Beta0
	*/
	
	// ----------------------------------------------------------
	// M�todos
	// ----------------------------------------------------------

	public static double Beta0( ArrayList<Double> num1, ArrayList<Double> num2){

		double promedioX = Promedio( num1);
		double promedioY = Promedio( num2);
		double b1 = Beta1( num1, num2);
		return promedioY - 	( b1 * promedioX);
	}
	
	/**
	* descripcion  etorna el valor Yk de la regresion lineal
	* resiviendo como parametro dos  ArrayList double  y la constante XK
	* @param ArrayList<Double> num1, ArrayList<Double> num2, costante xk
	* @return YK
	*/
	
	// ----------------------------------------------------------
	// M�todos
	// ----------------------------------------------------------

	public static double Yk( ArrayList<Double> num1, ArrayList<Double> num2, double Xk){

		double b1 = Beta1( num1, num2);
		double b0 = Beta0( num1, num2);
		return b0 + ( b1 * Xk);
	}
	
	public static double SumatoriaYiMenosBeta0MenosBeta1XiAlCuadrado( ArrayList<Double> num1, ArrayList<Double> num2){
		
		double beta0 = Beta0( num1, num2);
		double beta1 = Beta1( num1, num2);
		
		ArrayList<Double> lista = new ArrayList<Double>();
		for( int x = 0; x < num1.size(); x++)
			lista.add( RaizCudrada( num2.get(x) - beta0 -( beta1 * num1.get(x))));
		
		Sumatoria( lista);
		
		return Sumatoria( lista);
	}

	public static double SumatoriaXiMenosXavgAlCudrado( ArrayList<Double> num1, ArrayList<Double> num2){
		
		double resultado = 0;
		ArrayList<Double> lista = new ArrayList<Double>();
		
		double promedioX = Promedio( num1);
		
		for( int x = 0; x < num1.size(); x++)
			lista.add( RaizCudrada( num1.get(x) - promedioX));
			
		return Sumatoria( lista);
	}
	
	public static double Numerador( ArrayList<Double> num1, ArrayList<Double> num2){

		double ryx = Ryx( num1, num2);
		double raizNMenos2 = Math.sqrt( num1.size() - 2);
		return raizNMenos2 * ryx;
		
	}
	
	public static double Denominador( ArrayList<Double> num1, ArrayList<Double> num2){

		return Math.sqrt(1 - ( Ryx( num1, num2) * Ryx( num1, num2)));
	}
	
	public static double X( ArrayList<Double> num1, ArrayList<Double> num2){
		
		return Numerador( num1, num2) / Denominador( num1, num2);
	}

	public static double XkMenosXavgAlCuadrado( int xk, ArrayList<Double> num1, ArrayList<Double> num2){
		
		double xavg = Promedio( num1);
		
		
		return ( xk - xavg) * ( xk - xavg);
	}
	
	public static double TercerTermino( int xk, ArrayList<Double> num1, ArrayList<Double> num2){

		return Math.sqrt( 1 + ( 1.0 / num1.size()) + ( XkMenosXavgAlCuadrado( xk,num1,num2) / ( SumatoriaXiMenosXavgAlCudrado( num1, num2) )));
	}
	
	public static double DesviacionEstandar( ArrayList<Double> num1, ArrayList<Double> num2){
		
		return Math.sqrt(( 1.0 / ( num1.size() - 2)) * SumatoriaYiMenosBeta0MenosBeta1XiAlCuadrado( num1, num2));
	}
	
	public static double Significancia( int valor){
		
		ArrayList<Double> valores = new ArrayList<Double>();
		valores.add(0.000017751717813175);
		valores.add(0.0000798202749293892);
		valores.add(0.000217731741499894);
		valores.add(0.000000000000095537);
		
		return valores.get(valor);
	}
}
