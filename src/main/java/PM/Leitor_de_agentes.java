package PM;

import EstruturasDeDados.Lista;
import Internet.PaginaHTML;

public class Leitor_de_agentes{

    public static String consertaFormatacao(String cadeia){
        cadeia=cadeia.replaceAll("  ", "");
        cadeia=cadeia.replaceAll(" ; ", ";");
        cadeia=cadeia.replaceAll("; ", ";");
        cadeia=cadeia.replaceAll(" ;", ";");
        return cadeia;
    }

    public Leitor_de_agentes(String URL_dos_agentes){
        Lista<String> linhasDoArquivo=PaginaHTML.pegaURL(URL_dos_agentes);
        for(String linha:linhasDoArquivo){
            String v[]=consertaFormatacao(linha).split(";");
            AgenteAntigo agente=new AgenteAntigo();
        }
    }
}
