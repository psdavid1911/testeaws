package TiposDeDados;

public class Trio<T1, T2, T3>{

    public T1 t1;
    public T2 t2;
    public T3 t3;

    public Trio(T1 t1, T2 t2, T3 t3){
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Trio)
            return toString().equals(((Trio) obj).toString());
        return false;
    }

    @Override
    public String toString(){
        String s = "";
        s += "t1:: " + t1 + "\n";
        s += "t2:: " + t2 + "\n";
        s += "t3:: " + t3 + "";
        return s;
    }
}
