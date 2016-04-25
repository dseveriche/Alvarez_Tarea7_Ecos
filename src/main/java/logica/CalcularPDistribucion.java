package logica;


import java.util.ArrayList;
import java.util.List;

public class CalcularPDistribucion {
	
	    int  num_seg  =10;
        Calcular cal = new Calcular();	
	    List<Double> listXi;
	    List<Double> listMulti;
	    List<Double> listFx;
	    List<Double> listTerms;
	
	 public double generarValues(double x, double dof){
		    listXi= new ArrayList<>();
	        listMulti = new ArrayList<>();
	        listFx = new ArrayList<>();
	        listTerms = new ArrayList<>();
	        
	        build_ColXi(x);
	        build_Fx(dof);
	        build_ColMultip();
	        buildTerms(x);
	        return Double.parseDouble(cal.df.format(cal.getSumatoriaList(listTerms)).replace(',', '.'));
	    }
	 /**
	     * Metodo que construye la Columna de Xi
	     * @param x - valor de x
	     */
	    public void build_ColXi(double x){
	        for(int k = 0; k<= num_seg; k++){
	            listXi.add((k*x)/num_seg);   
	        }
	    }
	    
	    /**
	     * Metodo que construye las columna F(x) - Implicitamente separa en 
	     * listas las 2 partes de la ecuacion para luego operarlas y obtener F(x)
	     * @param dof - grados de libertad
	     */
	    public void build_Fx(double dof){
	        List<Double> listFPEcua = new ArrayList<>();
	        List<Double> listSPEcua = new ArrayList<>();
	        
	        double base;
	        double expo;
	        double resultSP;
	        
	        for (int i = 0; i <= num_seg; i++) {
	            base = 1 + ((Math.pow(listXi.get(i), 2)) / dof);
	            expo = ((dof + 1) / 2);
	            resultSP = 1 / (Math.pow(base, expo));
	            
	            listSPEcua.add(resultSP);
	            listFPEcua.add(cal.calcFirstPartEqua(dof));
	        }
	       
	        for (int i = 0; i <= num_seg; i++) {
	            listFx.add(listSPEcua.get(i) * listFPEcua.get(i));
	        }
	    }
	    
	    /**
	     * Metodo que contruye la columna de multiplicadores.
	     * lo hace por relacion de pares e impares
	     */
	    public void build_ColMultip(){
	        for (int i = 0; i <= num_seg; i++) {
	            if(i == 0 || i == num_seg){
	                listMulti.add(1d);
	            }else if((i % 2) == 0){
	                listMulti.add(2d);
	            }else{
	                listMulti.add(4d);
	            }
	        }
	    }
	    
	    /**
	     * Metodo que calcula la columna de Terms
	     * @param x - valor de x 
	     */
	    public void buildTerms(double x){
	        for (int i = 0; i <= num_seg; i++) {
	            listTerms.add(cal.calcSingleTerms((x/num_seg), listMulti.get(i), listFx.get(i)));
	        }
	    }
	}


