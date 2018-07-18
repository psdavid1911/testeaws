package FluxoDeArquivos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FluxoBeans<T>{
    GerenciadorDeArquivo arquivo;

    public FluxoBeans(String caminhoNomeDoArquivo){
        arquivo = new GerenciadorDeArquivo(caminhoNomeDoArquivo);
    }

    public void escreve(T objeto){
        // passo 1
        FileOutputStream fos=null;
        try{
            fos = new FileOutputStream(arquivo);
        }catch(FileNotFoundException ex){
        }
        // passo 2
        BufferedOutputStream bos;
        bos = new BufferedOutputStream(fos);
        // passo 3
        ObjectOutputStream oos;
        try{
            oos = new ObjectOutputStream(bos);
        }catch(IOException e){
            erro(e.getMessage());
            e.printStackTrace();
            return;
        }
        // escreve objeto na saida
        try{
            oos.writeObject(objeto);
        }catch(IOException e){
            erro(e.getMessage());
            e.printStackTrace();
            return;
        }
        // fecha
        try{
            oos.close();
        }catch(IOException e){
            erro(e.getMessage());
            e.printStackTrace();
            return;
        }
    }

    public T le(){
        // passo 1
        FileInputStream fis;
        try{
            fis = new FileInputStream(arquivo);
        }catch(FileNotFoundException e){
            erro(e.getMessage());
            e.printStackTrace();
            return null;
        }
        // passo 2
        BufferedInputStream bis;
        bis = new BufferedInputStream(fis);
        // passo 3
        ObjectInputStream ois;
        try{
            ois = new ObjectInputStream(bis);
        }catch(IOException e){
            erro(e.getMessage());
            e.printStackTrace();
            return null;
        }
        // le a entrada
        T entrada;
        try{
            entrada = (T) ois.readObject();
        }catch(IOException e){
            erro(e.getMessage());
            e.printStackTrace();
            return null;
        }catch(ClassNotFoundException e){
            erro(e.getMessage());
            e.printStackTrace();
            return null;
        }
        // fecha
        try{
            ois.close();
        }catch(IOException e){
            erro(e.getMessage());
            e.printStackTrace();
        }
        return entrada;
    }

    public void apaga(){
        arquivo.apaga();
    }

    public boolean existe(){
        return arquivo.existe();
    }

    // PODE VIRAR ATRIBUTO
    public String caminho(){
        return arquivo.caminhoCompleto();
    }

    private void erro(String erro){
        System.out.println(erro);
    }
}
