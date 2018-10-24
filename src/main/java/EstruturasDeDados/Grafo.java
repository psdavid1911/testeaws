package EstruturasDeDados;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class Grafo<TIPO extends Comparable<TIPO>> extends TreeMap<TIPO, Lista<TIPO>> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6987041211334230258L;

	public void adicionaAresta(TIPO vertice, TIPO adjascencia) {
		adicionaVertice(vertice);
		adicionaVertice(adjascencia);
		if (!existeAresta(vertice, adjascencia)) adjascencias(vertice).add(adjascencia);
	}

	public void adicionaVertice(TIPO vertice) {
		if (!containsKey(vertice)) put(vertice, new Lista<>());
	}

	public Lista<TIPO> adjascencias(TIPO vertice) {
		return get(vertice);
	}

	public void apaga(TIPO elemento) {
		remove(elemento);
		entrySet().forEach(entrada -> entrada.getValue().remove(elemento));
	}

	public Set<Entry<TIPO, Lista<TIPO>>> conjunto() {
		return entrySet();
	}

	public boolean existeAresta(TIPO vertice, TIPO adjascente) {
		return containsKey(vertice) ? adjascencias(vertice).contains(adjascente) : false;
	}

	public boolean existeVertice(TIPO vertice) {
		return containsKey(vertice);
	}

	public void imprime(int tamanhoDaChave) {
		System.out.printf("%-" + tamanhoDaChave + "s |   %s \n\n", "VERTICE", "VERTICES DE DESTINO");
		for(Map.Entry<TIPO, Lista<TIPO>> entrada : entrySet()) {
			TIPO        chave = entrada.getKey();
			Lista<TIPO> lista = entrada.getValue();
			System.out.printf("%-" + tamanhoDaChave + "s |   %s \n", chave, lista.toString());
		}
		System.out.println("");
	}

	public int numeroSaidas(TIPO vertice) {
		return adjascencias(vertice).size();
	}

	public Entry<TIPO, Lista<TIPO>> pegaElementoAleatorio() {
		ArrayList<Entry<TIPO, Lista<TIPO>>> indexados = new ArrayList<>(entrySet()); // NAO UTILIZAR LISTA AQUI!
		return indexados.get(new Random().nextInt(entrySet().size()));
	}

	public Conjunto<TIPO> pegaNaoAdjascentes(TIPO conteudo) {
		Conjunto<TIPO> conjunto = new Conjunto<>();
		for(Entry<TIPO, Lista<TIPO>> entrada : entrySet()) conjunto.add(entrada.getKey());
		conjunto.removeAll(adjascencias(conteudo));
		return conjunto;
	}

	public TIPO pegaVerticeMaisRamos() {
		TIPO vertice = pegaElementoAleatorio().getKey();
		for(Entry<TIPO, Lista<TIPO>> elemento : entrySet()) if (elemento.getValue().size() > adjascencias(vertice).size()) vertice = elemento.getKey();
		return vertice;
	}

	@Override public String toString() {
		String s = "";
		for(Entry<TIPO, Lista<TIPO>> par : entrySet()) {
			s += par.getKey().toString();
			s += "      ";
			s += par.getValue().toString();
			s += "\n";
		}
		return s;
	}
}
