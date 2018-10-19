package testes_String;

import org.junit.Test;

public class removedorDeEspacos{

    @Test
    public void removedor(){
        String linha = "   [ [][]  ]   ";
        linha = linha.replaceAll("^\\s*\\[", "");
        linha = linha.replaceAll("\\]\\s*$", "");
        System.out.println(linha);
    }
}
