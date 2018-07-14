package Strings_Tokens;

import EstruturasDeDados.ListaAntiga;
import java.util.StringTokenizer;

public class Separador{
    public ListaAntiga<String> listaDePedacos = new ListaAntiga<String>();

    public Separador( String linha ){
        StringTokenizer st = new StringTokenizer( linha, " \n" );
        while( st.hasMoreElements() )
            listaDePedacos.adiciona( ( String ) st.nextElement() );
    }

    public static ListaAntiga<String> separa( String linha ){
        ListaAntiga<String> listaDePedacos = new ListaAntiga<String>();
        StringTokenizer st = new StringTokenizer( linha, " \n" );
        while( st.hasMoreElements() )listaDePedacos.adiciona( ( String ) st.nextElement() );
        return listaDePedacos;
    }

    public void imprime(){
        System.out.println( listaDePedacos );
    }
}
