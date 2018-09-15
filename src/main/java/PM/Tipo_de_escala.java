package PM;

public class Tipo_de_escala implements Comparable<Tipo_de_escala>{

    private int dias_trabalhados;
    private int dias_descansados;

    public int getDias_trabalhados(){
        return dias_trabalhados;
    }

    public void setDias_trabalhados( int dias_trabalhados ){
        this.dias_trabalhados=dias_trabalhados;
    }

    public int getDias_descansados(){
        return dias_descansados;
    }

    public void setDias_descansados( int dias_descansados ){
        this.dias_descansados=dias_descansados;
    }

    public int getDias_do_ciclo(){
        return dias_descansados + dias_trabalhados;
    }

    @Override
    public String toString(){
        return "Tipo_de_escala{" + "dias_trabalhados=" + dias_trabalhados + ", dias_descansados=" + dias_descansados + '}';
    }

    @Override
    public int compareTo( Tipo_de_escala t ){
        return toString().compareTo(t.toString());
    }

    @Override
    public boolean equals( Object obj ){
        if( this == obj )
            return true;
        if( obj == null )
            return false;
        if( getClass() != obj.getClass() )
            return false;
        final Tipo_de_escala other=(Tipo_de_escala)obj;
        if( this.dias_trabalhados != other.dias_trabalhados )
            return false;
        if( this.dias_descansados != other.dias_descansados )
            return false;
        return true;
    }
}
