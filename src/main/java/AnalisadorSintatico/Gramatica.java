package AnalisadorSintatico;
import EstruturasDeDados.Grafo;
import EstruturasDeDados.Lista;
import Internet.PaginaHTML;
import java.util.Arrays;
public class Gramatica{

    public static String consertaFormatacao(String cadeia){
        cadeia=cadeia.replaceAll(" -> ","->");
        cadeia=cadeia.replaceAll(" ->","->");
        cadeia=cadeia.replaceAll("-> ","->");
        cadeia=cadeia.replaceAll(" , ",",");
        cadeia=cadeia.replaceAll(", ",",");
        cadeia=cadeia.replaceAll(" ,",",");
        return cadeia;
    }

    public static Grafo<Lista<String>> pegaGramatica(){
        Grafo<Lista<String>> g=new Grafo<Lista<String>>();
        Lista<String> arquivo=PaginaHTML.pegaURL("http://18.228.55.248/Arquivos/gramatica.txt");
        System.out.println(arquivo.toString());
        for(String linha:arquivo) {
            linha=consertaFormatacao(linha);
            String argumentos[]=linha.split("->");
            g.adicionaAresta(new Lista(Arrays.asList(argumentos[0].split(","))),new Lista(Arrays.asList(argumentos[1].split(","))));
        }
        return g;
    }
}
