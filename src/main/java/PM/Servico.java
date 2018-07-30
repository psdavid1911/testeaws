package PM;
import Tempo.DataHora;
import java.util.Objects;

public class Servico implements Comparable<Servico>{

    DataHora inicio;
    DataHora fim;
    String posto;

    public DataHora getInicio(){
        return inicio;
    }

    public void setInicio(DataHora inicio){
        this.inicio=inicio;
    }

    public DataHora getFim(){
        return fim;
    }

    public void setFim(DataHora fim){
        this.fim=fim;
    }

    public String getPosto(){
        return posto;
    }

    public void setPosto(String posto){
        this.posto=posto;
    }

    @Override
    public int compareTo(Servico t){
        return inicio.getHora().compareTo(t.getInicio().getHora());
    }

    @Override
    public String toString(){
        return "Servico{"+"inicio="+inicio+", fim="+fim+", posto="+posto+'}';
    }

    @Override
    public int hashCode(){
        int hash=7;
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj)
            return true;
        if(obj==null)
            return false;
        if(getClass()!=obj.getClass())
            return false;
        final Servico other=(Servico)obj;
        if(!Objects.equals(this.posto,other.posto))
            return false;
        if(!Objects.equals(this.inicio,other.inicio))
            return false;
        if(!Objects.equals(this.fim,other.fim))
            return false;
        return true;
    }
}
