package FluxoDeArquivos;

import EstruturasDeDados.Lista;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class FluxoDeTexto{

    public GerenciadorDeArquivo arquivo;

    public FluxoDeTexto(String uriArquivo){
        arquivo=new GerenciadorDeArquivo(uriArquivo);
    }

    public Lista<String> le(){
        try{
            Lista<String> linhas=new Lista<String>();
            BufferedReader leitor=new BufferedReader(new InputStreamReader(new FileInputStream(arquivo),"UTF-8"));
            while(true){
                String linha=leitor.readLine();
                if(linha!=null)
                    linhas.adiciona(linha);
                else break;
            }
            leitor.close();
            return linhas;
        }catch(FileNotFoundException ex){
        }catch(IOException ex){
        }
        return new Lista<String>();
    }

    public void escreve(Lista<String> lista){
        try{
            OutputStreamWriter escritor=new OutputStreamWriter(new FileOutputStream(arquivo),StandardCharsets.UTF_8);
            for(String linha:lista)
                escritor.write(linha+"\n");
            escritor.close();
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(UnsupportedEncodingException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void apaga(){
        arquivo.apaga();
    }

    public boolean existe(){
        return arquivo.existe();
    }
}
