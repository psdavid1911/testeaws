package Strings_Tokens;
import EstruturasDeDados.Lista;
import java.util.StringTokenizer;

public class Separador{

    public Lista<String> listaDePedacos=new Lista<String>();

    public Separador(String linha){
        StringTokenizer st=new StringTokenizer(linha," \n");
        while(st.hasMoreElements())
            listaDePedacos.add((String)st.nextElement());
    }

    public static Lista<String> separa(String linha){
        Lista<String> listaDePedacos=new Lista<String>();
        StringTokenizer st=new StringTokenizer(linha," \n");
        while(st.hasMoreElements())listaDePedacos.add((String)st.nextElement());
        return listaDePedacos;
    }

    public void imprime(){
        System.out.println(listaDePedacos);
    }
}
