package Internet;
import EstruturasDeDados.Lista;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaginaHTML{

    public static Lista<String> pegaURL(String endereco){
        try{
            Lista<String> linhas=new Lista<String>();
            URL urlDaConexao=new URL(endereco);
            URLConnection conexao=urlDaConexao.openConnection();
            BufferedReader leitor=new BufferedReader(new InputStreamReader(conexao.getInputStream(),"UTF-8"));
            String linha;
            while((linha=leitor.readLine())!=null)
                linhas.adiciona(linha);
            leitor.close();
            return linhas;
        }catch(MalformedURLException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static String decodifica(String s){
        StringBuffer sb=new StringBuffer();
        Matcher m=Pattern.compile("\\&#(\\d+);").matcher(s);
        while(m.find()){
            int uc=Integer.parseInt(m.group(1));
            m.appendReplacement(sb,"");
            sb.appendCodePoint(uc);
        }
        m.appendTail(sb);
        return sb.toString();
    }
}
