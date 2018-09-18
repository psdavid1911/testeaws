package testes_Imagem;

import EstruturasDeDados.GrafoBaixoAcoplamento;
import EstruturasDeDados.Lista;
import EstruturasDeDados.Par;
import EstruturasDeDados.V;
import Imagem.Imagem;
import java.awt.Color;
import java.util.Map.Entry;
import java.util.Random;
import org.junit.Test;

public class ImagemGrafo{

    GrafoBaixoAcoplamento<V<String>> grafo=new GrafoBaixoAcoplamento<V<String>>();
    Imagem imagem;
    int dimx=1000;
    int dimy=1000;
    int xDoCentro=dimx / 2;
    int yDoCentro=dimy / 2;

    /**
     * Inicializa grafo e imagem
     */
    public ImagemGrafo(){
        imagem=new Imagem(dimx, dimy);
        imagem.corDoFundo(Color.black);
        imagem.desenhaEixoCentral(dimx, dimy);
        //imagem.desenhaEspiralDeArquimedes(xDoCentro, yDoCentro, 1000);
        /**
         * CRIA O GRAFO
         */
        grafo.adicionaAresta(new V("Vertice1"), new V("Vertice2"));
        grafo.adicionaAresta(new V("Vertice2"), new V("Vertice3"));
        grafo.adicionaAresta(new V("Vertice3"), new V("Vertice4"));
        grafo.adicionaAresta(new V("Vertice3"), new V("Vertice3"));
        grafo.adicionaAresta(new V("Vertice3"), new V("Vertice2"));
        grafo.adicionaAresta(new V("Vertice3"), new V("Vertice1"));
        grafo.adicionaAresta(new V("Vertice5"), new V("Vertice2"));
        grafo.adicionaAresta(new V("Vertice2"), new V("Vertice1"));
        grafo.adicionaAresta(new V("Vertice3"), new V("Vertice3"));
        grafo.adicionaAresta(new V("Vertice6"), new V("Vertice5"));
        grafo.adicionaAresta(new V("Vertice3"), new V("Vertice5"));
        grafo.adicionaVertice(new V("Vertice0"));
        imprime(grafo.toString());
    }

    @Test
    public void testaGrafo(){
        System.out.println("\n");
        calculaPosicoes();
        // Visualizacao pelo terminal terminal
        imprime(grafo.toString());
        // CRIA A LINHA
        /**
         * MUITO CUIDADO!!! CUIDADO!!!! OS VALORES DA LISTA INTERNA DO GRAFO NÃO
         * ESTAO SENDO MODIFICADOS MELHORAR!!!!!!!!!!!!
         */
        for( Entry<V<String>, Lista<V<String>>> entrada:grafo.conjunto() )
            for( Entry<V<String>, Lista<V<String>>> entrada2:grafo.conjunto() )
                for( V<String> verticeAdjascente:grafo.pegaVertices() )
                    if( grafo.existeAresta(verticeAdjascente, entrada.getKey()) )
                        imagem.desenhaLinha(Color.yellow, entrada.getKey().x, entrada.getKey().y, verticeAdjascente.x, verticeAdjascente.y);
        for( Entry<V<String>, Lista<V<String>>> entrada:grafo.conjunto() ){
            /**
             * Impressao da bola
             */
            imagem.desenhaCircu(Color.blue, entrada.getKey().x, entrada.getKey().y, imagem.larguraDoTexto(entrada.getKey().elemento));
            imagem.desenhaTexto(Color.white, entrada.getKey().elemento, entrada.getKey().x, entrada.getKey().y);
        }
        imagem.salvaNoArquivo("novografo.jpg");
    }

