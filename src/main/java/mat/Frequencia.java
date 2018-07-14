/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mat;
import EstruturasDeDados8.Lista;
import org.apache.commons.math3.stat.Frequency;

/**
 *
 * @author david
 */
public class Frequencia< T extends Comparable<T>>{

    /**
     * Quantidade de vezes que um elemento aparece no conjunto.
     *
     * @param conjunto
     * @param elemento
     *
     * @return
     */
    public double frequenciaAbsoluta(Lista<T> conjunto,T elemento){
        Frequency frequencia=new Frequency();
        for(T valor:conjunto)
            frequencia.addValue(valor);
        return frequencia.getCount(elemento);
    }

    /**
     * Quantidade de vezes que um elemento aparece no conjunto como valor entre
     * 0 e 1.
     *
     * @param conjunto
     * @param elemento
     *
     * @return
     */
    public double frequenciaPercentual(Lista<T> conjunto,T elemento){
        Frequency frequencia=new Frequency();
        for(T valor:conjunto)
            frequencia.addValue(valor);
        return frequencia.getPct(elemento);
    }

    /**
     * Uma lista dos elementos que mais se repetem no conjunto.
     *
     * @param conjunto
     *
     * @return
     */
    public Lista<T> moda(Lista<T> conjunto){
        Frequency frequencia=new Frequency();
        Lista<T> moda=new Lista<T>();
        for(T valor:conjunto)
            frequencia.addValue(valor);
        for(Comparable d:frequencia.getMode()) // Não tenho certeza se isto esta certo
            moda.adiciona((T)d);
        return moda;
    }

    /**
     * Quantidade de vezes que um elemento e seus antecessores aparece no
     * conjunto, na forma de um número entre 0 e 1.
     *
     * @param conjunto
     * @param elemento
     *
     * @return
     */
    public double frequenciaAcumuladaAbsoluta(Lista<T> conjunto,T elemento){
        Frequency frequencia=new Frequency();
        for(T valor:conjunto)
            frequencia.addValue(valor);
        return frequencia.getCumFreq(elemento);
    }

    /**
     * Quantidade de vezes que um elemento e seus antecessores aparece no
     * conjunto, na forma de um número entre 0 e 1.
     *
     * @param conjunto
     * @param elemento
     *
     * @return
     */
    public double frequenciaAcumuladaPercentual(Lista<T> conjunto,T elemento){
        Frequency frequencia=new Frequency();
        for(T valor:conjunto)
            frequencia.addValue(valor);
        return frequencia.getCumPct(elemento);
    }

    /**
     *
     *
     * @param conjunto
     *
     * @return
     */
    public double somaDasFrequencias(Lista<T> conjunto){
        Frequency frequencia=new Frequency();
        for(T valor:conjunto)
            frequencia.addValue(valor);
        return frequencia.getSumFreq();
    }

    /**
     *
     *
     * @param conjunto
     *
     * @return
     */
    public double numeroDeElementosDistintos(Lista<T> conjunto){
        Frequency frequencia=new Frequency();
        for(T valor:conjunto)
            frequencia.addValue(valor);
        return frequencia.getUniqueCount();
    }
}
