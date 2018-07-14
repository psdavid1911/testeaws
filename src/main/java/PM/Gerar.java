package PM;

import EstruturasDeDados.ListaAntiga;
import Tempo.DataHora;
import java.time.Month;

public class Gerar {

    static Servico servico(DataHora inicio, DataHora fim, String posto) {
        Servico servico = new Servico();
        servico.setInicio(inicio);
        servico.setFim(fim);
        servico.setPosto(posto);
        return servico;
    }

    static Agente agente(String contato, Tipo_de_escala escala, String nome, int numeral, ListaAntiga<Servico> servicos, String ingresso) {
        Agente agente = new Agente();
        agente.setContato(contato);
        agente.setEscala(escala);
        agente.setNome(nome);
        agente.setNumeral(numeral);
        agente.setServicos(servicos);
        agente.setIngresso(new DataHora(1, Month.JANUARY, 2018, 0, 0));
        return agente;
    }

    static Escalacao escalacao(String contato, DataHora horaInicial, DataHora horaFinal, String pm, String posto) {
        Escalacao escalacao = new Escalacao();
        escalacao.setContato(contato);
        escalacao.setHoraFinal(horaFinal);
        escalacao.setHoraInicial(horaInicial);
        escalacao.setPm(pm);
        escalacao.setPosto(posto);
        return escalacao;
    }

    static Tipo_de_escala tipo_de_escala(int dias_trabalhados, int dias_descansados) {
        Tipo_de_escala t = new Tipo_de_escala();
        t.setDias_trabalhados(dias_trabalhados);
        t.setDias_descansados(dias_descansados);
        return t;
    }
}
