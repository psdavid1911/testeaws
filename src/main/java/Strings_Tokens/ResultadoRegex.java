package Strings_Tokens;

public class ResultadoRegex implements Comparable<ResultadoRegex>{
    public String expressao;
    public int posicaoInicial;
    public int tamanho;

    public ResultadoRegex(String expressao, int posicaoInicial, int tamanho){
        this.expressao = expressao;
        this.posicaoInicial = posicaoInicial;
        this.tamanho = tamanho;
    }

    @Override
    public int compareTo(ResultadoRegex o){
        return this.expressao.compareTo(o.expressao);
    }

    @Override
    public String toString(){
        return "\nResultadoRegex{"+"expressao="+expressao+", posicaoInicial="+posicaoInicial+", tamanho="+tamanho+'}';
    }
}
