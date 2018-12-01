package testes_AnalisadorCompilador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class teste_Expressoes {
	public static ExpressaoUtils e = new ExpressaoUtils();

	@Test public void simplifcaComSoma() {
		assertEquals("3.0", e.simplificaBinario("1 + 2".split(" ")));
	}

	@Test public void simplifcaComSubtracao() {
		assertEquals("-1.0", e.simplificaBinario("1 - 2".split(" ")));
	}

	@Test public void simplifcaComMultiplicacao() {
		assertEquals("2.0", e.simplificaBinario("1 * 2".split(" ")));
	}

	@Test public void simplifcaComDivisao() {
		assertEquals("0.5", e.simplificaBinario("1 / 2".split(" ")));
	}

	@Test public void simplifcaComResto() {
		assertEquals("1.0", e.simplificaBinario("3 % 2".split(" ")));
	}

	@Test public void simplifcaComNegativos() {
		assertEquals("-1.0", e.simplificaBinario("-3 + 2".split(" ")));
	}

	@Test public void simplifcaComNegativos2() {
		assertEquals("1.0", e.simplificaBinario("3 + -2".split(" ")));
	}

	@Test public void simplifcaComMenor() {
		assertEquals("0", e.simplificaBinario("3 < -2".split(" ")));
	}

	@Test public void simplifcaComMaior() {
		assertEquals("1", e.simplificaBinario("3 > -2".split(" ")));
	}

	@Test public void simplifcaComMenorIgual() {
		assertEquals("0", e.simplificaBinario("3 <= -2".split(" ")));
	}

	@Test public void simplifcaComMaiorIgual() {
		assertEquals("1", e.simplificaBinario("3 >= -2".split(" ")));
	}

	@Test public void simplifcaComIgual() {
		assertEquals("0", e.simplificaBinario("3 = -2".split(" ")));
	}

	public static void main(String args[]) {
		final String s = "2+3*5-4";
		String[]     a = e.pegaPedacos(s);
		System.out.println(Arrays.toString(a));
	}

	@Test public void pegaPedacos() {}
}
