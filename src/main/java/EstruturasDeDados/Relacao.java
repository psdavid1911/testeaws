package EstruturasDeDados;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Uma relação, neste caso, relaciona dois conjuntos, tais que estes formam um
 * par ordenado (x,y) ou (elementoDoDominio, elementoImagem) se quiser pensar em
 * na relação como uma função de primeiro grau. Nesta implementação é possivel
 * se repetir elementos, formando por exemplo { (1,2) , (1,3), (1,2) }, a
 * relacao também pode ser ordenada tanto pelos elementos do domínio, quanto
 * pelas imagens, elementos também podem ser agrupados.
 *
 * Características:
 *
 * 1. Permite repetições. 2. Elementos são indexados pela ordem de inclusão. 3.
 * Elementos podem ser ordenados 4. Pares ordenados diferentes, que contem o
 * mesmo elemento do domínio podem ter seus valores adicionados
 *
 * @author david
 * @param <A>
 * @param <B>
 */
public class Relacao<A extends Comparable<A>, B extends Comparable<B>> implements Iterable<Par<A, B>>{

    ArrayList<Par<A, B>> relacao = new ArrayList<Par<A, B>>();

    public Relacao(){
    }

    public Relacao(ArrayList<Par<A, B>> relacao){
        this.relacao = relacao;
    }

    public void adiciona(Par<A, B> par){
        relacao.add(par);
    }

    public void adiciona(A a, B b){
        relacao.add(new Par<A, B>(a, b));
    }

//    public void paraCada(BiConsumer<A, B> expressaoLambda){
//        relacao.paraCada(par -> expressaoLambda.accept(par.X(), par.Y()));
//    }
    public Relacao<B, A> inversa(){
        Relacao<B, A> nova = new Relacao<B, A>();
        for (Par<A, B> par : relacao)
            nova.adiciona(par.Y(), par.X());
        return nova;
    }

    @Override
    public Iterator<Par<A, B>> iterator(){
        return relacao.iterator();
    }

    public ArrayList<B> pegaImagens(A elementoDoDominio){
        ArrayList<B> imagens = new ArrayList<B>();
        for (Par<A, B> parOrdenado : relacao)
            imagens.add(parOrdenado.Y());
        return imagens;
    }

    //Não destrutivo
    public Par<A, B> pegaPar(int i){
        return relacao.get(i);
    }

    //Não destrutivo
    public Par<A, B> pegaPar(A a, B b){
        return relacao.get(relacao.indexOf(new Par(a, b)));
    }

    //Não destrutivo
    public Par<A, B> pegaPar(Par<A, B> par){
        return relacao.get(relacao.indexOf(par));
    }

    //Construtivo
    public Relacao<A, B> pegaRelacoes(A elementoDoDominio){
        ArrayList<Par<A, B>> novaLista = new ArrayList<Par<A, B>>();
        for (Par<A, B> par : relacao)
            if (par.X().equals(elementoDoDominio))
                novaLista.add(par);
        return new Relacao<A, B>(novaLista);
    }
}
