package PM;
import EstruturasDeDados.Lista;
import Tempo.DataHora;

public class Escalador{

    public Lista<Agente> agentes;

    public Escalador(Lista<Agente> agentes){
        this.agentes=agentes;
    }

    public Lista<Escalacao> criaPosto(String onde,DataHora inicio,DataHora fim,int quantos){
        int contador=0;
        Lista<Escalacao> escala=new Lista<Escalacao>();
        for(Agente policial:agentes)
            if(policial.disponibilidadeDoHorario(inicio,fim)){
                escala.adiciona(Gerar.escalacao(policial.getContato(),inicio,fim,policial.getNome(),onde));
                agentes.pega(policial).adicionaServico(Gerar.servico(inicio,fim,onde));
                if(++contador>=quantos)
                    return escala;
            }
        return escala;
    }

    public Lista<Escalacao> criaEscala(String onde,DataHora inicio,DataHora fim,Lista<String> postos){
        Lista<Escalacao> escala=new Lista<Escalacao>();
        for(String posto:postos)
            escala.adicionaTodos(criaPosto(onde,inicio,fim,2));
        return escala;
    }
}
