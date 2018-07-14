package PM;

import EstruturasDeDados.ListaAntiga;
import Tempo.DataHora;

public class Escalador {

    ListaAntiga<Agente> agentes;

    public Escalador(ListaAntiga<Agente> agentes) {
        this.agentes = agentes;
    }

    ListaAntiga<Escalacao> criaPosto(String onde, DataHora inicio, DataHora fim, int quantos) {
        int contador = 0;
        ListaAntiga<Escalacao> escala = new ListaAntiga<Escalacao>();

        for (Agente policial : agentes) {
            if (policial.disponibilidadeDoHorario(inicio, fim)) {
                escala.adiciona(Gerar.escalacao(policial.getContato(), inicio, fim, policial.getNome(), onde));
                agentes.pega(policial).adicionaServico(Gerar.servico(inicio, fim, onde));
                if (++contador >= quantos) {
                    return escala;
                }
            }
        }
        return escala;
    }
    
    ListaAntiga<Escalacao> criaEscala(String onde, DataHora inicio, DataHora fim, ListaAntiga<String> postos){
        ListaAntiga<Escalacao> escala = new ListaAntiga<Escalacao>();
        for(String posto: postos){
            escala.adicionaTodos(criaPosto(onde, inicio, fim, 2));
        }
        return escala;
    }
}
