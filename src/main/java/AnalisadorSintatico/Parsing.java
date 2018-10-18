package AnalisadorSintatico;

import EstruturasDeDados.Lista;
import Strings_Tokens.Separador;
import java.util.ArrayList;
import java.util.Arrays;

public class Parsing{

    private Boolean comLexico;
    private Lista<String> falha = new Lista<>();
    private ManipuladorGrafo gramatica;
    private ManipuladorGrafo lexico;
    private Lista<String> meta = new Lista<>();
    private Lista<String> procedimento = new Lista<>();

    public Parsing(String caminhoDaGramatica){
        gramatica = new ManipuladorGrafo(caminhoDaGramatica);
        comLexico = false;
    }

    public Parsing(String caminhoDaGramatica, String caminhoDoLexico){
        gramatica = new ManipuladorGrafo(caminhoDaGramatica);
        this.lexico = new ManipuladorGrafo(caminhoDoLexico);
        comLexico = true;
    }

    private Lista<String> automato(Lista<String> estado){
        getProcedimento().add("\n<br>Estado |^|: " + estado);
        if (estado.equals(getMeta()))return getMeta();
        for (Lista<String> transicao : transicoes(estado))
            if (automato(transicao).equals(getMeta())){
                getProcedimento().add("\n<br>Substituição |^|: " + transicao.toString());
                return getMeta();
            }
        return getFalha();
    }

    public Boolean comLexico(){
        return comLexico;
    }

    private String configuraTestaComLexico(String meta, String falha, String original){
        procedimento = new Lista<>();
        Lista<String> conversaoInicial = new Lista<>();
        Lista<String> inicial = Separador.separa(original);
        getProcedimento().add("\n       Inicial: " + inicial.toString());
        for (String palavra : inicial)
            conversaoInicial.add(getLexico().pegaPrimeiraAdjascencia(new Lista<>(Arrays.asList(palavra))));
        this.meta = new Lista<>(Arrays.asList(meta));
        this.falha = new Lista<>(Arrays.asList(falha));
        return automato(conversaoInicial).get(0);
    }

    private String configuraTestaSemLexico(String meta, String falha, String original){
        procedimento = new Lista<>();
        Lista<String> conversaoInicial = new Lista<>();
        Lista<String> inicial = new Lista<>(Arrays.asList(original.split(",")));
        getProcedimento().add("\n       Inicial: " + inicial.toString());
        for (String palavra : inicial)conversaoInicial.add(palavra);
        this.meta = new Lista<>(Arrays.asList(meta));
        this.falha = new Lista<>(Arrays.asList(falha));
        return automato(conversaoInicial).get(0);
    }

    public Lista<String> getFalha(){
        return falha;
    }

    public ManipuladorGrafo getGramatica(){
        return gramatica;
    }

    public ManipuladorGrafo getLexico(){
        return lexico;
    }

    public Lista<String> getMeta(){
        return meta;
    }

    public Lista<String> getProcedimento(){
        return procedimento;
    }

    public void imprime(){
        System.out.println(toString());
    }

    private Lista<String> substitui(Lista<String> valorSubstituido, int indiceInicial, int indiceFinal, Lista<String> lista){
        Lista<String> novaArrayList = new Lista<>();
        novaArrayList.addAll(lista.subList(0, indiceInicial)); // final nao inclusivo
        novaArrayList.addAll(valorSubstituido);
        novaArrayList.addAll(lista.subList(indiceFinal + 1, lista.size())); // inicial não inclusivo, final inclusivo
        return novaArrayList; // Depure nesse ponto para ver as substituições que estão sendo feitas
    }

    public String testa(String meta, String falha, String original){
        return comLexico() ? configuraTestaComLexico(meta, falha, original) : configuraTestaSemLexico(meta, falha, original);
    }

    @Override
    public String toString(){
        StringBuilder b = new StringBuilder(getProcedimento().toString());
        b.deleteCharAt(b.indexOf("["));
        b.deleteCharAt(b.lastIndexOf("]"));
        return b.toString();
    }

    private Lista<Lista<String>> transicoes(Lista<String> estadoInicial){
        Lista<Lista<String>> transicoes = new Lista<>();
        for (int i = 0; i < estadoInicial.size(); i++)
            for (int j = estadoInicial.size() - 1; j >= 0; j--){
                if (i > j)break;
                Lista<String> sublista = new Lista<>(estadoInicial.subList(i, j + 1));
                Lista<Lista<String>> transicaoEncapsulada = getGramatica().pegaAdjascencias(sublista);
                if (transicaoEncapsulada != null && !transicaoEncapsulada.isEmpty()){
                    Lista<String> transicao = transicaoEncapsulada.get(0);
                    if (transicao != null && !transicao.isEmpty())
                        transicoes.add(substitui(transicao, i, j, estadoInicial));
                }
            }
        return transicoes; // DEPURAR AQUI PARA VER ARVORE DE DECISÕES
    }
}
