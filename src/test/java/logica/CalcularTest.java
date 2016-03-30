package logica;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CalcularTest {

	int i = 10;
	double dato = 1.1;
	double dof = 9;
	double[] multiplier = { 1, 4, 2, 4, 2, 4, 2, 4, 2, 4, 1};
	
	Calcular cal = new Calcular();
	
	@Test
	public void testXi() {
		
		double[] resultadoEsperado = { 0, 0.11, 0.22, 0.33, 0.44, 0.55, 0.66, 0.77, 0.88, 0.99, 1.1 };
		ArrayList<Double> resultado = cal.Xi(dato, i);
		
		for( int x = 0; x < resultadoEsperado.length; x++)
			assertEquals( resultadoEsperado[x], resultado.get(x), 0.01 );
		
	}

	@Test
	public void testUnoMasX2SobreDof() {

		double[] resultadoEsperado = { 1, 1.00134, 1.00538, 1.01210, 1.02151, 1.03361, 1.04840, 1.06588, 1.08604, 1.10890, 1.13444 };
		ArrayList<Double> resultado = cal.UnoMasX2SobreDof(dato, i, dof);
		
		for( int x = 0; x < resultadoEsperado.length; x++)
			assertEquals( resultadoEsperado[x], resultado.get(x), 0.01 );
	}

	@Test
	public void testNegativoDofMasUnoSobreDos() {

		double resultadoEsperado = -5;
		double resultado = cal.NegativoDofMasUnoSobreDos( dof, i);
		
		assertEquals( resultadoEsperado, resultado, 0.01 );
	}

	@Test
	public void testListaPotenciacion() {

		double[] resultadoEsperado = { 1, 0.99330, 0.97354, 0.94164, 0.89905, 0.84765, 0.78952, 0.72688, 0.66185, 0.59640, 0.53221};
		ArrayList<Double> resultado = cal.ListaPotenciacion(dato, i, dof);
		
		for( int x = 0; x < resultadoEsperado.length; x++)
			assertEquals( resultadoEsperado[x], resultado.get(x), 0.01 );
	}
	
	@Test
	public void testDofPorPiElevadoUnoymedio() {

		double resultadoEsperado = 5.31736;
		double resultado = cal.DofPorPiElevadoUnoymedio(dof);
		
		assertEquals( resultadoEsperado, resultado, 0.01 );
	}

	@Test
	public void testGammaDofSobreDos() {

		double resultadoEsperado = 11.63173;
		double resultado = cal.GammaDofSobreDos(dof);
		
		assertEquals( resultadoEsperado, resultado, 0.01 );
	}

	@Test
	public void testGammaDofSobreDosSobreDofPorPiElevadoUnoymedioPorGammaDofSobreDos() {

		double resultadoEsperado = 0.38803;
		double resultado = cal.GammaDofSobreDosSobreDofPorPiElevadoUnoymedioPorGammaDofSobreDos(dof);
		
		assertEquals( resultadoEsperado, resultado, 0.01 );
	}

	@Test
	public void testFXi() {

		double[] resultadoEsperado = { 0.38803, 0.38544, 0.37777, 0.36539, 0.34886, 0.32892, 0.30636, 0.28205, 0.25682, 0.23142, 0.20652};
		ArrayList<Double> resultado = cal.FXi(dato, i, dof);
		
		for( int x = 0; x < resultadoEsperado.length; x++)
			assertEquals( resultadoEsperado[x], resultado.get(x), 0.01 );
	}

	@Test
	public void testW() {

		double resultadoEsperado = 0.11;
		double resultado = cal.w(dato, i);
		
		assertEquals( resultadoEsperado, resultado, 0.01 );
	}

	@Test
	public void testTerms() {

		double[] resultadoEsperado = { 0.01423, 0.05653, 0.0277, 0.05359, 0.02558, 0.04824, 0.02247, 0.04137, 0.01883, 0.03394, 0.00757};
		ArrayList<Double> resultado = cal.Terms(dato, i, dof, multiplier);
		
		for( int x = 0; x < resultadoEsperado.length; x++)
			assertEquals( resultadoEsperado[x], resultado.get(x), 0.01 );
	}

	@Test
	public void testResultadoFinal() {

		double resultadoEsperado = 0.35006;
		double resultado = cal.resultadoFinal(dato, i, dof, multiplier);
		
		assertEquals( resultadoEsperado, resultado, 0.01 );
	}
}
