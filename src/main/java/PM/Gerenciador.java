package PM;

import Internet.PaginaHTML;
import java.util.ArrayList;

public class Gerenciador{

    /**
     * Pega todo o arquivo
     *
     * @param endereco
     */
    public Gerenciador(String endereco){
        ArrayList<String> agentes = PaginaHTML.pegaURL(endereco);
        simplifica();
    }

    /**
     * Adiciona os agentes apenas uma vez
     */
    public void adicionaAgente(){
    }

    public void removeAgente(){
    }

    private void simplifica(){
    }
}
