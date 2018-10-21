package testes_String;

import org.junit.jupiter.api.Test;

public class removedorDeEspacos{

    @Test
    public void removedor(){
        String linha = "-20&72";
        boolean resultado = linha.matches(""
                + "-?[0-9]+(\\.|\\,)[0-9]*|-?[0-9]*(\\.|\\,)[0-9]+|-?[0-9]+"
        );
        
        System.out.println(resultado);
    }
}
