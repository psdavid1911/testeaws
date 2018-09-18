package EstruturasDeDados;

import AnalisadorSintatico.ManipuladorGrafo;
import static java.lang.Double.MAX_VALUE;
import static java.lang.Math.sqrt;

public class ForcasGrafo_1{

    public Double C;
    public Double K;
    public Double TOLERANCIA;
    public TabelaHash<Lista<String>, Dupla<Double>> VERTICES;
    public GrafoBaixoAcoplamento<Lista<String>> grafo;
    public Double progresso=0d;
    public Double t;

    public ForcasGrafo_1( ManipuladorGrafo g, Dupla<Double> coordenadasIniciais, Double LARGURA, Double ALTURA ){
        this.TOLERANCIA=25d;
        this.t=0.9;
        this.VERTICES=new TabelaHash<Lista<String>, Dupla<Double>>();
        this.C=0.2;
        this.K=sqrt(ALTURA * LARGURA);
        this.grafo=g.getGrafo();
        Double passo=15.;
        for( Lista<String> vertice:grafo.pegaVertices() ){
            VERTICES.adiciona(vertice, new Dupla<Double>(coordenadasIniciais.X + passo, coordenadasIniciais.Y + passo));
            passo+=15;
        }
    }

    public void itera() throws Exception{
        Boolean naoCovergido=true;
        Double passo=100.0;
        Double energia=MAX_VALUE;
        while( naoCovergido ){
            TabelaHash<Lista<String>, Dupla<Double>> VERTICES_INICIAL=VERTICES;
            Double energia0=energia;
            energia=0d;
            for( Lista<String> i:VERTICES.keySet() ){
                Dupla<Double> forca=new Dupla<Double>(0., 0.);
                for( Lista<String> j:grafo.pegaAdjascentes(i) )
                    forca=forca.mais(forcaDeAtracao(i, j));
                for( Lista<String> j:VERTICES.keySet() )
                    if( !j.equals(i) )
                        forca=forca.mais(forcaDeRepulsao(i, j));
                Dupla<Double> xi=vertice(i);
                xi=xi.mais(forca.vezes(passo / forca.norma()));
                vertice(i).setXY(xi.X, xi.Y);
                energia+=forca.norma() * forca.norma();
            }
            passo=atualiza(passo, energia, energia0);
            if( norma2(VERTICES_INICIAL, VERTICES) < K * TOLERANCIA )naoCovergido=false;
        }
    }

    public Dupla<Double> vertice( Lista<String> i ){
        return VERTICES.pega(i);
    }

    private Double atualiza( Double passo, Double energia, Double energia0 ){
        if( energia < energia0 ){
            progresso+=1d;
            if( progresso >= 5 )
                passo/=t;
        }else passo*=t;
        return passo;
    }

    private Dupla<Double> forcaDeAtracao( Lista<String> i, Lista<String> j ) throws Exception{
        Dupla<Double> norma=vertice(i).menos(vertice(j));
        return norma.quadrado().vezes(1 / K);
    }

    private Dupla<Double> forcaDeRepulsao( Lista<String> i, Lista<String> j ) throws Exception{
        Dupla<Double> norma=vertice(i).menos(vertice(j));
        return norma.inverso().vezes((-C * (K * K)));
    }

    private Double norma2( TabelaHash<Lista<String>, Dupla<Double>> x0, TabelaHash<Lista<String>, Dupla<Double>> x ) throws Exception{
        Lista<Double> distancias=new Lista<Double>();
        for( Lista<String> chave:x.keySet() )
            distancias.add(x0.pega(chave).norma(x.pega(chave)));
        return distancias.valorMaximo();
    }
}
