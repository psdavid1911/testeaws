package FluxoDeArquivos8;

import FluxoDeArquivos.GerenciadorDeArquivo;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FluxoBeansXml<T>{
    GerenciadorDeArquivo uriArquivo;

    public FluxoBeansXml(String uriArquivo){
        this.uriArquivo = new GerenciadorDeArquivo(uriArquivo);
    }

    public void escreve(T objeto){
        try{
            XMLEncoder encoder = new XMLEncoder(
                    new BufferedOutputStream(
                            new FileOutputStream(uriArquivo)));
            encoder.writeObject(objeto);
            encoder.close();
        }catch(FileNotFoundException ex){
            System.err.println("Não pude escrever no arquivo pois não o encontrei");
        }
    }

    public T le(){
        try{
            XMLDecoder decoder = new XMLDecoder(
                    new BufferedInputStream(
                            new FileInputStream(uriArquivo)));
            T o = (T) decoder.readObject();
            decoder.close();
            return o;
        }catch(FileNotFoundException ex){
            System.err.println("Não pude ler o arquivo pois não o encontrei");
            return null;
        }
    }

    public void apaga(){
        try{
            Files.delete(Paths.get(uriArquivo.caminhoCompleto()));
        }catch(IOException ex){
            System.err.println("Não pude apagar o arquivo.");
        }
    }

    public boolean existe(){
        return uriArquivo.existe();
    }
}
