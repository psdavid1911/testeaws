package EstruturasDeDados8;
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
public class Relacao8<A extends Comparable<A>,B extends Comparable<B>> implements Iterable<Par8<A,B>>{

    Lista8<Par8<A,B>> relacao=new Lista8<Par8<A,B>>();

    public Relacao8(){
    }

    public Relacao8(Lista8<Par8<A,B>> relacao){
        this.relacao=relacao;
    }

    //Não destrutivo
    public Par8<A,B> pegaPar(int i){
        return relacao.pega(i);
    }

    //Não destrutivo
    public Par8<A,B> pegaPar(A a,B b){
        return relacao.pega(new Par8(a,b));
    }

    //Não destrutivo
    public Par8<A,B> pegaPar(Par8<A,B> par){
        return relacao.pega(par);
    }

    //Construtivo
    public Relacao8<A,B> pegaRelacoes(A elementoDoDominio){
        Lista8<Par8<A,B>> novaLista=new Lista8<Par8<A,B>>();
        for(Par8<A,B> par:relacao)
            if(par.getX().equals(elementoDoDominio))
                novaLista.adiciona(par);
        return new Relacao8<A,B>(novaLista);
    }

    public Lista8<B> pegaImagens(A elementoDoDominio){
        Lista8<B> imagens=new Lista8<B>();
        for(Par8<A,B> parOrdenado:relacao)
            imagens.adiciona(parOrdenado.getY());
        return imagens;
    }

    public void adiciona(Par8<A,B> par){
        relacao.adiciona(par);
    }

    public void adiciona(A a,B b){
        relacao.adiciona(new Par8<A,B>(a,b));
    }

//    public void paraCada(BiConsumer<A, B> expressaoLambda){
//        relacao.paraCada(par -> expressaoLambda.accept(par.getX(), par.getY()));
//    }
    public Relacao8<B,A> inversa(){
        Relacao8<B,A> nova=new Relacao8<B,A>();
        for(Par8<A,B> par:relacao)
            nova.adiciona(par.getY(),par.getX());
        return nova;
    }

    @Override
    public Iterator<Par8<A,B>> iterator(){
        return relacao.iterator();
    }
}
