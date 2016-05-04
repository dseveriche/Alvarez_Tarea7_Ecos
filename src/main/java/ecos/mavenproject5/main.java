package ecos.mavenproject5;

import java.text.DecimalFormat;
import java.util.ArrayList;

import logica.Calcular;
import logica.CalcularPDistribucion;
import logica.Datos;

import logica.RegresionLineal;

/**
 * Descripción: este programa genera una tabla calculate the correlation between two sets of numbers x and y
 * calculate the significance of that correlation
 * calculate the linear regression parameters   and   for a set of n pairs of data,
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
		int xk = 386;
		String[] tablas = { "Ejemplo 1", "Ejemplo 2", "Ejemplo 3", "Ejemplo 4"};
		double[] dato = { 1, 1, 1, 1};
		double[] dof = { 8, 8, 1, 1};	
		double[] multiplier = { 1, 4, 2, 4, 2, 4, 2, 4, 2, 4, 1};
		double[] resultados = { 0.35, 0.35, 0.35, 0.35};
		Calcular cal = new Calcular();
		/**
	     * datos iniciales
	     */
		String[][] datosTabla1 = {
				{"Estimated Proxy Size", "130", "650",	"99", "150", "128",	"302", "95", "945",	"368",	"961"},
				{"Actual Added and Modified Size", "186", "699", "132",	"272",	"291",	"331",	"199",	"1890",	"788",	"1601"},
				{"Estimated Proxy Size",	"130",	"650",	"99",	"150",	"128",	"302",	"95",	"945",	"368",	"961"},
				{"Actual Development Hours", "15", "69.9",	"6.5",	"22.4",	"28.4",	"65.9",	"19.4",	"198.7",	"38.8",	"138.2"},
				{"Estimated Proxy Size",	"238",	"179",	"259"},
				{"Actual Added and Modified Size",	"161",	"159",	"91"},
				{"Estimated Proxy Size",	"238",	"179",	"259"},
				{"Actual Development Hours",	"6.39",	"5.01",	"7.32"}

			};
			
			Datos datos = new Datos();
			ArrayList<ArrayList<Double>> tabla = datos.LeerDatos(datosTabla1);
			
			// Objeto de operaciones
			RegresionLineal operacion = new RegresionLineal();
					
			
//	double calX = operacion.X( tabla.get(0), tabla.get(1));
//	double Significancia = cal.resultadoFinal( calX, tabla.size(), tabla.size() - 2, multiplier);
//	System.out.println( Significancia);	
	
	
	int x = 0;
	double t = Double.parseDouble( new DecimalFormat("0.00000").format(iterationInputs(dato[x], dof[x], resultados[x])).replace(',', '.'));
	double rango = operacion.DesviacionEstandar(tabla.get(0), tabla.get(1)) * operacion.TercerTermino(xk, tabla.get(0), tabla.get(1)) * t;

