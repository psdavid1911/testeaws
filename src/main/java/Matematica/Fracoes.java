package Matematica;

import org.apache.commons.math3.fraction.Fraction;

public class Fracoes{
    final Fraction fracao;

    public Fracoes(double valor){
        fracao = new Fraction(valor);
    }

    public Fracoes(Integer numerador, Integer denominador){
        fracao = new Fraction(numerador, denominador);
    }
}
