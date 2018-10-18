package FluxoDeArquivos;

import java.io.File;

/**
 *
 * @author david
 */
public class GerenciadorDeArquivo extends File{

    public GerenciadorDeArquivo(String caminho_do_arquivo){
        super(caminho_do_arquivo.replace("file://", "").replace("http://", "").replace("https://", ""));
    }

    public GerenciadorDeArquivo(String caminho, String nome_do_arquivo){
        super(caminho, nome_do_arquivo);
    }

    public void apaga(){
        delete();
    }

    public boolean existe(){
        return exists();
    }

    // PODE VIRAR UM ATRIBUTO, PARA PERDER OS PARENTESES
    public String caminhoCompleto(){
        return getAbsolutePath();
    }
}
