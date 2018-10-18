package EstruturasDeDados;

import java.util.ArrayList;

public class Vertice implements Comparable<Vertice>{

    public ArrayList<String> vertice = new ArrayList<>();

    Vertice(String v1){
        vertice.add(v1);
    }

    @Override
    public int compareTo(Vertice outroVertice){
        return vertice.toString().compareTo(outroVertice.toString());
    }

    @Override
    public boolean equals(Object objeto){
        if (objeto instanceof Vertice)return this.vertice.toString().equals(((Vertice) objeto).toString());
        else return false;
    }

    public void imprime(){
        System.out.println(vertice);
    }

    public ArrayList<String> pegaPrimitivo(){
        return vertice;
    }

    @Override
    public String toString(){
        return vertice.toString();
    }
}
