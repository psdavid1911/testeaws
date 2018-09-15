package PM;

import EstruturasDeDados.Lista;
import Internet.PaginaHTML;

public class Gerenciador{

    /**
     * Pega todo o arquivo
     *
     * @param endereco
     */
    public Gerenciador( String endereco ){
        Lista<String> agentes=PaginaHTML.pegaURL(endereco);
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
