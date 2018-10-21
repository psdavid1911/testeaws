package testes_Matematica;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import EstruturasDeDados.Lista;
import Matematica.EstatisticaDescritiva;

public class EstatisticaDescritivaTest {
	public EstatisticaDescritivaTest() {}
	Double[] numeros = {1., 2., 3., 4., 5., 6.};

	@Test public void testMediaAritimetica() {
		System.out.println("mediaAritimetica");
		Lista<Double>         conjunto  = new Lista<Double>(numeros);
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		double                expResult = 3.5;
		double                result    = instance.mediaAritimetica(conjunto);
		System.out.println(result);
		assertEquals(expResult, result, 0.0);
	}

	@Test public void testMediaGeometrica() {
		System.out.println("mediaGeometrica");
		Lista<Double>         conjunto  = new Lista<Double>(numeros);
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		double                expResult = 2.993795165523909;
		double                result    = instance.mediaGeometrica(conjunto);
		assertEquals(expResult, result, 0.0);
	}

	@Test public void testMediaQuadratica() {
		System.out.println("mediaQuadratica");
		Lista<Double>         conjunto  = new Lista<Double>(numeros);
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		double                expResult = 3.8944404818493075;
		double                result    = instance.mediaQuadratica(conjunto);
		assertEquals(expResult, result, 0.0);
	}

	@Test public void testDesvioPadrao() {
		System.out.println("desvioPadrao");
		Lista<Double>         conjunto  = new Lista<Double>(numeros);
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		double                expResult = 1.8708286933869707;
		double                result    = instance.desvioPadrao(conjunto);
		assertEquals(expResult, result, 0.0);
	}

	@Test public void testMediana() {
		System.out.println("mediana");
		Lista<Double>         conjunto  = new Lista<Double>(numeros);
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		double                expResult = 3.5;
		double                result    = instance.mediana(conjunto);
		assertEquals(expResult, result, 0.0);
	}

	@Test public void testMaximo() {
		System.out.println("maximo");
		Lista<Double>         conjunto  = new Lista<Double>(numeros);
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		double                expResult = 6.0;
		double                result    = instance.maximo(conjunto);
		assertEquals(expResult, result, 0.0);
	}

	@Test public void testMinimo() {
		System.out.println("minimo");
		Lista<Double>         conjunto  = new Lista<Double>(numeros);
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		double                expResult = 1.0;
		double                result    = instance.minimo(conjunto);
		assertEquals(expResult, result, 0.0);
	}

	@Test public void testNumeroDeTermos() {
		System.out.println("numeroDeTermos");
		Lista<Double>         conjunto  = new Lista<Double>(numeros);
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		long                  expResult = 6L;
		long                  result    = instance.numeroDeTermos(conjunto);
		assertEquals(expResult, result);
	}

	@Test public void testSoma() {
		System.out.println("soma");
		Lista<Double>         conjunto  = new Lista<Double>(numeros);
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		double                expResult = 21.0;
		double                result    = instance.soma(conjunto);
		assertEquals(expResult, result, 0.0);
	}

	@Test public void testSomaDosQuadrados() {
		System.out.println("somaDosQuadrados");
		Lista<Double>         conjunto  = new Lista<Double>(numeros);
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		double                expResult = 91.0;
		double                result    = instance.somaDosQuadrados(conjunto);
		assertEquals(expResult, result, 0.0);
	}

	@Test public void testVarianciaDaAmostra() {
		System.out.println("varianciaDaAmostra");
		Lista<Double>         conjunto  = new Lista<Double>(numeros);
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		double                expResult = 3.5;
		double                result    = instance.varianciaDaAmostra(conjunto);
		assertEquals(expResult, result, 0.0);
	}

	@Test public void testVarianciaDaPopulacao() {
		System.out.println("varianciaDaPopulacao");
		Lista<Double>         conjunto  = new Lista<Double>(numeros);
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		double                expResult = 2.9166666666666665;
		double                result    = instance.varianciaDaPopulacao(conjunto);
		assertEquals(expResult, result, 0.0);
	}

