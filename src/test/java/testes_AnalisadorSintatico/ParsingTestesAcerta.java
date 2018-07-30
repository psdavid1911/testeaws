package testes_AnalisadorSintatico;
import AnalisadorSintatico.Parsing;
import AnalisadorSintatico.Separador;
import EstruturasDeDados.Lista;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Não são usadas maiúsculas nos testes
 *
 * @author david
 */
public class ParsingTestesAcerta{

    public Parsing analisador=new Parsing("http://localhost:8080/arquivos/lexico.txt","http://localhost:8080/arquivos/gramatica.txt");

    @Test public void teste001(){
        Lista<String> conversaoInicial=new Lista<String>();
        String original="eu estudo português às segundas-feiras";
        System.out.printf("\n%-20s[%s]","Original:",original);
        for(String palavra:Separador.separa(original)) conversaoInicial.add(analisador.lexico.get(palavra));
        assertEquals("[Período]",new Parsing("http://localhost:8080/arquivos/lexico.txt","http://localhost:8080/arquivos/gramatica.txt").configuraTesta("Período","Agramatical",conversaoInicial).toString());
        conversaoInicial.clear();
        System.out.println();
    }

    @Test public void teste002(){
        Lista<String> conversaoInicial=new Lista<String>();
        String original="eu estudo português";
        System.out.printf("\n%-20s[%s]","Original:",original);
        for(String palavra:Separador.separa(original)) conversaoInicial.add(analisador.lexico.get(palavra));
        assertEquals("[Período]",new Parsing("http://localhost:8080/arquivos/lexico.txt","http://localhost:8080/arquivos/gramatica.txt").configuraTesta("Período","Agramatical",conversaoInicial).toString());
        conversaoInicial.clear();
        System.out.println();
    }

    @Test public void teste003(){
        Lista<String> conversaoInicial=new Lista<String>();
        String original="eu estudo";
        System.out.printf("\n%-20s[%s]","Original:",original);
        for(String palavra:Separador.separa(original)) conversaoInicial.add(analisador.lexico.get(palavra));
        assertEquals("[Período]",new Parsing("http://localhost:8080/arquivos/lexico.txt","http://localhost:8080/arquivos/gramatica.txt").configuraTesta("Período","Agramatical",conversaoInicial).toString());
        conversaoInicial.clear();
        System.out.println();
    }

    @Test public void teste004(){
        Lista<String> conversaoInicial=new Lista<String>();
        String original="estudo";
        System.out.printf("\n%-20s[%s]","Original:",original);
        for(String palavra:Separador.separa(original)) conversaoInicial.add(analisador.lexico.get(palavra));
        assertEquals("[Período]",new Parsing("http://localhost:8080/arquivos/lexico.txt","http://localhost:8080/arquivos/gramatica.txt").configuraTesta("Período","Agramatical",conversaoInicial).toString());
        conversaoInicial.clear();
        System.out.println();
    }

    @Test public void teste005(){
        Lista<String> conversaoInicial=new Lista<String>();
        String original="os homens desejam paz";
        System.out.printf("\n%-20s[%s]","Original:",original);
        for(String palavra:Separador.separa(original)) conversaoInicial.add(analisador.lexico.get(palavra));
        assertEquals("[Período]",new Parsing("http://localhost:8080/arquivos/lexico.txt","http://localhost:8080/arquivos/gramatica.txt").configuraTesta("Período","Agramatical",conversaoInicial).toString());
        conversaoInicial.clear();
        System.out.println();
    }

    @Test public void teste006(){
        Lista<String> conversaoInicial=new Lista<String>();
        String original="eu trabalho como professor";
        System.out.printf("\n%-20s[%s]","Original:",original);
        for(String palavra:Separador.separa(original)) conversaoInicial.add(analisador.lexico.get(palavra));
        assertEquals("[Período]",new Parsing("http://localhost:8080/arquivos/lexico.txt","http://localhost:8080/arquivos/gramatica.txt").configuraTesta("Período","Agramatical",conversaoInicial).toString());
        conversaoInicial.clear();
        System.out.println();
    }

    @Test public void teste007(){
        Lista<String> conversaoInicial=new Lista<String>();
        String original="muitas crianças viram os pássaros";
        System.out.printf("\n%-20s[%s]","Original:",original);
        for(String palavra:Separador.separa(original)) conversaoInicial.add(analisador.lexico.get(palavra));
        assertEquals("[Período]",new Parsing("http://localhost:8080/arquivos/lexico.txt","http://localhost:8080/arquivos/gramatica.txt").configuraTesta("Período","Agramatical",conversaoInicial).toString());
        conversaoInicial.clear();
        System.out.println();
    }

