
import java.util.HashMap;

public class TabelaHash<CHAVE,VALOR> extends HashMap<CHAVE,VALOR>{

    // Acrescentar para Strings
    // Adicionar para enviar erro;
    /**
     * Cuidado ao executar, verifique se os dados foram REALMENTE inseridos
     *
     * @param chave
     * @param valor
     */
    public void adicionaSomando(CHAVE chave,VALOR valor){
        if(valor instanceof Number){
            // SE FOR INTEIRO
            if(valor.getClass().getName().equals(Double.class.getName())){
                Double valorAnterior=(Double)put(chave,valor);
                if(valorAnterior!=null){
                    Double novoValor=((Number)valor).doubleValue()+valorAnterior;
                    put(chave,(VALOR)novoValor);
                }
            }
            // SE FOR DOUBLE
            if(valor.getClass().getName().equals(Integer.class.getName())){
                Integer valorAnterior=(Integer)put(chave,valor);
                if(valorAnterior!=null){
                    Integer novoValor=((Number)valor).intValue()+valorAnterior;
                    put(chave,(VALOR)novoValor);
                }
            }
        }else
            put(chave,valor);
    }
}
