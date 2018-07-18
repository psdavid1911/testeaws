package PM;

import EstruturasDeDados.Lista;
import Tempo.DataHora;
import java.time.LocalDate;
import java.time.Period;

public class Agente implements Comparable<Agente> {

    private int numeral;
    private DataHora ingresso;
    private String nome;
    private String contato;
    private Tipo_de_escala escala;
    private Lista<Servico> servicos;
    
    

    public Integer getNumeral() {
        return numeral;
    }

    public void setNumeral(int numeral) {
        this.numeral = numeral;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Lista<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(Lista<Servico> servicos) {
        this.servicos = servicos;
    }

    public void addServico(Servico servico) {
        this.servicos.adiciona(servico);
    }

    public Tipo_de_escala getEscala() {
        return escala;
    }

    public void setEscala(Tipo_de_escala escala) {
        this.escala = escala;
    }

    public void adicionaServico(Servico servico) {
        if (!servicos.contem(servico))
            servicos.adiciona(servico);
    }

    public void removeServico(Servico servico) {
        servicos.remove(servico);
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public int compareTo(Agente outroAgente) {
        return Integer.compare(numeral, outroAgente.getNumeral());
    }

    // esse método só precisa de 3 testes com o início
    public boolean disponibilidadeDoHorario(DataHora horaInicio, DataHora horaFim) {
        for (Servico servico : servicos)
            if (servico.fim.getHora().isBefore(horaInicio.getHora())); else if (servico.fim.getHora().isAfter(horaInicio.getHora()) && servico.fim.getHora().isBefore(horaFim.getHora()))
                return false;
            else if (servico.inicio.getHora().isAfter(horaInicio.getHora()) && servico.inicio.getHora().isBefore(horaFim.getHora()))
                return false;
            else if (servico.inicio.getHora().isAfter(horaFim.getHora()));
        return true;
    }

    /**
     * Verifica se o agente trabalha no dia informado, caso trabalhe verifica se
     * tem disponível o horário, caso contrario ele nao esta trabalhando
     *
     * @param inicioDeServico
     * @param fimDeServico
     * @param escala
     * @return
     */
    public boolean disponibildiade(DataHora inicioDeServico, DataHora fimDeServico, Tipo_de_escala escala) {
        LocalDate datainicial = inicioDeServico.getHora().toLocalDate();
        LocalDate dataIngresso = this.ingresso.getHora().toLocalDate();
        int momentoDaEscala = Period.between(datainicial, dataIngresso).getDays() % escala.getDias_do_ciclo(); // mudar depois para uma funcao q use a escala generica
        if (momentoDaEscala < escala.getDias_trabalhados())
            return disponibilidadeDoHorario(inicioDeServico, fimDeServico);
        return true;
    }

    @Override
    public String toString() {
        return "\nAgente{" + "numeral=" + numeral + ", ingresso=" + ingresso + ", nome=" + nome + ", contato=" + contato + ", escala=" + escala + ", servicos=" + servicos + '}';
    }

    public DataHora getIngresso() {
        return ingresso;
    }

    public void setIngresso(DataHora ingresso) {
        this.ingresso = ingresso;
    }

}
