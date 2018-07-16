package Internet;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class PaginaHTML{

    public static String pegaHTML(String endereco){
        String conteudo=null;
        try{
            URLConnection conexao=new URL(endereco).openConnection();
            Scanner scanner=new Scanner(conexao.getInputStream());
            scanner.useDelimiter("\\Z");
            conteudo=scanner.next();
        }catch(IOException e){
            e.printStackTrace();
        }
        return conteudo;
    }
}
