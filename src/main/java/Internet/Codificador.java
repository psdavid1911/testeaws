package Internet;

import EstruturasDeDados.Lista;
import FluxoDeArquivos.FluxoDeTexto;

public class Codificador{

    FluxoDeTexto manipulador;

    public Codificador( String uriDoArquivo ){
        manipulador=new FluxoDeTexto(uriDoArquivo);
    }

    public void codifica(){
        Lista<String> linhas=manipulador.le();
        Lista<String> linhasAlteradas=new Lista<String>();
        for( String linha:linhas ){
            linha=linha.replaceAll("á", "&aacute;");
            linha=linha.replaceAll("é", "&eacute;");
            linha=linha.replaceAll("í", "&iacute;");
            linha=linha.replaceAll("ó", "&oacute;");
            linha=linha.replaceAll("ú", "&uacute;");
            linha=linha.replaceAll("ç", "&ccedil;");
            linha=linha.replaceAll("ã", "&atilde;");
            linha=linha.replaceAll("õ", "&otilde;");
            linha=linha.replaceAll("â", "&acirc;");
            linha=linha.replaceAll("ê", "&ecirc;");
            linha=linha.replaceAll("î", "&icirc;");
            linha=linha.replaceAll("ô", "&ocirc;");
            linha=linha.replaceAll("û", "&ucirc;");
            linha=linha.replaceAll("Á", "&Aacute;");
            linha=linha.replaceAll("É", "&Eacute;");
            linha=linha.replaceAll("Í", "&Iacute;");
            linha=linha.replaceAll("Ó", "&Oacute;");
            linha=linha.replaceAll("Ú", "&Uacute;");
            linha=linha.replaceAll("Ç", "&Ccedil;");
            linha=linha.replaceAll("Ã", "&Atilde;");
            linha=linha.replaceAll("Õ", "&Otilde;");
            linha=linha.replaceAll("Â", "&Acirc;");
            linha=linha.replaceAll("Ê", "&Ecirc;");
            linha=linha.replaceAll("Î", "&Icirc;");
            linha=linha.replaceAll("Ô", "&Ocirc;");
            linha=linha.replaceAll("Û", "&Ucirc;");
            linhasAlteradas.add(linha);
        }
        manipulador.escreve(linhasAlteradas);
    }
}
