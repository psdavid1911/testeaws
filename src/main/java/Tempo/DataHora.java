package Tempo;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Objects;

/**
 *
 * @author psdav
 */
public class DataHora{

    LocalDateTime DataHora;

    public DataHora(int dia, Month mes, int ano, int hora, int minutos){
        this.DataHora = LocalDateTime.of(ano, mes, dia, hora, minutos);
    }

    public DataHora(int hora, int minutos){
        this.DataHora = LocalDateTime.of(2018, Month.APRIL, 1, hora, minutos);
    }

    public LocalDateTime getHora(){
        return DataHora;
    }

    @Override
    public String toString(){
        return "DataHora{" + "DataHora=" + DataHora + '}';
    }

    @Override
    public int hashCode(){
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final DataHora other = (DataHora) obj;
        if (!Objects.equals(this.DataHora, other.DataHora))
            return false;
        return true;
    }
}
