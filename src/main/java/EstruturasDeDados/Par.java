package EstruturasDeDados;

public class Par<X extends Comparable<X>, Y> implements Comparable<Par<X, Y>>{

    private X x;
    private Y y;

    public Par(X x, Y y){
        this.x=x;
        this.y=y;
    }

    public X X(){
        return x;
    }

    public Y Y(){
        return y;
    }

    @Override
    public int compareTo(Par<X, Y> outro){
        return this.x.compareTo(outro.x);
    }

    public void setX(X x){
        this.x=x;
    }

    public void setY(Y y){
        this.y=y;
    }

    @Override
    public String toString(){
        return "("+"x="+x+", y="+y+')';
    }
}
