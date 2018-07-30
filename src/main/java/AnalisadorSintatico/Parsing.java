package AnalisadorSintatico;
import EstruturasDeDados.Grafo;
import EstruturasDeDados.Lista;
import java.util.HashMap;

public class Parsing{

    public Lista<String> procedimento=new Lista<String>();
    public HashMap<String,String> lexico;
    public Grafo<Lista<String>> gramatica;
    public Lista<String> meta, falha;

    public Parsing(String caminhoDoLexico,String caminhoDaGramatica){
        lexico=Lexico.novoLexico(caminhoDoLexico);
        gramatica=Gramatica.pegaGramatica(caminhoDaGramatica);
    }

    public Lista<String> configuraTesta(String meta,String falha,Lista<String> tokens){
        this.meta=new Lista<String>(meta);
        this.falha=new Lista<String>(falha);
        return automato(tokens);
    }

    private Lista<String> automato(Lista<String> estado){
        if(estado.equals(meta))return meta;
        for(Lista<String> transicao:transicoes(estado))
            if(automato(transicao).equals(meta)){
                procedimento.add("<br>Substituição |^|: "+transicao.toString());
                return meta;
            }
        return falha;
    }

    private Lista<Lista<String>> transicoes(Lista<String> estadoInicial){
        Lista<Lista<String>> transicoes=new Lista<Lista<String>>();
        for(int i=0;i<estadoInicial.size();i++)
            for(int j=estadoInicial.size()-1;j>=0;j--) {
                if(i>j)break;
                Lista<String> sublista=estadoInicial.subLista(i,j+1);
                Lista<Lista<String>> transicaoEncapsulada=gramatica.pegaAdjascentes(sublista);
                if(transicaoEncapsulada!=null&&!transicaoEncapsulada.isEmpty()){
                    Lista<String> transicao=transicaoEncapsulada.get(0);
                    if(transicao!=null&&!transicao.isEmpty())
                        transicoes.add(substitui(transicao,i,j,estadoInicial));
                }
            }
        return transicoes; // DEPURAR AQUI PARA VER ARVORE DE DECISÕES
    }

    private Lista<String> substitui(Lista<String> valorSubstituido,int indiceInicial,int indiceFinal,Lista<String> lista){
        Lista<String> novaLista=new Lista<String>();
        novaLista.addAll(lista.subList(0,indiceInicial)); // final nao inclusivo
        novaLista.addAll(valorSubstituido);
        novaLista.addAll(lista.subList(indiceFinal+1,lista.size())); // inicial não inclusivo, final inclusivo
        return novaLista; // Depure nesse ponto para ver as substituições que estão sendo feitas
    }
}
