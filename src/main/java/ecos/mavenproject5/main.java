package ecos.mavenproject5;




import java.text.DecimalFormat;
import java.util.ArrayList;

import logica.Calcular;
import logica.CalcularPDistribucion;
/**
 * Descripción: este programa genera una tabla de tamaños relativos para una lista de valores pregarcados
 * @author Daniel m Alvarez
 * 
 */
public class main {

	 static CalcularPDistribucion calDistri = new CalcularPDistribucion();
	    static double error = 0.00001;
	
	public static void main( String args[]) {
		// TODO Auto-generated constructor stub
		double r=0;

		int i = 10;
		String[] tablas = { "Ejemplo 1", "Ejemplo 2", "Ejemplo 3"};
		double[] dato = { 1, 1, 1};
		double[] dof = { 6, 15, 4};	
		double[] multiplier = { 1, 4, 2, 4, 2, 4, 2, 4, 2, 4, 1};
		double[] resultados = { 0.20000, 0.45000, 0.49500};
		Calcular cal = new Calcular();
		
		String html = "<table border='1'><theader><tr><th></th><th>Resultado esperado</th><th> + resultados[0] + </th></tr></theader><tbody>";
		System.out.println( "resultado1: " + r);
		for( int x = 0; x < tablas.length; x++){
		//	html += "<tr><td>" + tablas[x] + "</td><td>" + resultados[x] + "</td><td>" + cal.resultadoFinal(dato[x], i, dof[x], multiplier) + "</td></tr>";
		//html += "</tbody></table>";
			html += "<tr><td>" + tablas[x] + "</td><td>" + resultados[x] + "</td><td>" + new DecimalFormat("0.00000").format(iterationInputs(dato[x], dof[x], resultados[x])).replace(',', '.')  + "</td></tr>";
			   html += "</tbody></table>";
     	System.out.println( html);
		}
		
	}

	/**
	 * Metodo iterationInputs
	 * @param recive un dato tipo double y  un dato dof tipo double y doble resultado
	 * @return retorna un double resulado1
	 */
	public static double iterationInputs(double dato, double dof, double resultado) {
		
		double resultado1 = 0;
		
		while (calDistri.generarValues(dato, dof) != resultado) {
            if (calDistri.generarValues(dato, dof) > resultado) {
                dato = dato - error;
            } else if (calDistri.generarValues(dato, dof) < resultado) {
                dato = dato + error;
            }            
        }
		resultado1 = dato;
		System.out.println( "resultado1: " + resultado1);
		
		return resultado1;
	}
}
