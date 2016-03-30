package ecos.mavenproject5;




import java.util.ArrayList;

import logica.Calcular;
/**
 * Descripción: este programa genera una tabla de tamaños relativos para una lista de valores pregarcados
 * @author Daniel m Alvarez
 * 
 */
public class main {

	
	
	public static void main( String args[]) {
		// TODO Auto-generated constructor stub

		int i = 10;
		String[] tablas = { "Ejemplo 1", "Ejemplo 2", "Ejemplo 3"};
		double[] dato = { 1.1, 1.1812, 2.75};
		double[] dof = { 9, 10, 30};
		double[] multiplier = { 1, 4, 2, 4, 2, 4, 2, 4, 2, 4, 1};
		double[] resultados = { 0.35006, 0.36757, 0.495};
		Calcular cal = new Calcular();
		
		String html = "<table border='1'><theader><tr><th></th><th>Resultado esperado</th><th>Resultado</th></tr></theader><tbody>";
		for( int x = 0; x < tablas.length; x++)
			html += "<tr><td>" + tablas[x] + "</td><td>" + resultados[x] + "</td><td>" + cal.resultadoFinal(dato[x], i, dof[x], multiplier) + "</td></tr>";
		html += "</tbody></table>";
		System.out.println( html);
	}

}
