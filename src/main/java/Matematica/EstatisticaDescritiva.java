package Matematica;

import EstruturasDeDados8.Lista;
import org.apache.commons.math3.stat.*;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

/**
 * Classe para medidas de tendência central e outras utilidades
 *
 * @author david
 */
public class EstatisticaDescritiva{
    public double mediaAritimetica(Lista<Double> conjunto){
        DescriptiveStatistics estatistica = new DescriptiveStatistics();
        for(Double valor : conjunto)
            estatistica.addValue(valor);
        return estatistica.getMean();
    }

    public double mediaGeometrica(Lista<Double> conjunto){
        DescriptiveStatistics estatistica = new DescriptiveStatistics();
        for(Double valor : conjunto)
            estatistica.addValue(valor);
        return estatistica.getGeometricMean();
    }

    /**
     * Raiz da soma dos quadrados divididos pelo número de elementos. RMS(Root
     * Mean Square).
     *
     * @param conjunto
     *
     * @return
     */
    public double mediaQuadratica(Lista<Double> conjunto){
        DescriptiveStatistics estatistica = new DescriptiveStatistics();
        for(Double valor : conjunto)
            estatistica.addValue(valor);
        return estatistica.getQuadraticMean();
    }

    /**
     * Fórmula usada quando se conhece todos os elementos de um dado conjunto,
     * nete caso os valores informados. É a medida de que representa a média do
     * quão afastados estãos os elementos de sua média. Esta medida é de mais
     * fácil compreensão se comparada com a variância pois seus valores não
     * estão elevados ao quadrado.
     *
     * @param conjunto
     *
     * @return
     */
    public double desvioPadrao(Lista<Double> conjunto){
        DescriptiveStatistics estatistica = new DescriptiveStatistics();
        for(Double valor : conjunto)
            estatistica.addValue(valor);
        return estatistica.getStandardDeviation();
    }

    /**
     * Compreendido entre a média e a moda, este valor representa o valor
     * central da distribuição, divide o conjunto de dados em duas partes
     * iguais.
     *
     * @param conjunto
     *
     * @return
     */
    public double mediana(Lista<Double> conjunto){
        DescriptiveStatistics estatistica = new DescriptiveStatistics();
        for(Double valor : conjunto)
            estatistica.addValue(valor);
        return estatistica.getMean();
    }

    /**
     *
     * @param conjunto
     *
     * @return O maior valor do conjunto de dados informado.
     */
    public double maximo(Lista<Double> conjunto){
        DescriptiveStatistics estatistica = new DescriptiveStatistics();
        for(Double valor : conjunto)
            estatistica.addValue(valor);
        return estatistica.getMax();
    }

    /**
     *
     * @param conjunto
     *
     * @return O menor valor do conjunto de dados informado.
     */
    public double minimo(Lista<Double> conjunto){
        DescriptiveStatistics estatistica = new DescriptiveStatistics();
        for(Double valor : conjunto)
            estatistica.addValue(valor);
        return estatistica.getMin();
    }

    public long numeroDeTermos(Lista<Double> conjunto){
        DescriptiveStatistics estatistica = new DescriptiveStatistics();
        for(Double valor : conjunto)
            estatistica.addValue(valor);
        return estatistica.getN();
    }

    public double soma(Lista<Double> conjunto){
        DescriptiveStatistics estatistica = new DescriptiveStatistics();
        for(Double valor : conjunto)
            estatistica.addValue(valor);
        return estatistica.getSum();
    }

    public double somaDosQuadrados(Lista<Double> conjunto){
        DescriptiveStatistics estatistica = new DescriptiveStatistics();
        for(Double valor : conjunto)
            estatistica.addValue(valor);
        return estatistica.getSumsq();
    }

    /**
     * Fórmula usada quando NÃO se conhece todos os elementos de um dado
     * conjunto, isto é, quando pegamos apenas uma pequena parcela para
     * representar um todo maior. É a medida de que representa a média do quão
     * afastados estãos os elementos de sua média. Contudo esta medida pode ser
     * de difícil interpretação uma vez que seus valores estão elevados ao
     * quadrado.
     *
     * @param conjunto
     *
     * @return
     */
    public double varianciaDaAmostra(Lista<Double> conjunto){
        DescriptiveStatistics estatistica = new DescriptiveStatistics();
        for(Double valor : conjunto)
            estatistica.addValue(valor.doubleValue());
        return estatistica.getVariance();
    }

