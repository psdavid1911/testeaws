package Strings_Tokens;
import EstruturasDeDados.Lista;
import Internet.PaginaHTML;

public class LeitorFormatado{

    /**
     * Abstrai que o arquivo esta no formato CSV e encara a primeira linha como
     * cabeçalho
     *
     * @param arquivoWeb
     * @return 
     */
    public EstruturasDeDados.Lista<String> LeitorFormatado(String arquivoWeb){
        EstruturasDeDados.Lista<String> linhasDoDocumento=PaginaHTML.pegaURL(arquivoWeb);
        EstruturasDeDados.Lista<String> linhasEditadas=new Lista<String>();
        for(String linha:linhasDoDocumento) linhasEditadas.adiciona(RemoverdorDeEspacos.duplosParaSimples(linha));
        return linhasEditadas;
    }
}
