package logica;

import java.util.*;

public class Datos {
	/**
     * Metodo que construye un array list con los datos iniciales
     * @param x datos
     * @return Beta1
     */
	public ArrayList<ArrayList<Double>> LeerDatos( String[][] datos) {
		// TODO Auto-generated constructor stub
		ArrayList<ArrayList<Double>> datosList = new ArrayList<ArrayList<Double>>();
		
		for( int x = 0; x < datos.length; x++ ){
			ArrayList<Double> celda = new ArrayList<Double>();
			for( int y = 1; y < datos[x].length; y++){
				celda.add( Double.parseDouble(datos[x][y]));
			}
			datosList.add(celda);
		}
		
		return datosList;
	}

}
