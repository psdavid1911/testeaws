package testes_Ordena;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ordena{

    static ArrayList<Integer> l=new ArrayList<>();

    public static Integer e( int i ){
        return l.get(i);
    }

    public static ArrayList<Integer> listaAleatoria( int tamanho, int valorMaximo ){
        ArrayList<Integer> lista=new ArrayList<>();
        for( int i=0; i < tamanho; i++ )
            lista.add(new Random().nextInt(valorMaximo + 1));
        return lista;
    }

    public static void main( String[] args ){
        l=listaAleatoria(9, 50);
        System.out.println("\n" + l);
        _0bolha(l);
        System.out.println(l);
        //---------------------
        l=listaAleatoria(9, 50);
        System.out.println("\n" + l);
        _1selecao(l);
        System.out.println(l);
        //---------------------
        l=listaAleatoria(9, 50);
        System.out.println("\n" + l);
        _2insercao(l);
        System.out.println(l);
        //---------------------
        l=listaAleatoria(9, 50);
        System.out.println("\n" + l);
        _3rapido(l, 0, l.size() - 1);
        System.out.println(l);
        //---------------------
        l=listaAleatoria(9, 50);
        System.out.println("\n" + l);
        _4novo(l);
        System.out.println(l);
    }

    public static void troca( int i, int j ){
        int aux=e(i);
        l.set(i, e(j));
        l.set(j, aux);
    }

    private static void _0bolha( ArrayList<Integer> l ){
        for( int i=0; i < l.size(); i++ )
            for( int j=0; j < l.size(); j++ )
                if( e(j) < e(i) )troca(i, j);
    }

    private static void _1selecao( ArrayList<Integer> l ){
        troca(0, l.indexOf(Collections.min(l)));
        for( int i=0; i < l.size(); i++ )
            for( int j=i + 1; j < l.size(); j++ )
                if( e(j) < e(i + 1) )troca(j, i + 1);
    }

    private static void _2insercao( ArrayList<Integer> l ){
        for( int i=0; i < l.size(); i++ )
            for( int j=i + 1; j >= 0; j-- ){
                if( i + 1 < l.size() && e(i + 1) < e(i) )troca(i + 1, i);
                if( j - 1 >= 0 && j < l.size() && e(j) < e(j - 1) )troca(j, j - 1);
            }
    }

    private static void _3rapido( ArrayList<Integer> l, int iniVetor, int fimVetor ){
        int i=iniVetor, j=fimVetor, pivo=(i + j) / 2;
        while( i <= j ){
            while( e(i) < e(pivo) )i++;
            while( e(pivo) < e(j) )j--;
            if( i <= j )troca(i++, j--);
        }
        if( iniVetor < j )_3rapido(l, iniVetor, j);
        if( i < fimVetor )_3rapido(l, i, fimVetor);
    }

    private static void _4novo( ArrayList<Integer> l ){
        for( int i=0; i < l.size()-1; i++ )
            if( e(i) > e(i + 1) ){
                troca(i, i + 1);
                i=-1;
            }
    }
}
