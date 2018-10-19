package AnalisadorSintatico;

import EstruturasDeDados.Grafo;
import EstruturasDeDados.Lista;
import FluxoDeArquivos.FluxoDeTexto;
import Internet.PaginaHTML;
import java.util.Arrays;

public class ManipuladorGrafo{

    private Lista<String> arquivo = new Lista<>();
    private Grafo<Lista<String>> grafo = new Grafo<>();
    private final String uriArquivo;

    public ManipuladorGrafo(String caminhoDoArquivo){
        this.uriArquivo = caminhoDoArquivo;
        for (String linha : PaginaHTML.pegaURL(caminhoDoArquivo)){
            // Inicia formatacao do que foi lido
            if (linha.contains("//"))linha = linha.substring(0, linha.indexOf("//")); // deve ser feito antes, pois pode retornar linha vazia, ignora comentarios de linha
            if (linha.isEmpty())continue; // linha vazia ignora
            linha = linha.replaceAll("\\s*,\\s*", ","); // remove espacos circundantes de uma virgula
            linha = linha.replaceAll("\\s+", " "); // remove espacos sobressalentes em qualquer lugar
            arquivo.add(linha); // salva a formatacao

            // Inicia a criacao do grafo
            Lista<String> aEsquerda, aDireita;
            if (linha.contains("<->")){
                linha = linha.replaceAll("\\s*<->\\s*", "<->"); // remove espacos circundantes ao operador
                String[] argumentos = linha.split("<->");
                aEsquerda = new Lista<>(Arrays.asList(argumentos[0].split(",")));
                aDireita = new Lista<>(Arrays.asList(argumentos[1].split(",")));
                grafo.adicionaAresta(aEsquerda, aDireita);
                grafo.adicionaAresta(aDireita, aEsquerda);
            } else if (linha.contains("->")){
                linha = linha.replaceAll("\\s*->\\s*", "->"); // remove espacos circundantes ao operador
                String[] argumentos = linha.split("->");
                aEsquerda = new Lista<>(Arrays.asList(argumentos[0].split(",")));
                aDireita = new Lista<>(Arrays.asList(argumentos[1].split(",")));
                grafo.adicionaAresta(aEsquerda, aDireita);
            }
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
