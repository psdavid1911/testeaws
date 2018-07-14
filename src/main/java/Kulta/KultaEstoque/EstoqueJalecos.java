package Kulta.KultaEstoque;
import EstruturasDeDados.TabelaHash;
import FluxoDeArquivos.FluxoBeans;
import Kulta.KultaEnumeracoes.NOME;
import Kulta.KultaEnumeracoes.TAMANHO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map.Entry;

public class EstoqueJalecos{

    final FluxoBeans<EstruturasDeDados.TabelaHash<NOME,Jaleco>> arquivo;
    TabelaHash<NOME,Jaleco> estoque=new TabelaHash<NOME,Jaleco>();

    public EstoqueJalecos(String caminhoArquivo){
        arquivo=new FluxoBeans<TabelaHash<NOME,Jaleco>>(caminhoArquivo);
        atualiza();
        if(arquivo.existe())
            for(Entry<NOME,Jaleco> entrada:arquivo.le().conjunto())
                adiciona(entrada.getValue());
    }

    public ArrayList<NOME> pegaUnicos(){
        ArrayList<NOME> nomes=new ArrayList<NOME>();
        for(Entry<NOME,Jaleco> entrada:estoque.conjunto())
            nomes.add(entrada.getKey());
        Collections.sort(nomes,new Comparator<NOME>(){
            @Override
            public int compare(NOME nome1,NOME nome2){
                return nome1.toString().compareTo(nome2.toString());
            }
        });
        return nomes;
    }

    private void atualiza(){
        adiciona(criaJaleco(NOME.jasminebranco,""
                +"Preço: R$ 50,00\n"
                +"Jaleco branco com bordado na gola, na manga, nas costas e trava, com gola em 'v', botões cobertos e de manga curta, feito em oxford, na cor branca. Feito nos tamanhos PP, P, M, G, GG, EG.",
                tamanhosZero()));
        adiciona(criaJaleco(NOME.jasminecolorido,""
                +"Preço: R$ 50,00\n"
                +"Jaleco branco com bordado na gola, na manga, nas costas e trava, com gola em 'v', botões cobertos e de manga curta, feito em oxford, colorido. Feito nos tamanhos PP, P, M, G, GG, EG.",
                tamanhosZero()));
        adiciona(criaJaleco(NOME.auroracolorido,""
                +"Preço: R$ 50,00\n"
                +"Jaleco branco com bordado na gola, na manga, nas costas, nos bolsos e trava, com gola em 'v', botões cobertos e de manga longa, feito em oxford, colorido. Feito nos tamanhos PP, P, M, G, GG, EG.",
                tamanhosZero()));
        adiciona(criaJaleco(NOME.auroraazul,""
                +"Preço: R$ 50,00\n"
                +"Jaleco branco com bordado na gola, na manga, nas costas, nos bolsos e trava, com gola em 'v', botões cobertos e de manga longa, feito em oxford, na cor azul. Feito nos tamanhos PP, P, M, G, GG, EG.",
                tamanhosZero()));
        adiciona(criaJaleco(NOME.aurorasalmao,""
                +"Preço: R$ 50,00\n"
                +"Jaleco branco com bordado na gola, na manga, nas costas, nos bolsos e trava, com gola em 'v', botões cobertos e de manga longa, feito em oxford, em salmão. Feito nos tamanhos PP, P, M, G, GG, EG.",
                tamanhosZero()));
        adiciona(criaJaleco(NOME.belasalmao,""
                +"Preço: R$ 50,00\n"
                +"Jaleco branco com bordado na gola, na manga, nas costas, abaixo dos bolsos e trava, com gola em 'v', botões ocultos e de manga longa, feito em oxford, em salmão. Feito nos tamanhos PP, P, M, G, GG, EG.",
                tamanhosZero()));
        adiciona(criaJaleco(NOME.magnificabranco,""
                +"Preço: R$ 65,00\n"
                +"Jaleco branco com bordado na gola, na manga (manga trabalhada), nas costas, nos bolsos e trava, com gola em 'v', botões cobertos e de manga longa, feito em oxford, na cor branca. Feito nos tamanhos PP, P, M, G, GG, EG.",
                tamanhosZero()));
        adiciona(criaJaleco(NOME.magnificarosa,""
                +"Preço: R$ 65,00\n"
                +"Jaleco branco com bordado na gola, na manga (manga trabalhada), nas costas, nos bolsos e trava, com gola em 'v', botões cobertos e de manga longa, feito em oxford, na cor rosa. Feito nos tamanhos PP, P, M, G, GG, EG.",
                tamanhosZero()));
        adiciona(criaJaleco(NOME.magnificaverde,""
                +"Preço: R$ 65,00\n"
                +"Jaleco branco com bordado na gola, na manga (manga trabalhada), nas costas, nos bolsos e trava, com gola em 'v', botões cobertos e de manga longa, feito em oxford, na cor verde. Feito nos tamanhos PP, P, M, G, GG, EG.",
                tamanhosZero()));
        adiciona(criaJaleco(NOME.princesarosa,""
                +"Preço: R$ 60,00\n"
                +"Jaleco branco com bordado na gola, na manga (manga trabalhada), nas costas, nos bolsos e trava, com gola em 'v', botões cobertos e de manga longa, feito em oxford, na cor rosa. Feito nos tamanhos PP, P, M, G, GG, EG.",
                tamanhosZero()));
        adiciona(criaJaleco(NOME.princesaazulclaro,""
                +"Preço: R$ 60,00\n"
                +"Jaleco branco com bordado na gola, na manga (manga trabalhada), nas costas, nos bolsos e trava, com gola em 'v', botões cobertos e de manga longa, feito em oxford, na cor azul clara. Feito nos tamanhos PP, P, M, G, GG, EG.",
                tamanhosZero()));
        adiciona(criaJaleco(NOME.princesaazulescuro,""
                +"Preço: R$ 60,00\n"
                +"Jaleco branco com bordado na gola, na manga (manga trabalhada), nas costas, nos bolsos e trava, com gola em 'v', botões cobertos e de manga longa, feito em oxford, na cor azul escura. Feito nos tamanhos PP, P, M, G, GG, EG.",
                tamanhosZero()));
        adiciona(criaJaleco(NOME.basicrosa,""
                +"Preço: R$ 50,00\n"
                +"Jaleco branco com enviés na gola, nas mangas, nos bolsos e punhos, com gola em 'v', botões cobertos, de manga longa, feito em oxford, na cor rosa. Confeccionado nos tamanhos PP, P, M, G, GG, EG.",
                tamanhosZero()));
        adiciona(criaJaleco(NOME.rainharosa,""
                +"Preço: R$ 45,00\n"
                +"Jaleco branco bordado na gola, nas mangas, bolsos e punhos, com gola em 'v', botões cobertos, de manga longa, feito em oxford, na cor rosa. Confeccionado nos tamanhos PP, P, M, G, GG, EG.",
                tamanhosZero()));
        adiciona(criaJaleco(NOME.rainhaazul,""
                +"Preço: R$ 45,00\n"
                +"Jaleco branco bordado na gola, nas mangas, bolsos e punhos, com gola em 'v', botões cobertos, de manga longa, feito em oxford, na cor azul. Confeccionado nos tamanhos PP, P, M, G, GG, EG.",
                tamanhosZero()));
        adiciona(criaJaleco(NOME.rainhabranco,""
                +"Preço: R$ 45,00\n"
                +"Jaleco branco bordado na gola, nas mangas, bolsos e punhos, com gola em 'v', botões cobertos, de manga longa, feito em oxford, na cor branca. Confeccionado nos tamanhos PP, P, M, G, GG, EG.",
                tamanhosZero()));
        adiciona(criaJaleco(NOME.rainhaverde,""
                +"Preço: R$ 45,00\n"
                +"Jaleco branco bordado na gola, nas mangas, bolsos e punhos, com gola em 'v', botões cobertos, de manga longa, feito em oxford, na cor verde. Confeccionado nos tamanhos PP, P, M, G, GG, EG.",
                tamanhosZero()));
        adiciona(criaJaleco(NOME.tulipabranco,""
                +"Preço: R$ 50,00\n"
                +"Jaleco branco com bordado na gola e nos bolsos, com gola em 'v', botões cobertos, sem manga, feito em oxford, na cor branca. Confeccionado nos tamanhos PP, P, M, G, GG, EG.",
                tamanhosZero()));
    }