    @Test public void teste008(){
        Lista<String> conversaoInicial=new Lista<String>();
        String original="o bom filho compreende o esforço dos pais";
        System.out.printf("\n%-20s[%s]","Original:",original);
        for(String palavra:Separador.separa(original)) conversaoInicial.add(analisador.lexico.get(palavra));
        assertEquals("[Período]",new Parsing("http://localhost:8080/arquivos/lexico.txt","http://localhost:8080/arquivos/gramatica.txt").configuraTesta("Período","Agramatical",conversaoInicial).toString());
        conversaoInicial.clear();
        System.out.println();
    }

    @Test public void teste009(){
        Lista<String> conversaoInicial=new Lista<String>();
        String original="joão escreveu uma bela redação";
        System.out.printf("\n%-20s[%s]","Original:",original);
        for(String palavra:Separador.separa(original)) conversaoInicial.add(analisador.lexico.get(palavra));
        assertEquals("[Período]",new Parsing("http://localhost:8080/arquivos/lexico.txt","http://localhost:8080/arquivos/gramatica.txt").configuraTesta("Período","Agramatical",conversaoInicial).toString());
        conversaoInicial.clear();
        System.out.println();
    }

    @Test public void teste010(){
        Lista<String> conversaoInicial=new Lista<String>();
        String original="o livro está esgotado";
        System.out.printf("\n%-20s[%s]","Original:",original);
        for(String palavra:Separador.separa(original)) conversaoInicial.add(analisador.lexico.get(palavra));
        assertEquals("[Período]",new Parsing("http://localhost:8080/arquivos/lexico.txt","http://localhost:8080/arquivos/gramatica.txt").configuraTesta("Período","Agramatical",conversaoInicial).toString());
        conversaoInicial.clear();
        System.out.println();
    }

    @Test public void teste011(){
        Lista<String> conversaoInicial=new Lista<String>();
        String original="esta manhã prometia chuva";
        System.out.printf("\n%-20s[%s]","Original:",original);
        for(String palavra:Separador.separa(original)) conversaoInicial.add(analisador.lexico.get(palavra));
        assertEquals("[Período]",new Parsing("http://localhost:8080/arquivos/lexico.txt","http://localhost:8080/arquivos/gramatica.txt").configuraTesta("Período","Agramatical",conversaoInicial).toString());
        conversaoInicial.clear();
        System.out.println();
    }

    @Test public void teste012(){
        Lista<String> conversaoInicial=new Lista<String>();
        String original="todos os alunos saíram";
        System.out.printf("\n%-20s[%s]","Original:",original);
        for(String palavra:Separador.separa(original)) conversaoInicial.add(analisador.lexico.get(palavra));
        assertEquals("[Período]",new Parsing("http://localhost:8080/arquivos/lexico.txt","http://localhost:8080/arquivos/gramatica.txt").configuraTesta("Período","Agramatical",conversaoInicial).toString());
        conversaoInicial.clear();
        System.out.println();
    }

    @Test public void teste013(){
        Lista<String> conversaoInicial=new Lista<String>();
        String original="alguns de nós não foram à festa";
        System.out.printf("\n%-20s[%s]","Original:",original);
        for(String palavra:Separador.separa(original)) conversaoInicial.add(analisador.lexico.get(palavra));
        assertEquals("[Período]",new Parsing("http://localhost:8080/arquivos/lexico.txt","http://localhost:8080/arquivos/gramatica.txt").configuraTesta("Período","Agramatical",conversaoInicial).toString());
        conversaoInicial.clear();
        System.out.println();
    }

    @Test public void teste014(){
        Lista<String> conversaoInicial=new Lista<String>();
        String original="os homens desejam a paz"; // bechara 38 edicao
        System.out.printf("\n%-20s[%s]","Original:",original);
        for(String palavra:Separador.separa(original)) conversaoInicial.add(analisador.lexico.get(palavra));
        assertEquals("[Período]",new Parsing("http://localhost:8080/arquivos/lexico.txt","http://localhost:8080/arquivos/gramatica.txt").configuraTesta("Período","Agramatical",conversaoInicial).toString());
        conversaoInicial.clear();
        System.out.println();
    }

    @Test public void teste015(){
        Lista<String> conversaoInicial=new Lista<String>();
        String original="ela não trabalha aos sábados"; // bechara 38 edicao
        System.out.printf("\n%-20s[%s]","Original:",original);
        for(String palavra:Separador.separa(original)) conversaoInicial.add(analisador.lexico.get(palavra));
        assertEquals("[Período]",new Parsing("http://localhost:8080/arquivos/lexico.txt","http://localhost:8080/arquivos/gramatica.txt").configuraTesta("Período","Agramatical",conversaoInicial).toString());
        conversaoInicial.clear();
        System.out.println();
    }
}