//	System.out.println( operacion.DesviacionEstandar(tabla.get(0), tabla.get(1)));
//	System.out.println(operacion.TercerTermino(xk, tabla.get(0), tabla.get(1)));
//	System.out.println(cal.resultadoFinal(dato[x], i, dof[x], multiplier));
//	System.out.println(rango);
//	System.out.println(new DecimalFormat("0.00000").format(iterationInputs(dato[x], dof[x], resultados[x])).replace(',', '.'));
	/**
     * impresion de resultados
     * 
     */
	double UPI = operacion.Yk( tabla.get(0), tabla.get(1), xk) + rango;
	double LPI = operacion.Yk( tabla.get(0), tabla.get(1), xk) - rango;

	System.out.println( operacion.Ryx( tabla.get(0), tabla.get(1)));
	System.out.println( operacion.R2( tabla.get(0), tabla.get(1)));
	System.out.println( operacion.Significancia(0));
	System.out.println( operacion.Beta0( tabla.get(0), tabla.get(1)));
	System.out.println( operacion.Beta1( tabla.get(0), tabla.get(1)));
	System.out.println( operacion.Yk( tabla.get(0),  tabla.get(1), xk));
	System.out.println( rango);
	System.out.println( UPI);
	System.out.println( LPI);
	
	rango = operacion.DesviacionEstandar(tabla.get(2), tabla.get(3)) * operacion.TercerTermino(xk, tabla.get(2), tabla.get(3)) * t;
	UPI = operacion.Yk( tabla.get(2), tabla.get(3), xk) + rango;
	LPI = operacion.Yk( tabla.get(2), tabla.get(3), xk) - rango;
	
	System.out.println( operacion.Ryx( tabla.get(2), tabla.get(3)));
	System.out.println( operacion.R2( tabla.get(2), tabla.get(3)));
	System.out.println( operacion.Significancia(1));
	System.out.println( operacion.Beta0( tabla.get(2), tabla.get(3)));
	System.out.println( operacion.Beta1( tabla.get(2), tabla.get(3)));
	System.out.println( operacion.Yk( tabla.get(2),  tabla.get(3), xk));
	System.out.println( rango);
	System.out.println( UPI);
	System.out.println( LPI);

	rango = operacion.DesviacionEstandar(tabla.get(4), tabla.get(5)) * operacion.TercerTermino(xk, tabla.get(4), tabla.get(5)) * t;
	UPI = operacion.Yk( tabla.get(4), tabla.get(5), xk) + rango;
	LPI = operacion.Yk( tabla.get(4), tabla.get(5), xk) - rango;

	System.out.println( operacion.Ryx( tabla.get(4), tabla.get(5)));
	System.out.println( operacion.R2( tabla.get(4), tabla.get(5)));
	System.out.println( operacion.Significancia(2));
	System.out.println( operacion.Beta0( tabla.get(4), tabla.get(5)));
	System.out.println( operacion.Beta1( tabla.get(4), tabla.get(5)));
	System.out.println( operacion.Yk( tabla.get(4),  tabla.get(5), xk));
	System.out.println( rango);
	System.out.println( UPI);
	System.out.println( LPI);

	rango = operacion.DesviacionEstandar(tabla.get(6), tabla.get(7)) * operacion.TercerTermino(xk, tabla.get(6), tabla.get(7)) * t;
	UPI = operacion.Yk( tabla.get(6), tabla.get(7), xk) + rango;
	LPI = operacion.Yk( tabla.get(6), tabla.get(7), xk) - rango;

	System.out.println( operacion.Ryx( tabla.get(6), tabla.get(7)));
	System.out.println( operacion.R2( tabla.get(6), tabla.get(7)));
	System.out.println( operacion.Significancia(3));
	System.out.println( operacion.Beta0( tabla.get(6), tabla.get(7)));
	System.out.println( operacion.Beta1( tabla.get(6), tabla.get(7)));
	System.out.println( operacion.Yk( tabla.get(6),  tabla.get(7), xk));
	System.out.println( rango);
	System.out.println( UPI);
	System.out.println( LPI);
	
	
	/*
	String html = "<table border='1'><theader><tr><th></th><th>Resultado esperado</th><th> + resultados[0] + </th></tr></theader><tbody>";
		System.out.println( "resultado1: " + tabla);
		System.out.println( "resultado1: " + r);
		for( int x = 0; x < tablas.length; x++){
			html += "<tr><td>" + tablas[x] + "</td><td>" + resultados[x] + "</td><td>" + cal.resultadoFinal(dato[x], i, dof[x], multiplier) + "</td></tr>";
		html += "</tbody></table>";
			html += "<tr><td>" + tablas[x] + "</td><td>" + resultados[x] + "</td><td>" + new DecimalFormat("0.00000").format(iterationInputs(dato[x], dof[x], resultados[x])).replace(',', '.')  + "</td></tr>";
			   html += "</tbody></table>";
     	System.out.println( html);
		}
	*/	
	}
	/**
	 * Metodo iterationInputs
	 * @param dato tipo double y un dato i double
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
	//	System.out.println( "resultado1: " + resultado1);
		
		return resultado1;
	}
}
