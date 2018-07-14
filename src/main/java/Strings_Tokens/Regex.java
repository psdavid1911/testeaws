package Strings_Tokens;

import EstruturasDeDados.ListaAntiga;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex{
    private Matcher sentenca;
    private Pattern padrao;
    public ListaAntiga<ResultadoRegex> l = new ListaAntiga<ResultadoRegex>();

    public Regex(String sentenca, String expressaoDeBusca){
        this.padrao = Pattern.compile(expressaoDeBusca);
        this.sentenca = this.padrao.matcher(sentenca);
        resultados();
    }

    private void resultados(){
        while(sentenca.find())
            l.adiciona(new ResultadoRegex(sentenca.group(), sentenca.start(), sentenca.end()));
    }

    public void imprimeResultados(){
        System.out.println(l.toString());
    }
}
