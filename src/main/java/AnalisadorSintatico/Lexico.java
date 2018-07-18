package AnalisadorSintatico;
import EstruturasDeDados.Lista;
import Internet.PaginaHTML;
import java.util.HashMap;

public class Lexico{

    public static String consertaFormatacao(String cadeia){
        cadeia=cadeia.replaceAll(" -> ","->");
        cadeia=cadeia.replaceAll(" ->","->");
        cadeia=cadeia.replaceAll("-> ","->");
        return cadeia;
    }

    public static HashMap<String,String> novoLexico(){
        HashMap<String,String> lexico=new HashMap<String,String>();
        Lista<String> arquivo=PaginaHTML.pegaURL("http://18.228.55.248/Arquivos/lexico.txt");
        System.out.println(arquivo);
        for(String linha:arquivo) {
            linha=consertaFormatacao(linha);
            String argumentos[]=linha.split("->");
            System.out.println(argumentos[1]+" "+argumentos[0]);
            lexico.put(argumentos[1],argumentos[0]);
        }
        System.out.println(lexico.toString());
        return lexico;
    }
}
