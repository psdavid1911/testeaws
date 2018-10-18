package EstruturasDeDados;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

public class Pilha<T extends Comparable<T>> implements Iterable<T>{

    Stack<T> pilha = new Stack<T>();

    public void adiciona(T elemento){
        pilha.add(elemento);
    }

    /**
     * Difere de adiciona, apenas por retornar o mesmo elemento que lhe foi
     * informado.
     *
     * @param elemento
     *
     * @return
     */
    public T adiciona2(T elemento){
        return pilha.push(elemento);
    }

    /**
     * Método destrutivo, pega o próximo elemento da pilha, mas remove-o no fim.
     *
     * @return Gera uma exceção se a pilha estiver vazia.
     */
    public T proximoDaPilha(){
        try{
            return pilha.pop();
        } catch (EmptyStackException ex){
            return null;
        }
    }

    /**
     * Método NÃO destrutivo pega(olha) primeiro elemento da pilha, sem
     * remove-lo.
     *
     * @return Gera uma exceção se a pilha estiver vazia
     */
    public T pega(){
        return pilha.peek();
    }

    /**
     *
     * @param elemento
     *
     * @return Retorna a posição do elemento na pilha.
     */
    public int busca(T elemento){
        return pilha.search(elemento);
    }

    public boolean vazia(){
        return pilha.isEmpty();
    }

    @Override
    public Iterator<T> iterator(){
        return pilha.iterator();
    }

    public void limpa(){
        pilha.clear();
    }

    public int tamanho(){
        return pilha.size();
    }

    public Lista<T> pegaLista(){
        return new Lista(Arrays.asList(pilha.toArray()));
    }

    public void empilha(T elemento){
        adiciona(elemento);
    }

    public T desempilha(){
        return proximoDaPilha();
    }
}
