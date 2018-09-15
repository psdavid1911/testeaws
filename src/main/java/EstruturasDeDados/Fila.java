package EstruturasDeDados;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Fila<T> implements Iterable<T>{

    Queue<T> fila=new LinkedList<T>();

    /**
     * Difere de adiciona2 apenas por retornar uma exceção se não for possível
     * adicionar o elemento.
     *
     * @param elemento
     */
    public void adiciona( T elemento ){
        fila.add(elemento);
    }

    /**
     * Difere de adiciona, apenas por retornar um valor booleano de sucesso.
     *
     * @param elemento
     *
     * @return Falso se não pode inserir o elemento na fila.
     */
    public boolean adiciona2( T elemento ){
        return fila.offer(elemento);
    }

    /**
     * Informa o próximo elemento e automaticamente remove-o. O elemento é
     * descartado no processo.
     *
     * @return Causa uma exceção se a fila estiver vazia.
     */
    public T proximoDaFila(){
        return fila.remove();
    }

    /**
     * Informa o próximo elemento e automaticamente remove-o. O elemento é
     * descartado no processo.
     *
     * @return Retorna nulo se a fila estiver vazia.
     */
    public T proximoDaFila2(){
        return fila.poll();
    }

    /**
     * Informa o próximo elemento da fila sem remove-lo. Método não destrutivo
     *
     * @return Causa uma exceção se a fila estiver vazia.
     */
    public T pega(){
        return fila.element();
    }

    /**
     * Informa o próximo elemento da fila sem remove-lo. Método não destrutivo.
     *
     * @return Retorna nulo se a fila estiver vazia.
     */
    public T pega2(){
        return fila.peek();
    }

    /**
     * Método necessário para poder se realizar forEach()
     *
     * @return
     */
    @Override
    public Iterator<T> iterator(){
        return fila.iterator();
    }
}
