package EstruturasDeDados8;

import java.util.Objects;

/**
 * Classe vértice!!!
 *
 * @author David
 * @param <T>
 */
public class V<T extends Comparable<T>> implements Comparable<V<T>>{
    public T elemento;
    public int x;
    public int y;

    public V(T elemento, int x, int y){
        this.elemento = elemento;
        this.x = x;
        this.y = y;
    }

    public V(T elemento){
        this.elemento = elemento;
        this.x = 0;
        this.y = 0;
    }

    @Override
    public int compareTo(V<T> o){
        return this.elemento.compareTo(o.elemento);
    }

    @Override
    public String toString(){
        return "V{"+"elemento="+elemento+", x="+x+", y="+y+'}';
    }

    @Override
    public int hashCode(){
        int hash = 3;
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
        final V<?> other = (V<?>) obj;
        if(this.x!=other.x)
            return false;
        if(this.y!=other.y)
            return false;
        if(!Objects.equals(this.elemento, other.elemento))
            return false;
        return true;
    }
}
