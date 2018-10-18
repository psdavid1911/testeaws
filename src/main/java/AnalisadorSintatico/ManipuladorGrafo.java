package AnalisadorSintatico;

import EstruturasDeDados.Grafo;
import EstruturasDeDados.Lista;
import FluxoDeArquivos.FluxoDeTexto;
import Internet.PaginaHTML;
import java.util.ArrayList;
import java.util.Arrays;

public class ManipuladorGrafo{

    private Lista<String> arquivo = new Lista<>();
    private Grafo<Lista<String>> grafo = new Grafo<>();
    private final String uriArquivo;

    public ManipuladorGrafo(String caminhoDoArquivo){
        this.uriArquivo = caminhoDoArquivo;
        for (String linha : PaginaHTML.pegaURL(caminhoDoArquivo)){
            linha = linha.replaceAll(" -> ", "->");
            linha = linha.replaceAll(" ->", "->");
            linha = linha.replaceAll("-> ", "->");
            linha = linha.replaceAll(" , ", ",");
            linha = linha.replaceAll(", ", ",");
            linha = linha.replaceAll(" ,", ",");
            arquivo.add(linha);
            String[] argumentos = linha.split("->");
            for (int i = 1; i < argumentos.length; i++)
                grafo.adicionaAresta(
                        new Lista<>(Arrays.asList(argumentos[0].split(","))),
                        new Lista<>(Arrays.asList(argumentos[i].split(",")))
                );
        }
    }

    public Lista<String> getArquivo(){
        return arquivo;
    }

    public String getCaminhoDoArquivo(){
        return uriArquivo;
    }

    public Grafo<Lista<String>> getGrafo(){
        return grafo;
    }

    public void inverteMembros(){
        Lista<String> nova = new Lista<>();
        FluxoDeTexto manipulador = new FluxoDeTexto(uriArquivo);
        for (String linha : arquivo){
            String[] argumentos = linha.split("->");
            nova.add(linha = argumentos[argumentos.length - 1] + "->" + argumentos[0]);
        }
        manipulador.escreve(nova);
    }

    public Lista<Lista<String>> pegaAdjascencias(Lista<String> no){
        return grafo.adjascencias(no);
    }

    public String pegaPrimeiraAdjascencia(Lista<String> no){
        try{
            return grafo.adjascencias(no).get(0).get(0);
        } catch (NullPointerException ex){
            System.out.print("\nNão encontrei: " + no.toString());
            return "";
        }
    }

    @Override
    public String toString(){
        return grafo.toString();
    }
}
