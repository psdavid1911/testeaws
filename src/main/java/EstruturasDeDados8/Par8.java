package EstruturasDeDados8;

public class Par8<X extends Comparable, Y> implements Comparable<Par8<X, Y>>{
    private X x;
    private Y y;

    public Par8(X x, Y y){
        this.x = x;
        this.y = y;
    }

    public X getX(){
        return x;
    }

    public void setX(X x){
        this.x = x;
    }

    public Y getY(){
        return y;
    }

    public void setY(Y y){
        this.y = y;
    }

    @Override
    public int compareTo(Par8<X, Y> outro){
        return this.x.compareTo(outro.x);
    }

    @Override
    public String toString(){
        return "("+"x="+x+", y="+y+')';
    }
    
    
}
