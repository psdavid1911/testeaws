package Strings_Tokens;

public class RemoverdorDeEspacos{

    public static String duplosParaSimples( String texto ){
        while( texto.contains("  ") )texto=texto.replaceAll("  ", " ");
        return texto;
    }

    public static String tiraTodos( String texto ){
        return texto.replaceAll(" ", "");
    }
}
