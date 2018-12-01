package trabFinalPoo;
	
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

import TiposDeDados.Data;

public class Agenda {
	TreeMap<String, Contato> agenda = new TreeMap<>();
	
	public void cadastrar(String nome, String telefone_1, String telefone_2, String email, int dia, int mes, int ano) {
		agenda.put(nome, new Contato(nome, telefone_1, telefone_2, email, dia, mes, ano));
	}
	
	public void exclui(String nome) {
		agenda.remove(nome);
	}
	
	public void altera(String nome, String telefone_1, String telefone_2, String email, int dia, int mes, int ano) {
		cadastrar(nome, telefone_1, telefone_2, email, dia, mes, ano);
	}
	
	public Contato busca(String nome) {
		return agenda.get(nome);
	}
	
	public ArrayList<Entry<String, Contato>> aniversariantesDoMes(int mes, int ano) {
		ArrayList<Entry<String, Contato>> entradas = new ArrayList<>();
		agenda.entrySet().stream().filter(  entrada ->  entrada.getValue().getAniversario().mes() == mes && entrada.getValue().getAniversario().ano() == ano ).forEach( entrada -> entradas.add(entrada));
		return entradas;
	}
	
	public ArrayList<Entry<String, Contato>> aniversariantesDaSemana(int dia, int mes, int ano) {
		ArrayList<Entry<String, Contato>> entradas = new ArrayList<>();
		agenda.entrySet().stream().filter(  entrada ->  entrada.getValue().getAniversario().semana() == new Data(dia, mes, ano).semana() ).forEach( entrada -> entradas.add(entrada));
		return entradas;
	}
	
	public ArrayList<Entry<String,Contato>> aniversariantesDoDia(int dia, int mes) {
		ArrayList<Entry<String, Contato>> entradas = new ArrayList<>();
		agenda.entrySet().stream().filter(  entrada ->  entrada.getValue().getAniversario().mes() == mes && entrada.getValue().getAniversario().dia() == dia).forEach( entrada -> entradas.add(entrada));
		return entradas;
	}
}
