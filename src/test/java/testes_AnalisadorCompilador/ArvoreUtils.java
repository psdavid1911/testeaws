package testes_AnalisadorCompilador;

import java.util.Arrays;
import java.util.logging.Logger;

public class ArvoreUtils {
	private static final String opTernario = "se|\\?";
	private static final String opBinario  = "\\+|\\-|\\*|\\/|\\%|=|>|<|<=|>=";
	private static final String opUnario   = "\\+\\+|\\-\\-|\\!|nao";
	private static final String operadores = opUnario + "|" + opBinario + "|" + opTernario;

	public static Arvore buscaFolha(String expressao, Arvore arvore) {
		Arvore resultado  = null;
		for(Arvore noAdjascente : arvore.getNos()) {
			resultado = buscaFolha(expressao, noAdjascente);
			if(resultado != null) return resultado;
		}
		return null;
	}

	public static Arvore parseArvore(String expressao) {
		String pedaco[] = limpaExpressao(expressao).split(" ");
		Arvore arvore   = new Arvore(pedaco[0]);
		Logger.getGlobal().info("Expressão ->  " + Arrays.toString(pedaco));
		for(int i = 1; i < pedaco.length; i++) {
			if (pedaco[i].matches(opTernario)) arvore = arvore.addPai(pedaco[i], arvore);
			else if (pedaco[i].matches(opBinario)) arvore = arvore.addPai(pedaco[i], arvore);
			else if (pedaco[i].matches(opUnario)) arvore = arvore.addPai(pedaco[i], arvore);
			else if (arvore.getConteudo() == null) arvore.setConteudo(pedaco[i]);
			else arvore.addNovoFilho(pedaco[i]);
		}
		return arvore;
	}

	public static String limpaExpressao(String expressao) {
		expressao = expressao.replaceAll("\\+", " + ");
		expressao = expressao.replaceAll("\\-", " - ");
		expressao = expressao.replaceAll("\\*", " * ");
		expressao = expressao.replaceAll("\\/", " / ");
		expressao = expressao.replaceAll("\\%", " % ");
		expressao = expressao.replaceAll("\\<", " < ");
		expressao = expressao.replaceAll("\\>", " > ");
		expressao = expressao.replaceAll("\\=", " = ");
		expressao = expressao.replaceAll("\\s+", " ");
		expressao = expressao.replaceAll("\\s\\<\\s\\=\\s", " <= ");
		expressao = expressao.replaceAll("\\s\\>\\s\\=\\s", " >= ");
		expressao = expressao.replaceAll("\\s\\+\\s\\+\\s", " ++ ");
		expressao = expressao.replaceAll("\\s\\-\\s\\-\\s", " -- ");
		return expressao;
	}

	public static void simplifica(Arvore arvore) {
		Arvore no = buscaFolha(operadores, arvore);
		while(no != null) {
			if (no.getConteudo().matches(opUnario)) trataOperadorUnario(no);
			else if (no.getConteudo().matches(opBinario)) trataOperadorBinario(no);
			else if (no.getConteudo().matches(opTernario)) trataOperadorTernario(no);
			no = buscaFolha(operadores, arvore);
		}
	}

	public static void trataOperadorTernario(Arvore no) {
		Arvore no1    = no.getAdjascencia(0);
		Arvore no2    = no.getAdjascencia(1);
		Arvore no3    = no.getAdjascencia(2);
		String valor1 = no1.getConteudo();
		String valor2 = no2.getConteudo();
		String valor3 = no3.getConteudo();
		no.novo(Boolean.parseBoolean(valor1) ? valor2 : valor3);
	}

	public static void trataOperadorBinario(Arvore no) {
		Arvore noEsquerdo     = no.getAdjascencia(0);
		Arvore noDireito      = no.getAdjascencia(1);
		String valorEsquerdo  = noEsquerdo.getConteudo();
		String valorDireito   = noDireito.getConteudo();
		Double numeroEsquerdo = Double.parseDouble(valorEsquerdo);
		Double numeroDireito  = Double.parseDouble(valorDireito);
		if (no.getConteudo().equals("+")) no.novo(numeroEsquerdo + numeroDireito + "");
		else if (no.getConteudo().equals("-")) no.novo(numeroEsquerdo - numeroDireito + "");
		else if (no.getConteudo().equals("*")) no.novo(numeroEsquerdo * numeroDireito + "");
		else if (no.getConteudo().equals("/")) no.novo(numeroEsquerdo / numeroDireito + "");
		else if (no.getConteudo().equals("%")) no.novo(numeroEsquerdo % numeroDireito + "");
		else if (no.getConteudo().equals("=")) no.novo(valorEsquerdo == valorDireito ? "true" : "false");
		else if (no.getConteudo().equals("<")) no.novo(numeroEsquerdo < numeroDireito ? "true" : "false");
		else if (no.getConteudo().equals(">")) no.novo(numeroEsquerdo > numeroDireito ? "true" : "false");
		else if (no.getConteudo().equals("<=")) no.novo(numeroEsquerdo <= numeroDireito ? "true" : "false");
		else if (no.getConteudo().equals(">=")) no.novo(numeroEsquerdo >= numeroDireito ? "true" : "false");
	}

	public static void trataOperadorUnario(Arvore no) {
		Arvore noEsquerdo     = no.getAdjascencia(0);
		String valorEsquerdo  = noEsquerdo.getConteudo();
		Double numeroEsquerdo = Double.parseDouble(valorEsquerdo);
		if (no.getConteudo().equals("++")) no.novo(++numeroEsquerdo + "");
		else if (no.getConteudo().equals("--")) no.novo(--numeroEsquerdo + "");
		else if (no.getConteudo().equals("nao")) no.novo(Boolean.parseBoolean(valorEsquerdo) ? "false" : "true");
	}
}
