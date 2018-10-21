package EstruturasDeDados;

public class Dupla<T extends Comparable<T>> implements Comparable<Dupla<T>>{

    public T X;
    public T Y;

    public Dupla(T x, T y){
        this.X = x;
        this.Y = y;
    }

    @Override
    public int compareTo(Dupla<T> outra){
        return this.X.compareTo(outra.X);
    }

      public boolean equals(Dupla<T> outra){
        return this.X.equals(outra.X) && this.Y.equals(outra.Y);
    }

    public void imprime(){
        System.out.println(this);
    }

 
  
    public void setXY(T X, T Y){
        this.X = X;
        this.Y = Y;
    }

    @Override
    public String toString(){
        return "(" + "x=" + X + ", y=" + Y + ')';
    }

   
  
}
