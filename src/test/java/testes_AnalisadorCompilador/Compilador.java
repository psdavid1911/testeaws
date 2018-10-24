package testes_AnalisadorCompilador;

import static testes_AnalisadorCompilador.Compilador.TipoDeElementoDeLinguagem.OPERADOR;
import static testes_AnalisadorCompilador.Compilador.TipoDeElementoDeLinguagem.VARIAVEL;
import static testes_AnalisadorCompilador.Compilador.TipoDePrimitivo.BOLEANO;
import static testes_AnalisadorCompilador.Compilador.TipoDePrimitivo.NUMERO;
import static testes_AnalisadorCompilador.Compilador.TipoDePrimitivo.PALAVRA;

import java.util.ArrayList;
import java.util.TreeMap;

public class Compilador {
	int                     idVariaveis      = 0;
	int                     numeracaoDeLinha = 0;
	TreeMap<String, Object> variaveis        = new TreeMap<String, Object>();

	public void compilador(String... opcoesDoPrompt) throws Exception {
		String            uriFonte      = opcoesDoPrompt[0];
		ArrayList<String> programaFonte = Internet.PaginaHTML.pegaURL(uriFonte);
		// ArrayList<String> programaObjeto = new ArrayList<>();
		for(String linha : programaFonte) { // Percorre todas as instruções de um programa fonte
			++numeracaoDeLinha;
			if (linha.contains("recebe")); // nao implementado ainda
			else if (linha.matches("se \\w*")) se(linha);
			else if (linha.matches("senao \\w*")) return;
			else if (linha.matches("enquanto \\w*")) return;
			else if (linha.matches("pare \\w*")) return;
			else if (linha.matches("continue \\w*")) return;
			else if (linha.matches("\\s*//")); // ignora linhas com comentários
			else if (linha.matches("\\s*")); // ignora linhas vazias. ignora conteudo identado também ?
			else throw new Error("Não há um comando válido na linha " + numeracaoDeLinha);
		}
	}

	private void se(String linha) {
		String[] palavra = linha.split(" ");
		// Grafo<String> expressao = new Grafo<>(); // Cria arvore de expressoes, seja
		// ela n-ária
		for(int i = 0; i < palavra.length; i++) {}
	}

	public enum TipoDePrimitivo {
		BOLEANO, PALAVRA, NUMERO;
	}

	public enum TipoDeElementoDeLinguagem {
		VARIAVEL, VALOR, OPERADOR;
	}

	public class Boleano extends Primitivo {
		Boolean boleano;

		public Boleano(Boolean boleano) {
			super(BOLEANO);
			this.boleano = boleano;
		}
	}

	public class ElementoDeLinguagem {
		TipoDeElementoDeLinguagem elemento;

		public ElementoDeLinguagem(TipoDeElementoDeLinguagem elemento) {
			this.elemento = elemento;
		}
	}

	public class Numero extends Primitivo {
		Double numero;

		public Numero(Double numero) {
			super(NUMERO);
			this.numero = numero;
		}
	}

	public class Operador extends ElementoDeLinguagem {
		String simbolo;

		public Operador(String simbolo) {
			super(OPERADOR);
			this.simbolo = simbolo;
		}
	}

	public class Palavra extends Primitivo {
		String palavra;

		public Palavra(String palavra) {
			super(PALAVRA);
			this.palavra = palavra;
		}
	}

	public class Primitivo extends ElementoDeLinguagem {
		TipoDePrimitivo tipo;

		public Primitivo(TipoDePrimitivo tipo) {
			super(VARIAVEL);
			this.tipo = tipo;
		}
	}
}
