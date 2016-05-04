package org.junit;

import java.util.ArrayList;

import junit.framework.TestCase;
import logica.RegresionLineal;

public class RegresionLinealTest extends TestCase {
	
	public void testB0(){
		ArrayList<Double> datos1 = new ArrayList<Double>();
		double[] vector1 = { 130, 650, 99, 150,	128, 302, 95, 945, 368,	961};
		for( double x: vector1){
			datos1.add(x);
		}
		ArrayList<Double> datos2 = new ArrayList<Double>();
		double[] vector2 = { 186, 699, 132, 272, 291, 331, 199, 1890, 788, 1601};
		for( double x: vector2){
			datos2.add(x);
		}
		
		RegresionLineal rl = new RegresionLineal();
		
		double resultadoEsperadoB0 = -22.5525;
		double resultado = rl.Beta0( datos1, datos2);
		assertEquals( resultadoEsperadoB0, resultado, 0.01);
	}
		
	public void testB1(){
		ArrayList<Double> datos1 = new ArrayList<Double>();
		double[] vector1 = { 130, 650, 99, 150,	128, 302, 95, 945, 368,	961};
		for( double x: vector1){
			datos1.add(x);
		}
		ArrayList<Double> datos2 = new ArrayList<Double>();
		double[] vector2 = { 186, 699, 132, 272, 291, 331, 199, 1890, 788, 1601};
		for( double x: vector2){
			datos2.add(x);
		}
		
		RegresionLineal rl = new RegresionLineal();
		
		double resultadoEsperadoB0 = 1.7279;
		double resultado = rl.Beta1( datos1, datos2);
		assertEquals( resultadoEsperadoB0, resultado, 0.01);
	}	
	
	public void testRxy(){
		ArrayList<Double> datos1 = new ArrayList<Double>();
		double[] vector1 = { 130, 650, 99, 150,	128, 302, 95, 945, 368,	961};
		for( double x: vector1){
			datos1.add(x);
		}
		ArrayList<Double> datos2 = new ArrayList<Double>();
		double[] vector2 = { 186, 699, 132, 272, 291, 331, 199, 1890, 788, 1601};
		for( double x: vector2){
			datos2.add(x);
		}
		
		RegresionLineal rl = new RegresionLineal();
		
		double resultadoEsperadoB0 = 0.9545;
		double resultado = rl.Ryx( datos1, datos2);
		assertEquals( resultadoEsperadoB0, resultado, 0.01);
	}	
	
	public void testR2(){
		ArrayList<Double> datos1 = new ArrayList<Double>();
		double[] vector1 = { 130, 650, 99, 150,	128, 302, 95, 945, 368,	961};
		for( double x: vector1){
			datos1.add(x);
		}
		ArrayList<Double> datos2 = new ArrayList<Double>();
		double[] vector2 = { 186, 699, 132, 272, 291, 331, 199, 1890, 788, 1601};
		for( double x: vector2){
			datos2.add(x);
		}
		
		RegresionLineal rl = new RegresionLineal();
		
		double resultadoEsperadoB0 = 0.9111;
		double resultado = rl.R2( datos1, datos2);
		assertEquals( resultadoEsperadoB0, resultado, 0.01);
	}	
	public void testYk(){
		ArrayList<Double> datos1 = new ArrayList<Double>();
		double[] vector1 = { 130, 650, 99, 150,	128, 302, 95, 945, 368,	961};
		for( double x: vector1){
			datos1.add(x);
		}
		ArrayList<Double> datos2 = new ArrayList<Double>();
		double[] vector2 = { 186, 699, 132, 272, 291, 331, 199, 1890, 788, 1601};
		for( double x: vector2){
			datos2.add(x);
		}
		
		RegresionLineal rl = new RegresionLineal();
		
		double resultadoEsperadoB0 = 644.429;
		double resultado = rl.Yk( datos1, datos2,386);
		assertEquals( resultadoEsperadoB0, resultado, 0.01);
	}	

}
