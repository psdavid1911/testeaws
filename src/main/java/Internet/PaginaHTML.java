package Internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaginaHTML{

    public static String decodifica(String s){
        StringBuffer sb = new StringBuffer();
        Matcher m = Pattern.compile("\\&#(\\d+);").matcher(s);
        while (m.find()){
            int uc = Integer.parseInt(m.group(1));
            m.appendReplacement(sb, "");
            sb.appendCodePoint(uc);
        }
        m.appendTail(sb);
        return sb.toString();
    }

    /**
     * Le uma cadeia de texto para um arquivo armazenado no endereço informado a
     * leitura é feita utilizando o formato UTF-8.
     *
     * @param endereco - Caminho para o arquivo na web.
     * @return - Uma lista com as linhas do arquivo.
     */
    public static ArrayList<String> pegaURL(String endereco){
        try{
            ArrayList<String> linhas = new ArrayList<String>();
            URL urlDaConexao = new URL(endereco);
            URLConnection conexao = urlDaConexao.openConnection();
            BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream(), "UTF-8"));
            String linha;
            while ((linha = leitor.readLine()) != null)
                linhas.add(linha);
            leitor.close();
            return linhas;
        } catch (MalformedURLException ex){
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
