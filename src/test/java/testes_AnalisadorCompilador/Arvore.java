package testes_AnalisadorCompilador;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Arvore {
	private ArrayList<Arvore> nos = new ArrayList<>();
	private String            no  = null;

	Arvore() {}

	Arvore(String no) {
		this.no = no;
	}

	Arvore(String no, ArrayList<Arvore> arestas) {
		this.no  = no;
		this.nos = arestas;
	}

	public void setConteudo(String novoNo) {
		this.no = novoNo;
	}

	public ArrayList<Arvore> getNos() {
		return nos;
	}

	public void setNos(ArrayList<Arvore> novasArestas) {
		nos = novasArestas;
	}

	public Arvore addPai(String conteudo, Arvore g) {
		Arvore pai = new Arvore(conteudo);
		pai.addRamo(pai, g);
		Logger.getGlobal().log(Level.INFO, "Arvore:: " + pai);
		return pai;
	}

	public void addRamo(Arvore grafo, Arvore ramificacoes) {
		grafo.nos.add(ramificacoes);
	}

	public void addNovoFilho(String filho) {
		nos.add(new Arvore(filho));
	}

	public Arvore remAdjascencia(int indice) {
		if (indice > -1 && indice < nos.size()) return nos.remove(indice);
		return null;
	}

	public void novo(String novoNo) {
		no  = novoNo;
		nos = new ArrayList<>();
	}

	public String getConteudo() {
		return no;
	}

	public Arvore getAdjascencia(int i) {
		return nos.get(i);
	}

	@Override public String toString() {
		return no + "" + nos;
	}

	public void imprime() {
		System.out.println(this);
	}
}
