package EstruturasDeDados;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Dupla<T extends Comparable<T>> implements Comparable<Dupla<T>>{

    public T X;
    public T Y;

    public Dupla(T x, T y){
        this.X = x;
        this.Y = y;
    }

    @Override
    public int compareTo(Dupla<T> outra){
        return this.X.compareTo(outra.X);
    }

    /**
     * Norma euclidiana 2-norm Esta menos a outra
     *
     * @param escalar
     * @return
     * @throws Exception
     */
    public Double norma(Dupla<Double> outra) throws Exception{
        if ((Object) X instanceof Double){
            Dupla<Double> esta = (Dupla<Double>) this;
            Dupla<Double> aux = esta.menos(outra);
            return sqrt(pow(aux.X, 2) + pow(aux.Y, 2));
        }
        throw new Exception("Essa classe não pode ser adicionada pois esta não tem campos double");
    }

    public Dupla<Double> dividido(Double escalar) throws Exception{
        if ((Object) X instanceof Double){
            Dupla<Double> esta = (Dupla<Double>) this;
            return new Dupla<Double>(esta.X / escalar, esta.Y / escalar);
        }
        throw new Exception("Essa classe não pode ser adicionada pois esta não tem campos double");
    }

    public boolean equals(Dupla<T> outra){
        return this.X.equals(outra.X) && this.Y.equals(outra.Y);
    }

    public void imprime(){
        System.out.println(this);
    }

    public Dupla<Double> mais(Dupla<Double> outra) throws Exception{
        if ((Object) X instanceof Double){
            Dupla<Double> esta = (Dupla<Double>) this;
            return new Dupla<Double>(esta.X + outra.X, esta.Y + outra.Y);
        }
        throw new Exception("Essa classe não pode ser adicionada pois esta não tem campos double");
    }

    public Dupla<Double> menos(Dupla<Double> outra) throws Exception{
        if ((Object) X instanceof Double){
            Dupla<Double> esta = (Dupla<Double>) this;
            return new Dupla<Double>(esta.X - outra.X, esta.Y - outra.Y);
        }
        throw new Exception("Essa classe não pode ser adicionada pois esta não tem campos double");
    }

    public Double interno(Dupla<Double> outra) throws Exception{
        if ((Object) X instanceof Double){
            Dupla<Double> esta = (Dupla<Double>) this;
            return esta.X * outra.X + esta.Y * outra.Y;
        }
        throw new Exception("Essa classe não pode ser adicionada pois esta não tem campos double");
    }

    /**
     * Norma euclidiana 2-norm
     *
     * @param escalar
     * @return
     * @throws Exception
     */
    public Double norma() throws Exception{
        if ((Object) X instanceof Double){
            Dupla<Double> esta = (Dupla<Double>) this;
            return sqrt(pow(esta.X, 2) + pow(esta.Y, 2));
        }
        throw new Exception("Essa classe não pode ser adicionada pois esta não tem campos double");
    }

    public Dupla<Double> quadrado() throws Exception{
        if ((Object) X instanceof Double){
            Dupla<Double> esta = (Dupla<Double>) this;
            return new Dupla<Double>(esta.X * esta.X, esta.Y * esta.Y);
        }
        throw new Exception("Essa classe não pode ser adicionada pois esta não tem campos double");
    }

    public void setXY(T X, T Y){
        this.X = X;
        this.Y = Y;
    }

    @Override
    public String toString(){
        return "(" + "x=" + X + ", y=" + Y + ')';
    }

    public Dupla<Double> vezes(Double escalar) throws Exception{
        if ((Object) X instanceof Double){
            Dupla<Double> esta = (Dupla<Double>) this;
            return new Dupla<Double>(esta.X * escalar, esta.Y * escalar);
        }
        throw new Exception("Essa classe não pode ser adicionada pois esta não tem campos double");
    }

    public Dupla<Double> inverso() throws Exception{
        if ((Object) X instanceof Double){
            Dupla<Double> esta = (Dupla<Double>) this;
            return new Dupla<Double>(1 / esta.X, 1 / esta.Y);
        }
        throw new Exception("Essa classe não pode ser adicionada pois esta não tem campos double");
    }
}
