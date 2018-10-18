package GeometriaAnalitica;

public enum Quadrante{
    PRIMEIRO(1), SEGUNDO(2), TERCEIRO(3), QUARTO(4);
    private final int valor;

    public int getValor(){
        return valor;
    }

    Quadrante(int valor){
        this.valor = valor;
    }
}
