package EstruturasDeDados;

import AnalisadorSintatico.ManipuladorGrafo;
import static java.lang.Double.MAX_VALUE;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class ForcasGrafo{

    public Double C;
    public Double K;
    public Double TOLERANCIA;
    public TabelaHash<Lista<String>, Dupla<Double>> VERTICES;
    public Grafo<Lista<String>> grafo;
    public Double t;

    public ForcasGrafo(ManipuladorGrafo g, Dupla<Double> coordenadasIniciais){
        this.TOLERANCIA=25d;
        this.t=0.9;
        this.VERTICES=new TabelaHash<Lista<String>, Dupla<Double>>();
        this.K=100.0;
        this.C=0.2;
        this.grafo=g.getGrafo();
        Double passo=15.;
        for(Lista<String> vertice:grafo.pegaVertices()){
            VERTICES.adiciona(vertice, new Dupla<Double>(coordenadasIniciais.X+passo, coordenadasIniciais.Y+passo));
            passo+=15;
        }
    }

    public Dupla<Double> itera(Dupla<Double> x){
        Boolean naoCovergido=true;
        Double passo=100.0;
        Double energia=MAX_VALUE;
        while(naoCovergido){
            Dupla<Double> x0=x;
            Double energia0=energia;
            energia=0d;
            for(Lista<String> vertice:grafo.pegaVertices()){
                Dupla<Double> forca=forca(vertice);
                Dupla<Double> vAtual=VERTICES.get(vertice);
                Dupla<Double> atualizado=soma(vAtual, multiplica(passo, multiplica(1/norma2(forca, forca), forca)));
                vAtual.X=atualizado.X;
                vAtual.Y=atualizado.Y;
                energia+=pow(norma2(forca, forca), 2);
            }
            passo=atualiza_passo(passo, energia, energia0);
            if(norma2(x0, x)<K*TOLERANCIA)naoCovergido=false;
        }
        return x;
    }

    private Double atualiza_passo(Double passo, Double energia, Double energia0){
        Double progresso=0d;
        if(energia<energia0){
            progresso+=1d;
            if(progresso>=5)
                passo/=t;
        }else passo*=t;
        return passo;
    }

    private Dupla<Double> diferenca(Lista<String> i, Lista<String> j){
        Dupla<Double> vi=VERTICES.get(i);
        Dupla<Double> vj=VERTICES.get(j);
        return new Dupla<Double>(vj.X-vi.X, vj.Y-vi.Y);
    }

    private Dupla<Double> forca(Lista<String> i){
        Dupla<Double> repulsao=new Dupla<Double>(0d, 0d);
        Dupla<Double> atracao=new Dupla<Double>(0d, 0d);
        for(Lista<String> j:grafo.pegaAdjascentes(i)){
            Double norma2=norma2(i, j);
            Double forcaAtracao=pow(norma2, 2)/K;
            Double aux=forcaAtracao/norma2;
            atracao=soma(atracao, multiplica(aux, diferenca(i, j)));
        }
        for(Lista<String> j:grafo.pegaVertices())
            if(!j.equals(i)){
                Double forcaRepulsao=(-C*pow(K, 2))/norma2(i, j)/norma2(i, j);
                Dupla<Double> soma=soma(repulsao, multiplica(forcaRepulsao, diferenca(i, j)));
                repulsao=soma;
            }
        return new Dupla<Double>(atracao.X+repulsao.X, atracao.Y+repulsao.Y);
    }

    private Dupla<Double> multiplica(Double escalar, Dupla<Double> vf){
        return new Dupla<Double>(vf.X*escalar, vf.Y*escalar);
    }

    private Double norma2(Lista<String> i, Lista<String> j){
        Dupla<Double> d=diferenca(i, j);
        return sqrt(pow(d.X, 2)+pow(d.Y, 2));
    }

    private Double norma2(Dupla<Double> i, Dupla<Double> j){
        if(i.equals(j))j=new Dupla<Double>(0., 0.);
        Dupla<Double> d=new Dupla<Double>(j.X-i.X, j.Y-i.Y);
        return sqrt(pow(d.X, 2)+pow(d.Y, 2));
    }

    private Dupla<Double> soma(Dupla<Double> vi, Dupla<Double> vf){
        return new Dupla<Double>(vf.X+vi.X, vf.Y+vi.Y);
    }
}
