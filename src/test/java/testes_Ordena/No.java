package testes_Ordena;

import javafx.scene.control.Button;

public class No implements Comparable<No>{

    public Button b;
    public Integer i;
    public double x;
    public double y;

    public No(Button b, Integer i, double x, double y){
        this.b = b;
        this.i = i;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(No outra){
        return this.i.compareTo(outra.i);
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof No){
            No outro = (No) obj;
            return outro.i.equals(this.i) && outro.x == this.x && outro.y == this.y && outro.b.equals(this.b);
        }
        return false;
    }

    @Override
    public String toString(){
        return "{i: " + i + ",x: " + x + ",y:  " + y + "}";
    }
}
