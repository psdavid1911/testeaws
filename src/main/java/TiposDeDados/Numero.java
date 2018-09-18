package TiposDeDados;

public class Numero extends Number implements Comparable<Number>{

    Number numero;

    public Numero( Number numero ){
        this.numero=numero;
    }

    @Override
    public int intValue(){
        return numero.intValue();
    }

    @Override
    public long longValue(){
        return numero.longValue();
    }

    @Override
    public float floatValue(){
        return numero.floatValue();
    }

    @Override
    public double doubleValue(){
        return numero.doubleValue();
    }

    @Override
    public int compareTo( Number outro ){
        Long l1 = numero.longValue();
        Long l2 = outro.longValue();
        return l1.compareTo(l2);
    }
}
