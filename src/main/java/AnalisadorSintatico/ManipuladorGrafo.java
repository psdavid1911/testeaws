package AnalisadorSintatico;

import EstruturasDeDados.Grafo;
import EstruturasDeDados.Lista;
import FluxoDeArquivos.FluxoDeTexto;
import Internet.PaginaHTML;

public class ManipuladorGrafo{

    private Lista<String> arquivo=new Lista<String>();
    private final String caminhoDoArquivo;
    private Grafo<Lista<String>> grafo=new Grafo<Lista<String>>();

    public ManipuladorGrafo(String caminhoDoArquivo){
        this.caminhoDoArquivo=caminhoDoArquivo;
        for(String linha:PaginaHTML.pegaURL(caminhoDoArquivo)){
            linha=linha.replaceAll(" -> ", "->");
            linha=linha.replaceAll(" ->", "->");
            linha=linha.replaceAll("-> ", "->");
            linha=linha.replaceAll(" , ", ",");
            linha=linha.replaceAll(", ", ",");
            linha=linha.replaceAll(" ,", ",");
            arquivo.add(linha);
            String[] argumentos=linha.split("->");
            for(int i=1; i<argumentos.length; i++)
                grafo.adicionaAresta(new Lista<String>(argumentos[0].split(",")), new Lista<String>(argumentos[i].split(",")));
        }
    }

    public Lista<String> getArquivo(){
        return arquivo;
    }

    public String getCaminhoDoArquivo(){
        return caminhoDoArquivo;
    }

    public Grafo<Lista<String>> getGrafo(){
        return grafo;
    }

    public void inverteMembros(){
        Lista<String> nova=new Lista<String>();
        FluxoDeTexto manipulador=new FluxoDeTexto(caminhoDoArquivo);
        for(String linha:arquivo){
            String[] argumentos=linha.split("->");
            nova.add(linha=argumentos[argumentos.length-1]+"->"+argumentos[0]);
        }
        manipulador.escreve(nova);
    }

    public Lista<Lista<String>> pegaAdjascencias(Lista<String> no){
        return grafo.pegaAdjascentes(no);
    }

    public String pegaPrimeiraAdjascencia(Lista<String> no){
        try{
            return grafo.pegaAdjascentes(no).pega(0).pega(0);
        }catch(NullPointerException ex){
            System.out.print("\nNão encontrei: "+no.toString());
            return "";
        }
    }

    @Override
    public String toString(){
        return grafo.toString();
    }
}
