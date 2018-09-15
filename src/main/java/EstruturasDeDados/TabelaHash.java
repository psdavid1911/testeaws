package EstruturasDeDados;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiConsumer;

/**
 *
 * @author david
 * @param <CHAVE>
 * @param <VALOR>
 */
public class TabelaHash<CHAVE, VALOR> extends TreeMap<CHAVE, VALOR>{

    /**
     * Substitui o valor antigo ou retorna nulo se não hover valor antigo.
     *
     * @param chave
     * @param valor
     *
     * @return
     */
    public VALOR adiciona( CHAVE chave, VALOR valor ){
        return put(chave, valor);
    }

    // Acrescentar para Strings
    // Adicionar para enviar erro;
    /**
     * Cuidado ao executar, verifique se os dados foram REALMENTE inseridos
     *
     * @param chave
     * @param valor
     */
    public void adicionaSomando( CHAVE chave, VALOR valor ){
        if( valor instanceof Number ){
            // SE FOR INTEIRO
            if( valor.getClass().getName().equals(Double.class.getName()) ){
                Double valorAnterior=(Double)adiciona(chave, valor);
                if( valorAnterior != null ){
                    Double novoValor=((Number)valor).doubleValue() + valorAnterior;
                    adiciona(chave, (VALOR)novoValor);
                }
            }
            // SE FOR DOUBLE
            if( valor.getClass().getName().equals(Integer.class.getName()) ){
                Integer valorAnterior=(Integer)adiciona(chave, valor);
                if( valorAnterior != null ){
                    Integer novoValor=((Number)valor).intValue() + valorAnterior;
                    adiciona(chave, (VALOR)novoValor);
                }
            }
        }else
            adiciona(chave, valor);
    }

    public Set<Entry<CHAVE, VALOR>> conjunto(){
        return entrySet();
    }

    public boolean contemChave( CHAVE chave ){
        return containsKey(chave);
    }

    public boolean contemValor( VALOR valor ){
        return containsValue(valor);
    }

    public void imprime(){
        System.out.println(toString());
    }

    public void limpa(){
        clear();
    }

    public TreeMap<CHAVE, VALOR> original(){
        return this;
    }

    public void paraCada( BiConsumer<? super CHAVE, ? super VALOR> expressaoLambda ){
        forEach(expressaoLambda);
    }

    /**
     * Retorna nulo se nenhum valor for encontrado
     *
     * @param chave
     *
     * @return
     */
    public VALOR pega( CHAVE chave ){
        return get(chave);
    }

    public int tamanho(){
        return size();
    }

    @Override
    public String toString(){
        String saida="{\n";
        for( Entry<CHAVE, VALOR> entrada:conjunto() )
            saida+=entrada.getKey().toString() + "   /    " + entrada.getValue().toString() + "\n";
        return saida;
    }

    public Collection<VALOR> valores(){
        return values();
    }

    public boolean vazio(){
        return isEmpty();
    }
}