	@Test public void testAssimetria() {
		System.out.println("assimetria");
		Lista<Double>         conjunto  = new Lista<Double>(numeros);
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		double                expResult = 0.0;
		double                result    = instance.assimetria(conjunto);
		assertEquals(expResult, result, 0.0);
	}
	
	Double[] numeros2 = {6.,2.,3.,4.,5.,1.};

	@Test public void testValoresOrdenados() {
		System.out.println("valoresOrdenados");
		Lista<Double>         conjunto  = new Lista<>(numeros2);
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		Lista<Double>         expResult = new Lista<Double>(numeros);
		Lista<Double>         result    = instance.valoresOrdenados(conjunto);
		assertEquals(expResult, result);
	}

	@Test public void testPercentil() {
		System.out.println("percentil");
		Lista<Double>         conjunto  = new Lista<>(numeros2);
		Double                percentil = 10D;
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		double                expResult = 1.0;
		double                result    = instance.percentil(conjunto, percentil);
		assertEquals(expResult, result, 0.0);
	}

	@Test public void testCurtose() {
		System.out.println("curtose");
		Lista<Double>         conjunto  = new Lista<>(numeros2);
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		double                expResult = -1.2000000000000002;
		double                result    = instance.curtose(conjunto);
		assertEquals(expResult, result, 0.0);
	}

	@Test public void testFrequenciaAbsoluta() {
		System.out.println("frequenciaAbsoluta");
		Lista<Double>         conjunto  = new Lista<>(numeros2);
		Double                elemento  = 1D;
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		long                  expResult = 1L;
		long                  result    = instance.frequenciaAbsoluta(conjunto, elemento);
		assertEquals(expResult, result);
	}

	@Test public void testFrequenciaPercentual() {
		System.out.println("frequenciaPercentual");
		Lista<Double>         conjunto  = new Lista<Double>(numeros);
		Double                elemento  = 1.0;
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		double                expResult = 0.2;
		double                result    = instance.frequenciaPercentual(conjunto, elemento);
		assertEquals(expResult, result, 0.0);
	}

	@Test public void testModa() {
		System.out.println("moda");
		Lista<Double>         conjunto  = new Lista<Double>(numeros);
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		Lista<Double>         expResult = new Lista<Double>(numeros);
		Lista<Double>         result    = instance.moda(conjunto);
		assertEquals(expResult, result);
	}

	@Test public void testFrequenciaAcumuladaAbsoluta() {
		System.out.println("frequenciaAcumuladaAbsoluta");
		Lista<Double>         conjunto  = new Lista<Double>(numeros);
		Double                elemento  = 1.0;
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		long                  expResult = 1L;
		long                  result    = instance.frequenciaAcumuladaAbsoluta(conjunto, elemento);
		assertEquals(expResult, result);
	}

	@Test public void testFrequenciaAcumuladaPercentual() {
		System.out.println("frequenciaAcumuladaPercentual");
		Lista<Double>         conjunto  = new Lista<Double>(numeros);
		Double                elemento  = 1D;
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		double                expResult = 0.2;
		double                result    = instance.frequenciaAcumuladaPercentual(conjunto, elemento);
		assertEquals(expResult, result, 0.0);
	}

	@Test public void testSomaDasFrequencias() {
		System.out.println("somaDasFrequencias");
		Lista<Double>         conjunto  = new Lista<Double>(numeros);
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		long                  expResult = 5L;
		long                  result    = instance.somaDasFrequencias(conjunto);
		assertEquals(expResult, result);
	}

	@Test public void testNumeroDeElementosDistintos() {
		System.out.println("numeroDeElementosDistintos");
		Lista<Double>         conjunto  = new Lista<Double>(numeros);
		EstatisticaDescritiva instance  = new EstatisticaDescritiva();
		int                   expResult = 5;
		int                   result    = instance.numeroDeElementosDistintos(conjunto);
		assertEquals(expResult, result);
	}
}
