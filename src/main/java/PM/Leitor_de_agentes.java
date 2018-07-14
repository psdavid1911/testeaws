package PM;

import EstruturasDeDados.Lista;
import EstruturasDeDados.TabelaHash;
import FluxoDeArquivos.FluxoDeTexto;

public class Leitor_de_agentes {

    FluxoDeTexto manipulador = new FluxoDeTexto("agentes.csv");

    TabelaHash<Integer, Agente> agentes = new TabelaHash<Integer, Agente>();

    Leitor_de_agentes() {
        Lista<String> linhasDoArquivo = manipulador.le();
        linhasDoArquivo.remove(0);
        for (String linha : linhasDoArquivo) {
            String[] campo = linha.split(";");
            // nome numeral ingresso contato escala
            agentes.adiciona(Integer.valueOf(campo[1]), Gerar.agente(campo[3], Gerar.tipo_de_escala(4, 2), campo[0], Integer.valueOf(campo[1]), new Lista<Servico>(), campo[2]));
        }
    }

    @Override
    public String toString() {
        return "Leitor_de_agentes{" + "agentes=" + agentes.toString() + '}';
    }

}