    /**
     * Fórmula usada quando se conhece todos os elementos de um dado conjunto. É
     * a medida de que representa a média do quão afastados estãos os elementos
     * de sua média. Contudo esta medida pode ser de difícil interpretação uma
     * vez que seus valores estão elevados ao quadrado.
     *
     * @param conjunto
     *
     * @return
     */
    public double varianciaDaPopulacao(Lista<Double> conjunto){
        DescriptiveStatistics estatistica = new DescriptiveStatistics();
        for(Double valor : conjunto)
            estatistica.addValue(valor);
        return estatistica.getPopulationVariance();
    }

    /**
     * Assimetria do conjunto e dado como um valor entre -1 e 1, o ponto central
     * 0 significa que a curva é simétrica enquanto valores negativos indicam
     * inclinação para esquerda, positivos para a direita.
     *
     * @param conjunto
     *
     * @return
     */
    public double assimetria(Lista<Double> conjunto){
        DescriptiveStatistics estatistica = new DescriptiveStatistics();
        for(Double valor : conjunto)
            estatistica.addValue(valor);
        return estatistica.getSkewness();
    }

    public Lista<Double> valoresOrdenados(Lista<Double> conjunto){
        DescriptiveStatistics estatistica = new DescriptiveStatistics();
        Lista<Double> valores = new Lista<Double>();
        for(Double valor : conjunto)
            estatistica.addValue(valor.doubleValue());
        for(double valor : estatistica.getSortedValues())
            valores.adiciona(valor);
        return valores;
    }

    public double percentil(Lista<Double> conjunto, Double percentil){
        DescriptiveStatistics estatistica = new DescriptiveStatistics();
        for(Double valor : conjunto)
            estatistica.addValue(valor);
        return estatistica.getPercentile(percentil);
    }

    /**
     * Medida de achatamento de uma curva de distribuição de frequências.
     *
     * @param conjunto
     *
     * @return
     */
    public double curtose(Lista<Double> conjunto){
        DescriptiveStatistics estatistica = new DescriptiveStatistics();
        for(Double valor : conjunto)
            estatistica.addValue(valor);
        return estatistica.getKurtosis();
    }

    /**
     * Quantidade de vezes que um elemento aparece no conjunto.
     *
     * @param conjunto
     * @param elemento
     *
     * @return
     */
    public long frequenciaAbsoluta(Lista<Double> conjunto, Double elemento){
        Frequency frequencia = new Frequency();
        for(Double valor : conjunto)
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
    public double frequenciaPercentual(Lista<Double> conjunto, Double elemento){
        Frequency frequencia = new Frequency();
        for(Double valor : conjunto)
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
    public Lista<Double> moda(Lista<Double> conjunto){
        Frequency frequencia = new Frequency();
        Lista<Double> moda = new Lista<Double>();
        for(Double valor : conjunto)
            frequencia.addValue(valor);
        for(Comparable d : frequencia.getMode())
            moda.adiciona((Double) d);
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
    public long frequenciaAcumuladaAbsoluta(Lista<Double> conjunto, Double elemento){
        Frequency frequencia = new Frequency();
        for(Double valor : conjunto)
            frequencia.addValue(valor);
        return frequencia.getCumFreq(elemento.doubleValue());
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
    public double frequenciaAcumuladaPercentual(Lista<Double> conjunto, Double elemento){
        Frequency frequencia = new Frequency();
        for(Double valor : conjunto)
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
    public long somaDasFrequencias(Lista<Double> conjunto){
        Frequency frequencia = new Frequency();
        for(Double valor : conjunto)
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
    public int numeroDeElementosDistintos(Lista<Double> conjunto){
        Frequency frequencia = new Frequency();
        for(Double valor : conjunto)
            frequencia.addValue(valor);
        return frequencia.getUniqueCount();
    }
}
