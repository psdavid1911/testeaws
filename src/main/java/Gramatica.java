import java.util.Arrays;

public final class Gramatica{

    public static String consertaFormatacao(String cadeia){
        cadeia=cadeia.replaceAll(" -> ","->");
        cadeia=cadeia.replaceAll(" ->","->");
        cadeia=cadeia.replaceAll("-> ","->");
        cadeia=cadeia.replaceAll(" , ",",");
        cadeia=cadeia.replaceAll(", ",",");
        cadeia=cadeia.replaceAll(" ,",",");
        return cadeia;
    }

    public static Grafo<Lista<String>> pegaGramatica(){
        Grafo<Lista<String>> g=new Grafo<Lista<String>>();
        String dadosDeGramatica="Adjetivo,Substantivo->Determinante,Substantivo\n"
                +"Adjunto,Adjetivo->Adjunto adverbial\n"
                +"Adjunto,Advérbio->Adjunto adverbial\n"
                +"Adjunto,Verbo->Adjunto adverbial\n"
                +"Advérbio,Substantivo->Determinante,Substantivo\n"
                +"Advérbio,Sujeito,Verbo->Sujeito,Verbo\n"
                +"Artigo,Substantivo->Determinante,Substantivo\n"
                +"Complemento,Determinante,Substantivo->Complementos\n"
                +"Determinante,Substantivo,Verbo->Sujeito,Verbo\n"
                +"Determinante,Sujeito,Verbo->Sujeito,Verbo\n"
                +"Frase->Período\n"
                +"Locução Adverbial->Advérbio\n"
                +"Locução Adverbial->Complemento\n"
                +"Numeral->Pos-determinante\n"
                +"Predicado complexo,Complemento->Predicado complexo\n"
                +"Predicado simples,Complemento->Predicado complexo\n"
                +"Predicado simples,Complementos->Predicado complexo\n"
                +"Predicado simples,Complementos->Predicado complexo\n"
                +"Predicado simples->Período\n"
                +"Preposição,Adjetivo->Locução Adverbial\n"
                +"Preposição,Advérbio->Locução Adverbial\n"
                +"Preposição,Substantivo->Locução Adverbial\n"
                +"Preposição,Sujeito->Locução Adverbial\n"
                +"Pronome demonstrativo->Pronome\n"
                +"Pronome indefinido->Pronome\n"
                +"Pronome pessoal do caso reto,Verbo->Sujeito,Verbo\n"
                +"Pronome pessoal do caso reto->Pronome\n"
                +"Pronome possessivo->Pos-determinante\n"
                +"Pronome,Adjetivo,Substantivo->Determinante,Substantivo\n"
                +"Pronome,Advérbio,Verbo->Sujeito,Verbo\n"
                +"Pronome,Preposição,Pronome pessoal do caso reto->Sujeito\n"
                +"Pronome,Substantivo,Verbo intransitivo->Sujeito,Verbo intransitivo\n"
                +"Pronome,Substantivo,Verbo transitivo->Sujeito,Verbo transitivo\n"
                +"Pronome,Substantivo,Verbo->Sujeito,Verbo\n"
                +"Pronome,Substantivo->Determinante,Substantivo\n"
                +"Pronome,Sujeito->Sujeito\n"
                +"Pronome,Verbo->Sujeito,Verbo\n"
                +"Substantivo,Advérbio->Substantivo,Determinante\n"
                +"Substantivo,Verbo->Sujeito,Verbo\n"
                +"Sujeito,Advérbio,Verbo->Sujeito,Verbo\n"
                +"Sujeito,Predicado complexo->Período\n"
                +"Sujeito,Predicado simples->Período\n"
                +"Sujeito,Verbo->Sujeito,Predicado simples\n"
                +"Verbo de ligação,Adjetivo->Verbo,Complemento\n"
                +"Verbo impessoal->Verbo\n"
                +"Verbo intransitivo->Verbo\n"
                +"Verbo transitivo->Verbo\n"
                +"Verbo,Adjunto adnominal,Substantivo->Verbo,Complemento\n"
                +"Verbo,Adjunto adverbial,Substantivo->Verbo,Complemento\n"
                +"Verbo,Adjunto,Substantivo->Verbo,Adjunto adnominal,Substantivo\n"
                +"Verbo,Advérbio->Verbo,Complemento\n"
                +"Verbo,Complemento,Complemento->Verbo,Complementos\n"
                +"Verbo,Complemento,Complementos->Verbo,Complementos\n"
                +"Verbo,Complemento->Predicado simples\n"
                +"Verbo,Complemento->Verbo transitivo,Complemento\n"
                +"Verbo,Complementos,Complemento->Verbo,Complementos\n"
                +"Verbo,Complementos->Predicado complexo\n"
                +"Verbo,Determinante,Substantivo->Verbo,Complemento\n"
                +"Verbo,Locução adverbial->Advérbio\n"
                +"Verbo,Pronome pessoal do caso reto->Verbo,Complemento\n"
                +"Verbo,Pronome,Substantivo->Verbo,Complemento\n"
                +"Verbo,Substantivo,Artigo,Substantivo->Verbo,Complementos\n"
                +"Verbo,Substantivo,Determinante->Verbo,Complemento\n"
                +"Verbo,Substantivo->Verbo,Complemento\n"
                +"Verbo,Sujeito->Verbo,Complemento\n"
                +"Verbo->Período";
        for(String linha:dadosDeGramatica.split("\n")){
            linha=consertaFormatacao(linha);
            String argumentos[]=linha.split("->");
            g.adicionaAresta(new Lista(Arrays.asList(argumentos[0].split(","))),new Lista(Arrays.asList(argumentos[1].split(","))));
        }
        return g;
    }
}
