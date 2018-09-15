package EstruturasDeDados;

import AnalisadorSintatico.ManipuladorGrafo;
import static java.lang.Math.abs;

public class ForcasGrafo{

    public Double CONSTANTE_MOLAR;
    public Double DISTANCIA_MINIMA;
    public Double FORCA_DE_TOLERANCIA;
    public TabelaHash<Lista<String>, Dupla<Double>> VERTICES;
    public Grafo<Lista<String>> grafo;

    public ForcasGrafo(ManipuladorGrafo g, Dupla<Double> coordenadasIniciais, Double LARGURA, Double ALTURA){
        this.CONSTANTE_MOLAR=1.;
        this.FORCA_DE_TOLERANCIA=CONSTANTE_MOLAR*5;
        this.VERTICES=new TabelaHash<Lista<String>, Dupla<Double>>();
        DISTANCIA_MINIMA=15.;
        this.grafo=g.getGrafo();
        Double passo=15.;
        for(Lista<String> vertice:grafo.pegaVertices()){
            VERTICES.adiciona(vertice, new Dupla<Double>(coordenadasIniciais.X+passo, coordenadasIniciais.Y+passo));
            passo+=15;
        }
    }

    public void itera() throws Exception{
        Boolean naoCovergido=true;
        while(naoCovergido){
            for(Lista<String> i:VERTICES.keySet()){
                Dupla<Double> forca=new Dupla<Double>(0., 0.);
                for(Lista<String> j:grafo.pegaAdjascentes(i))
                    forca=forca.mais(forca(i, j));
                for(Lista<String> j:grafo.pegaNaoAdjascentes(i))
                    if(!j.equals(i))
                        forca=forca.mais(forca(i, j));
                naoCovergido= abs(forca.X)>=FORCA_DE_TOLERANCIA||abs(forca.Y)>=FORCA_DE_TOLERANCIA;
                Dupla<Double> posicaoFinal=forca.dividido(CONSTANTE_MOLAR);
                VERTICES.adiciona(i, posicaoFinal);
            }
        }
    }

    public Dupla<Double> vertice(Lista<String> i){
        return VERTICES.pega(i);
    }

    private Dupla<Double> forca(Lista<String> i, Lista<String> j) throws Exception{
        Double forcax=CONSTANTE_MOLAR*(DISTANCIA_MINIMA-vertice(j).X);
        Double forcay=CONSTANTE_MOLAR*(DISTANCIA_MINIMA-vertice(j).Y);
        return new Dupla<Double>(forcax, forcay);
    }
}
