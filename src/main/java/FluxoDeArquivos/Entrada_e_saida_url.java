package FluxoDeArquivos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Entrada_e_saida_url{

    String uriDaURL;

    public Entrada_e_saida_url(String uriDaURL){
        this.uriDaURL=uriDaURL;
    }

    public ArrayList<String> le(){
        ArrayList<String> linhasDoHTML=new ArrayList<String>();
        URL url;
        try{
            url=new URL(uriDaURL);
        }catch(MalformedURLException ex){
            System.err.println("Não pude criar a url informada.");
            return null;
        }
        BufferedReader in;
        try{
            in=new BufferedReader(new InputStreamReader(url.openStream()));
        }catch(IOException ex){
            System.err.println("Não pude criar a stream de dados.");
            return null;
        }
        String inputLine;
        try{
            while((inputLine=in.readLine())!=null)
                linhasDoHTML.add(inputLine);
        }catch(IOException ex){
            System.err.println("Houve um erro ao ler");
            return null;
        }
        try{
            in.close();
        }catch(IOException ex){
            System.err.println("Não pude fechar o buffer.");
            return linhasDoHTML;
        }
        return linhasDoHTML;
    }
}
