package testes_AnalisadorCompilador;

import static java.lang.Double.parseDouble;
import static java.lang.String.valueOf;
import static java.util.regex.Pattern.compile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressaoUtils {
	private static final String numero           = "(-?[0-9]+)(\\.|\\,)([0-9]*)|(-?[0-9]*)(\\.|\\,)([0-9]+)|(-?[0-9]+)";
	private static final String palavra          = "([a..zA..Z]+)";
	private static final String boleanoVerdade   = "(1|verdadeiro|certo|correto)";
	private static final String boleanoFalsidade = "(falso|falsidade|mentira|falacia|0)";
	private static final String boleano          = boleanoFalsidade + "|" + boleanoVerdade;
	private static final String primitiva        = numero + "|" + palavra + "|" + boleano;
	private static final String opBinario        = "\\*|\\/\\%||\\+|\\-|=|>|<|<=|>=";
	private static final String opUnario         = "\\+\\+|\\-\\-|\\!|nao|\\?";
	// private static final String operadores = opUnario + "|" + opBinario;
	private static final Pattern pExpUnaria1 = compile("(" + primitiva + ") (" + opUnario + ")");
	private static final Pattern pExpUnaria2 = compile("(" + opUnario + ") (" + primitiva + ")");
	private static final Pattern pExpBinaria = compile("(" + primitiva + ") (" + opBinario + ") (" + primitiva + ")");
	private static final Pattern pExpTerna1  = compile("(" + primitiva + ") (" + "\\?" + ") (" + primitiva + ") (" + ":" + ") (" + primitiva + ")");
	private static final Pattern pExpTerna2  = compile("(se" + ") (" + primitiva + ") (" + "entao" + ") (" + primitiva + ") (" + "senao" + ") (" + primitiva + ")");
	private static final Pattern pExpTerna3  = compile("(se" + ") (" + primitiva + ") (" + "entao" + ") (" + primitiva + ")");
	Matcher                      buscador;
	

	public String[] pegaPedacos(String expressao) {
		
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
		buscador  = pExpUnaria1.matcher(expressao);
		while(buscador.find()) {
			expressao = expressao.replace(buscador.group(), simplificaUnaria1(buscador.group().split(" ")));
			buscador  = pExpUnaria1.matcher(expressao);
		}
		buscador = pExpUnaria2.matcher(expressao);
		while(buscador.find()) {
			expressao = expressao.replace(buscador.group(), simplificaUnaria2(buscador.group().split(" ")));
			buscador = pExpUnaria2.matcher(expressao);
		}
		buscador = pExpBinaria.matcher(expressao);
		while(buscador.find()) {
			expressao = expressao.replace(buscador.group(), simplificaBinario(buscador.group().split(" ")));
			buscador = pExpBinaria.matcher(expressao);
		}
		buscador = pExpTerna1.matcher(expressao);
		while(buscador.find()) {
			expressao = expressao.replace(buscador.group(), simplificaTerna1(buscador.group().split(" ")));
			buscador = pExpTerna1.matcher(expressao);
		}
		buscador = pExpTerna2.matcher(expressao);
		while(buscador.find()) {
			expressao = expressao.replace(buscador.group(), simplificaTernaGenerica(buscador.group().split(" ")));
			buscador = pExpTerna2.matcher(expressao);
		}
		buscador = pExpTerna3.matcher(expressao);
		while(buscador.find()) {
			expressao = expressao.replace(buscador.group(), simplificaTernaGenerica(buscador.group().split(" ")));
			buscador = pExpTerna3.matcher(expressao);
		}
		if(expressao.charAt(0) == ' ') expressao = expressao.substring(1);
		if(expressao.charAt(expressao.length()-1) == ' ') expressao = expressao.substring(1);
		return expressao.split(" ");
	}

	// Pode ampliar
	public String simplificaTerna1(String[] unaria) {
		return unaria[0].matches(boleanoVerdade) ? unaria[2] : unaria[4];
	}

	public String simplificaTernaGenerica(String[] unaria) {
		return unaria[1].matches(boleanoVerdade) ? unaria[3] : unaria.length < 5 ? "" : unaria[5];
	}

	public String simplificaBinario(String[] unaria) {
		String valor1 = unaria[0], operador = unaria[1], valor2 = unaria[2];
		if (operador.equals("*")) if (valor1.matches(numero) && valor2.matches(numero)) return "" + (parseDouble(valor1) * parseDouble(valor2));
		if (operador.equals("/")) if (valor1.matches(numero) && valor2.matches(numero)) return "" + (parseDouble(valor1) / parseDouble(valor2));
		if (operador.equals("%")) if (valor1.matches(numero) && valor2.matches(numero)) return "" + (parseDouble(valor1) % parseDouble(valor2));
		if (operador.equals("+")) if (valor1.matches(numero) && valor2.matches(numero)) return "" + (parseDouble(valor1) + parseDouble(valor2));
		if (operador.equals("-")) if (valor1.matches(numero) && valor2.matches(numero)) return "" + (parseDouble(valor1) - parseDouble(valor2));
		if (operador.equals("<")) if (valor1.matches(numero) && valor2.matches(numero)) return (parseDouble(valor1) < parseDouble(valor2)) ? "1" : "0";
		if (operador.equals(">")) if (valor1.matches(numero) && valor2.matches(numero)) return (parseDouble(valor1) > parseDouble(valor2)) ? "1" : "0";
		if (operador.equals("=")) if (valor1.matches(numero) && valor2.matches(numero)) return (parseDouble(valor1) == parseDouble(valor2)) ? "1" : "0";
		if (operador.equals("<=")) if (valor1.matches(numero) && valor2.matches(numero)) return (parseDouble(valor1) <= parseDouble(valor2)) ? "1" : "0";
		if (operador.equals(">=")) if (valor1.matches(numero) && valor2.matches(numero)) return (parseDouble(valor1) >= parseDouble(valor2)) ? "1" : "0";
		return "";
	}

	public String simplificaUnaria1(String[] unaria) {
		String valor = unaria[0], operador = unaria[1];
		if (operador.equals("++") && valor.matches(numero)) return valueOf(parseDouble(valor) + 1);
		if (operador.equals("--") && valor.matches(numero)) return valueOf(parseDouble(valor) - 1);
		return "";
	}

	public String simplificaUnaria2(String[] unaria) {
		String valor = unaria[1], operador = unaria[0];
		if (operador.equals("++") && valor.matches(numero)) return valueOf(parseDouble(valor) + 1);
		if (operador.equals("--") && valor.matches(numero)) return valueOf(parseDouble(valor) - 1);
		if (operador.equals("nao") | operador.equals("!")) return valor.matches(boleanoFalsidade) ? "verdadeiro" : "falso";
		if (operador.equals("?")) {} ; // Falta implementar
		return "";
	}
}
