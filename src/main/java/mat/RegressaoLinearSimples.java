package mat;
import EstruturasDeDados8.Lista;
import EstruturasDeDados8.Par8;
import EstruturasDeDados8.TabelaHash8;
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

    public void adicionaDado(double valor1,double valor2){
        regressaoLinear.addData(valor1,valor2);
    }

    public double coeficienteAngular(){
        return regressaoLinear.getSlope();
    }

    public double coeficienteLinear(){
        return regressaoLinear.getIntercept();
    }

    public double projecaoParaValor(double x){
        return regressaoLinear.predict(x);
    }

    public double projecaoParaValor(Integer x){
        return regressaoLinear.predict(x);
    }

    public void adicionaDados(Lista<Par8<Double,Double>> dados){
        for(Par8<Double,Double> par:dados)
            regressaoLinear.addData(par.getX(),par.getY());
    }

    public void adicionaDados(TabelaHash8<Double,Double> dados){
        for(Entry<Double,Double> par:dados.conjunto())
            regressaoLinear.addData(par.getKey(),par.getValue());
    }
}