    public void calculaPosicoes(){
        int contador=0;
        /**
         * Se houver algum vertice cuja distancia e menor q a definida
         * aleatorize
         */
        int distanciaMinima=25; // arbitra uma distancia minima em px
        int distanciaMaxima=100; // arbitra uma distancia maxima em px
        while( contador < 100 ){
            contador++;
            /**
             * Itera por todas as posicoes Atribuindo valores aleatorios
             */
            for( Entry<V<String>, Lista<V<String>>> entrada:grafo.conjunto() ){
                V<String> vertice=entrada.getKey();
                Lista<V<String>> adjascencias=entrada.getValue();
                vertice.x=aleatorioMenorQueMetadeX();
                vertice.y=aleatorioMenorQueMetadeY();
                imprime(vertice.toString()); // ja verifica
                /**
                 * Verifica as distancias com os adjascentes
                 */
                for( V<String> verticeAdjascente:adjascencias ){
                    double distancia;
                    distancia=Math.pow(verticeAdjascente.x - vertice.x, 2);
                    distancia+=Math.pow(verticeAdjascente.y - vertice.y, 2);
                    distancia=Math.sqrt(distancia);
                    if( distancia < distanciaMinima || distancia > distanciaMaxima ){
                        verticeAdjascente.x=aleatorioMenorQueMetadeX();
                        verticeAdjascente.y=aleatorioMenorQueMetadeY();
                    }
                }
                /**
                 * Verifica as distancias com os não adjascentes
                 */
                for( V<String> verticeNaoAdjascente:grafo.pegaNaoAdjascentes(vertice) ){
                    double distancia;
                    distancia=Math.pow(verticeNaoAdjascente.x - vertice.x, 2);
                    distancia+=Math.pow(verticeNaoAdjascente.y - vertice.y, 2);
                    distancia=Math.sqrt(distancia);
                    if( distancia < distanciaMinima ){
                        verticeNaoAdjascente.x=aleatorioMenorQueMetadeX();
                        verticeNaoAdjascente.y=aleatorioMenorQueMetadeY();
                    }
                }
            }
        }
    }

    public void imprime( String s ){
        System.out.println(s);
    }

    public int aleatorioMenorQueMetadeX(){
        int ale=new Random().nextInt(xDoCentro);
        imprime("" + ale);
        return ale;
    }

    public int aleatorioMenorQueMetadeY(){
        int ale=new Random().nextInt(yDoCentro);
        imprime("" + ale);
        return ale;
    }

