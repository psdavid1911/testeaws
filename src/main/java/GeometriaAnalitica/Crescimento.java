package GeometriaAnalitica;

public enum Crescimento{
    CRESCENTE(0), DECRESCENTE(1);
    private int crescimento;

    private Crescimento( int crescimento ){
        this.crescimento=crescimento;
    }
}
