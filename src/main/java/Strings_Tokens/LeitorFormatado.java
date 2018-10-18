package Strings_Tokens;

import EstruturasDeDados.Lista;
import Internet.PaginaHTML;
import java.util.ArrayList;

public class LeitorFormatado{

    /**
     * Abstrai que o arquivo esta no formato CSV e encara a primeira linha como
     * cabeçalho
     *
     * @param arquivoWeb
     * @return
     */
    public ArrayList<String> LeitorFormatado(String arquivoWeb){
        ArrayList<String> linhasDoDocumento = PaginaHTML.pegaURL(arquivoWeb);
        ArrayList<String> linhasEditadas = new Lista<String>();
        for (String linha : linhasDoDocumento)linhasEditadas.add(RemoverdorDeEspacos.duplosParaSimples(linha));
        return linhasEditadas;
    }
}