    /**
     * SEGUNDA IDEIA DE IMPLEMENTAÇÃO FALHOU !!!!!!!
     */
//    public void iteraGrafo(){
//        /**
//         * Calcula as posições relativas pega manipulador de coordenadas do grafo
//         */
//        grafo.paraCadaVertice((verticeFixado, listaDeAdjascencias) -> {
//            double distancia = 0;
//            double forcaDeAtracao = 0;
//            double forcaDeRepulsao = 0;
//            /**
//             * FORCA DE ATRACAO
//             */
//            for(String vertice : grafo.pegaAdjascentes(verticeFixado)){ // percorre as adjascencias do vertice
//                if(vertice.equals(verticeFixado))
//                    continue;
//                parSimples<Integer> v = new parSimples<>(coordenadas.get(verticeFixado).X(), coordenadas.get(verticeFixado).Y());
//                parSimples<Integer> u = new parSimples<>(coordenadas.get(vertice).X(), coordenadas.get(vertice).Y());
//                distancia = Math.sqrt(Math.pow(v.x-u.x, 2)+Math.pow(v.y-u.y, 2));
//                forcaDeAtracao += Math.pow(distancia, 2)/k;
//            }
//            /**
//             * FORCA DE REPULSAO
//             */
//            for(String vertice : grafo.pegaVertices()){
//                if(vertice.equals(verticeFixado))
//                    continue;
//                parSimples<Integer> v = new parSimples<>(coordenadas.get(verticeFixado).X(), coordenadas.get(verticeFixado).Y());
//                parSimples<Integer> u = new parSimples<>(coordenadas.get(vertice).X(), coordenadas.get(vertice).Y());
//                distancia = Math.sqrt(Math.pow(v.x-u.x, 2)+Math.pow(v.y-u.y, 2));
//                forcaDeRepulsao += (-Math.pow(k, 2))/distancia;
//            }
//            /**
//             * SOMATÓRIA DAS FORCAS
//             */
//            double forcaDoVertice = (forcaDeAtracao+forcaDeRepulsao);
//            /**
//             * FAZ O "PASSO"
//             */
//            int novissimoX = new Double(coordenadas.pega(verticeFixado).X()+(constante*forcaDoVertice)).intValue();
//            int novissimoY = new Double(coordenadas.pega(verticeFixado).Y()+(constante*forcaDoVertice)).intValue();
//            coordenadas.pega(verticeFixado).setX(novissimoX);
//            coordenadas.pega(verticeFixado).setY(novissimoY);
//        }); // Fim do percorrimento dos vértices
//    }
    /**
     * PRIMEIRA IDEIA DE IMPLEMENTAÇÃO FALHOU !!!!!!!!
     */
//    @Test
//    public void desenhaOGrafoEspiral(){
//        imagem.desenhaEixoCentral(dimx, dimy);
//        imagem.desenhaEspiralDeArquimedes(xDoCentro, yDoCentro, 1000);
//        /**
//         * VISUALIZA O GRAFO
//         */
//        imprime(grafo.toString());
//        //imagem.salvaNoArquivo("novografo.jpg");
//        /**
//         * DESENHA O GRAFO
//         */
//        int xAnterior = xDoCentro;
//        int yAnterior = yDoCentro;
//        double angulo = 0;
//        for(Entry<String, Lista<String>> par : grafo.conjunto()){
//            /**
//             * Cálculo da posicao
//             */
//            String vertice = par.getKey();
//            double raio = 50+5*Math.toRadians(angulo); // espiral de arquimedes
//            Par<Integer, Integer> coordenadas = coordCartesianas(raio, angulo);
//            int xNovo, yNovo;
//            xNovo = coordenadas.X()+xDoCentro;
//            yNovo = coordenadas.Y()+yDoCentro;
//            /**
//             * Impressao da bola
//             */
//            //imagem.desenhaLinha(Color.yellow, xAnterior, yAnterior, xNovo, yNovo);
//            imagem.desenhaCircu(Color.blue, xNovo, yNovo, imagem.larguraDoTexto(vertice));
//            imagem.desenhaTexto(Color.white, vertice, xNovo, yNovo);
//            imagem.salvaNoArquivo("novografo.jpg");
//            /**
//             * Alimenta os incrementos
//             */
//            angulo += 57*10;
//            xAnterior = xNovo;
//            yAnterior = yNovo;
//        }
//    }
    /**
     * FUNCOES AUXILIARES
     */
    //@Test
    public void aleatorio(){
        Random a=new Random();
        for( int i=0; i < 100; i++ )
            imprime(Integer.toString(a.nextInt(10)));
    }

    public Par<Integer, Integer> coordCartesianas( double raio, double angulo ){
        Integer x, y;
        x=(int)(raio * Math.cos(angulo));
        y=(int)(raio * Math.sin(angulo));
        return new Par<Integer, Integer>(x, y);
    }

    //@Test
    public void testa(){
        String texto="teste";
        String texto2="teste2";
        int posVerX=xDoCentro;
        int posVerY=yDoCentro;
        int posVerX2=xDoCentro - 50;
        int posVerY2=yDoCentro - 50;
        imagem=new Imagem(dimx, dimy);
        imagem.corDoFundo(Color.black);
        imagem.desenhaEixoCentral(dimx, dimy);
        imagem.desenhaLinha(Color.red, posVerX, posVerY, posVerX2, posVerY2);
        imagem.desenhaCircu(Color.white, posVerX, posVerY, imagem.larguraDoTexto(texto) + 10);
        imagem.desenhaTexto(Color.black, texto, posVerX, posVerY).X();
        imagem.desenhaCircu(Color.white, posVerX2, posVerY2, imagem.larguraDoTexto(texto2) + 10);
        imagem.desenhaTexto(Color.black, texto2, posVerX2, posVerY2).X();
        imagem.salvaNoArquivo("imagemgrafo.jpg");
    }
}
