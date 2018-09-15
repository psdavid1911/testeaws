package GeometriaAnalitica;

import static GeometriaAnalitica.Quadrante.PRIMEIRO;
import static GeometriaAnalitica.Quadrante.QUARTO;
import static GeometriaAnalitica.Quadrante.SEGUNDO;
import static GeometriaAnalitica.Quadrante.TERCEIRO;
import static java.lang.Math.sqrt;

/**
 * Essa classe trabalha apenas com valores Double de forma que os cálculos sejam
 * simplificados
 * 
 * 
 * 
 * Parei no 2.7
 *
 * @author psdav
 */
public class Ponto{

    private Quadrante q;
    private Double x;
    private Double y;

    public Ponto(){
        x=0.;
        y=0.;
        setaQuadrante();
    }

    public Ponto(Double x, Double y){
        this.x=x;
        this.y=y;
        setaQuadrante();
    }

    public Double deltaX(Ponto extremoFinal){
        return x-extremoFinal.x;
    }

    public Double deltaY(Ponto extremoFinal){
        return y-extremoFinal.y;
    }

    public Double distanciaPara(Ponto extremidadeFinal){
        return sqrt(this.deltaX(extremidadeFinal)*this.deltaX(extremidadeFinal)
                +(this.deltaY(extremidadeFinal)*this.deltaY(extremidadeFinal)));
    }

    public Quadrante getQ(){
        return q;
    }

    public Double getX(){
        return x;
    }

    public void setX(Double x){
        this.x=x;
        setaQuadrante();
    }

    public Double getY(){
        return y;
    }

    public void setY(Double y){
        this.y=y;
        setaQuadrante();
    }

    public void imprime(){
        System.out.println(this);
    }

    public Ponto pontoMedio(Ponto pFinal){
        return new Ponto((x+pFinal.x)/2, (y+pFinal.y)/2);
    }

    public Double razaoDeSeccao(Ponto pIntermediario, Ponto pFinal){
        return this.deltaX(pIntermediario)/pIntermediario.deltaX(pFinal);
    }

    public Ponto simetricoPelaAbscissa(){
        return new Ponto(getX(), -getY());
    }

    public Ponto simetricoPelaOrdenada(){
        return new Ponto(-getX(), getY());
    }

    public Ponto simetricoPelaOrigem(){
        return new Ponto(-getX(), -getY());
    }

    @Override
    public String toString(){
        return "p{"+x+", "+y+"}\n"
                +"Quadrante: "+q.toString();
    }

    private void setaQuadrante(){
        if(getX()>0&&getY()>0)q=PRIMEIRO;
        else if(getX()<0&&getY()>0)q=SEGUNDO;
        else if(getX()<0&&getY()<0)q=TERCEIRO;
        else q=QUARTO;
    }
}
