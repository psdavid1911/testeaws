package Lixeira;

import Lixeira.ClasseVerbete;
import java.util.List;
import java.util.Objects;

public class Verbete{
    String palavra;
    List<ClasseVerbete> classes;

    public Verbete(String palavra, List<ClasseVerbete> classes){
        this.palavra = palavra;
        this.classes = classes;
    }

    @Override
    public int hashCode(){
        int hash = 5;
        hash = 97*hash+Objects.hashCode(this.palavra);
        hash = 97*hash+Objects.hashCode(this.classes);
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
        final Verbete other = (Verbete) obj;
        if(!Objects.equals(this.palavra, other.palavra))
            return false;
        if(!Objects.equals(this.classes, other.classes))
            return false;
        return true;
    }

    @Override
    public String toString(){
        return "Verbete{"+"palavra="+palavra+", classes="+classes+'}';
    }

    public void imprime(){
        System.out.println(toString());
    }
}
