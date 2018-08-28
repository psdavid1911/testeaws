package AnalisadorSintatico;

import EstruturasDeDados.Lista;
import Strings_Tokens.Separador;

public class Parsing{

    public Lista<String> falha=new Lista<String>();
    public ManipuladorGrafo gramatica;
    public ManipuladorGrafo lexico;
    public Lista<String> meta=new Lista<String>();
    public Lista<String> procedimento;

    public Parsing(String caminhoDaGramatica){
        gramatica=new ManipuladorGrafo(caminhoDaGramatica);
    }

    public Parsing(String caminhoDaGramatica, String caminhoDoLexico){
        gramatica=new ManipuladorGrafo(caminhoDaGramatica);
        this.lexico=new ManipuladorGrafo(caminhoDoLexico);
    }

    public String configuraTesta(String meta, String falha, String original){
        procedimento=new Lista<String>();
        Lista<String> conversaoInicial=new Lista<String>();
        Lista<String> inicial=Separador.separa(original);
        procedimento.add("\n       Inicial: "+inicial.toString());
        for(String palavra:inicial)conversaoInicial.add(lexico.pegaPrimeiraAdjascencia(new Lista<String>(palavra)));
        this.meta=new Lista<String>(meta);
        this.falha=new Lista<String>(falha);
        return automato(conversaoInicial).get(0);
    }

    public void imprime(){
        System.out.println(toString());
    }

    @Override
    public String toString(){
        StringBuilder b=new StringBuilder(procedimento.toString());
        b.deleteCharAt(b.indexOf("["));
        b.deleteCharAt(b.lastIndexOf("]"));
        return b.toString();
    }

    private Lista<String> automato(Lista<String> estado){
        procedimento.add("\n<br>Estado |^|: "+estado);
        if(estado.equals(meta))return meta;
        for(Lista<String> transicao:transicoes(estado))
            if(automato(transicao).equals(meta)){
                procedimento.add("\n<br>Substituição |^|: "+transicao.toString());
                return meta;
            } //procedimento.add("\n<br>Não-Substituição |^|: "+transicao.toString());
        return falha;
    }

    private Lista<String> substitui(Lista<String> valorSubstituido, int indiceInicial, int indiceFinal, Lista<String> lista){
        Lista<String> novaLista=new Lista<String>();
        novaLista.addAll(lista.subList(0, indiceInicial)); // final nao inclusivo
        novaLista.addAll(valorSubstituido);
        novaLista.addAll(lista.subList(indiceFinal+1, lista.size())); // inicial não inclusivo, final inclusivo
        return novaLista; // Depure nesse ponto para ver as substituições que estão sendo feitas
    }

    private Lista<Lista<String>> transicoes(Lista<String> estadoInicial){
        Lista<Lista<String>> transicoes=new Lista<Lista<String>>();
        for(int i=0; i<estadoInicial.size(); i++)
            for(int j=estadoInicial.size()-1; j>=0; j--){
                if(i>j)break;
                Lista<String> sublista=estadoInicial.subLista(i, j+1);
                Lista<Lista<String>> transicaoEncapsulada=gramatica.pegaAdjascencias(sublista);
                if(transicaoEncapsulada!=null&&!transicaoEncapsulada.isEmpty()){
                    Lista<String> transicao=transicaoEncapsulada.get(0);
                    if(transicao!=null&&!transicao.isEmpty())
                        transicoes.add(substitui(transicao, i, j, estadoInicial));
                }
            }
        return transicoes; // DEPURAR AQUI PARA VER ARVORE DE DECISÕES
    }
}
