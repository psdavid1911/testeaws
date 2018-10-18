package Ordenacao;

import EstruturasDeDados.Lista;

public class Meu{

    public static void ordena(Lista<Integer> l){
        Lista<Integer> ordenada = new Lista<>();
        while (!l.isEmpty()){
            Integer menor = l.menorElemento();
            ordenada.add(menor);
            l.remove(menor);
        }
        l.addAll(ordenada);
    }

    public static void ordenaPessimo1(Lista<Integer> l){
        for (int i = 0; i < l.size() - 1; i++)
            if (l.pega(i) > l.pega(i + 1)){
                l.trocaElementos(i, i + 1);
                i = -1;
            }
    }
}