    private void adiciona(Jaleco jaleco){
        estoque.adiciona(jaleco.getNome(),jaleco);
        // VOCE NÃO PODE SALVAR NADA AQUI.
    }

    public Jaleco getJaleco(NOME nomej){
        return estoque.pega(nomej);
    }

    private Jaleco criaJaleco(NOME nome,String descricao,TabelaHash<TAMANHO,Integer> quantidades){
        Jaleco novo=new Jaleco();
        novo.setNome(nome);
        novo.setDescricao(descricao);
        novo.setQtde(quantidades);
        return novo;
    }

    private TabelaHash<TAMANHO,Integer> tamanhosZero(){
        TabelaHash<TAMANHO,Integer> padrao=new TabelaHash<TAMANHO,Integer>();
        padrao.put(TAMANHO.pp,0);
        padrao.put(TAMANHO.p,0);
        padrao.put(TAMANHO.m,0);
        padrao.put(TAMANHO.g,0);
        padrao.put(TAMANHO.gg,0);
        padrao.put(TAMANHO.eg,0);
        return padrao;
    }

    /**
     * Pode somar quantidades negativas para subtrair
     *
     * @param nome nome do jaleco a se mudar
     * @param tamanho
     * @param qtdeNova valor a se adicionar
     */
    public Jaleco somaQuantidade(NOME nome,TAMANHO tamanho,Integer qtdeNova){
        estoque.get(nome).getQtde().adicionaSomando(tamanho,qtdeNova);
        salvaNoArquivo();
        return estoque.get(nome);
    }

    private void salvaNoArquivo(){
        arquivo.escreve(estoque);
    }

    public boolean arquivoExiste(){
        return arquivo.existe();
    }

    public int quantidadeDeJalecosDoEstoque(){
        Integer quantidade=0;
        for(Entry<NOME,Jaleco> entrada:estoque.conjunto())
            for(Entry<TAMANHO,Integer> entradaQuantidade:entrada.getValue().getQtde().conjunto())
                quantidade+=entradaQuantidade.getValue();
        return quantidade;
    }

    public int quantidadeDeModelosDoEstoque(){
        return estoque.tamanho();
    }

    public int quantidadeDeJalecosDoModelo(NOME nomeDoJaleco){
        int quantidade=0;
        for(Entry<TAMANHO,Integer> entradaQuantidade:estoque.get(nomeDoJaleco).getQtde().conjunto())
            quantidade+=entradaQuantidade.getValue();
        return quantidade;
    }

    @Override
    public String toString(){
        String estoque="";
        for(Entry<NOME,Jaleco> entrada:this.estoque.conjunto()) {
            estoque+="nome: "+entrada.getValue().getNome();
            estoque+=" quantidades: ";
            for(Entry<TAMANHO,Integer> entradaQuantidade:entrada.getValue().getQtde().conjunto())
                estoque+=entradaQuantidade.getValue().toString();
            estoque+="\n";
        }
        return estoque+"\n";
    }

    public boolean existe(){
        return arquivo.existe();
    }
}
