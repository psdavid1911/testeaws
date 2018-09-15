package Matematica;

import EstruturasDeDados.Lista;
import EstruturasDeDados.Par;
import EstruturasDeDados.TabelaHash;
import java.util.Map.Entry;
import org.apache.commons.math3.stat.regression.SimpleRegression;

/**
 * Pelo menos 3 dados devem ser inseridos para que se possa fazer alguma
 * projeção, contudo, apenas dois são necessários para se calcular os
 * coeficientes em y = ax + b.
 *
 * @author david
 */
public class RegressaoLinearSimples{

    SimpleRegression regressaoLinear=new SimpleRegression();

    public void adicionaDado( double valor1, double valor2 ){
        regressaoLinear.addData(valor1, valor2);
    }

    public double coeficienteAngular(){
        return regressaoLinear.getSlope();
    }

    public double coeficienteLinear(){
        return regressaoLinear.getIntercept();
    }

    public double projecaoParaValor( double x ){
        return regressaoLinear.predict(x);
    }

    public double projecaoParaValor( Integer x ){
        return regressaoLinear.predict(x);
    }

    public void adicionaDados( Lista<Par<Double, Double>> dados ){
        for( Par<Double, Double> par:dados )
            regressaoLinear.addData(par.X(), par.Y());
    }

    public void adicionaDados( TabelaHash<Double, Double> dados ){
        for( Entry<Double, Double> par:dados.conjunto() )
            regressaoLinear.addData(par.getKey(), par.getValue());
    }
}
