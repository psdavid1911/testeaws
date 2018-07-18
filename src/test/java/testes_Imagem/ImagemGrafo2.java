package testes_Imagem;
import EstruturasDeDados.Grafo8;
import EstruturasDeDados.Lista;
import EstruturasDeDados.Par8;
import EstruturasDeDados.TabelaHash8;
import EstruturasDeDados.parSimples;
import Imagem.Imagem;
import java.awt.Color;
import java.util.Map.Entry;
import java.util.Random;
import org.junit.Test;

public class ImagemGrafo2{

    Grafo8<String> grafo=new Grafo8<String>();
    TabelaHash8<String,Par8<Integer,Integer>> coordenadas=new TabelaHash8<String,Par8<Integer,Integer>>();
    TabelaHash8<String,Par8<Integer,Integer>> passoDoGrafo=new TabelaHash8<String,Par8<Integer,Integer>>();
    Imagem imagem;
    int dimx=1000;
    int dimy=1000;
    int xDoCentro=dimx/2;
    int yDoCentro=dimy/2;
    double constante=0.01;
    int area=xDoCentro*yDoCentro;
    double k;

    public ImagemGrafo2(){
        imagem=new Imagem(dimx,dimy);
        imagem.corDoFundo(Color.black);
        imagem.desenhaEixoCentral(dimx,dimy);
        //imagem.desenhaEspiralDeArquimedes(xDoCentro, yDoCentro, 1000);
        /**
         * CRIA O GRAFO
         */
        grafo.adicionaAresta("Vertice1","Vertice2");
        grafo.adicionaAresta("Vertice2","Vertice3");
        grafo.adicionaAresta("Vertice3","Vertice4");
        grafo.adicionaAresta("Vertice3","Vertice3");
        grafo.adicionaAresta("Vertice3","Vertice2");
        grafo.adicionaAresta("Vertice3","Vertice1");
        grafo.adicionaAresta("Vertice5","Vertice2");
        grafo.adicionaAresta("Vertice2","Vertice1");
        grafo.adicionaAresta("Vertice3","Vertice3");
        grafo.adicionaAresta("Vertice6","Vertice5");
        grafo.adicionaAresta("Vertice3","Vertice5");
        grafo.adicionaVertice("Vertice0");
        /**
         * Termina de criar variáveis úteis
         */
        k=Math.sqrt(area/grafo.tamanho());
        /**
         * Inicializa o manipulador de coordenadas do grafo
         */
        for(Entry<String,Lista<String>> entrada:grafo.conjunto()) {
            String vertice=entrada.getKey();
            Lista<String> listaDeAdjascencias=entrada.getValue();
            //coordenadasDoGrafo.adiciona(vertice, new Par8(0,0));
            coordenadas.adiciona(vertice,new Par8(new Random().nextInt(xDoCentro)-xDoCentro/2,new Random().nextInt(yDoCentro)-xDoCentro/2));
            System.out.println("\nPosicao Inicial: "+coordenadas.pega(vertice).getX()+" : "+coordenadas.pega(vertice).getY());
            passoDoGrafo.adiciona(vertice,new Par8(0,0));
        }
    }

    @Test
    public void testaGrafo(){
        System.out.println("\n");
        calculaPosicoes();
        // Visualizacao pelo terminal terminal
        imprime(grafo.toString());
        for(Entry<String,Lista<String>> entrada:grafo.conjunto()) {
            int xNovo=coordenadas.pega(entrada.getKey()).getX();
            int yNovo=coordenadas.pega(entrada.getKey()).getY();
            for(String v:entrada.getValue()) {
                int xf=coordenadas.get(v).getX();
                int yf=coordenadas.get(v).getY();
                imagem.desenhaLinha(Color.yellow,xNovo+xDoCentro,yNovo+yDoCentro,xf+xDoCentro,yf+yDoCentro);
            }
        }
        for(Entry<String,Lista<String>> entrada:grafo.conjunto()) {
            int xNovo=coordenadas.pega(entrada.getKey()).getX();
            int yNovo=coordenadas.pega(entrada.getKey()).getY();
            System.out.println("\nCoordenada: "+(xNovo+xDoCentro)+" : "+(yNovo+yDoCentro));
            /**
             * Impressao da bola
             */
            imagem.desenhaCircu(Color.blue,xNovo+xDoCentro,yNovo+yDoCentro,imagem.larguraDoTexto(entrada.getKey()));
            imagem.desenhaTexto(Color.white,entrada.getKey(),xNovo+xDoCentro,yNovo+yDoCentro);
        }
        imagem.salvaNoArquivo("novografo.jpg");
    }

    public void calculaPosicoes(){
        int distanciaIdeal=25; // arbitra uma distancia ideal em px
        TabelaHash8<String,parSimples<Integer>> coordenadas=new TabelaHash8<String,parSimples<Integer>>();
        while(true)
            /**
             * Itera por todas as posicoes Atribuindo valores aleatorios
             */
            for(Entry<String,Lista<String>> entradas:grafo.conjunto()) {
                String vertice=entradas.getKey();
                Lista<String> adjascencias=entradas.getValue();
                coordenadas.pega(vertice).x=aleatorioMenorQueMetadeX();
                coordenadas.pega(vertice).y=aleatorioMenorQueMetadeY();
                for(String s:adjascencias) {
                    /**
                     * Itera pelos adjascentes Verifica se a distancia entre
                     * eles esta maior ou menor Calcula o passo
                     */
                }
            }
    }

    public int aleatorioMenorQueMetadeX(){
        return new Random(xDoCentro).nextInt();
    }

    public int aleatorioMenorQueMetadeY(){
        return new Random(yDoCentro).nextInt();
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
//                parSimples<Integer> v = new parSimples<>(coordenadas.get(verticeFixado).getX(), coordenadas.get(verticeFixado).getY());
//                parSimples<Integer> u = new parSimples<>(coordenadas.get(vertice).getX(), coordenadas.get(vertice).getY());
//                distancia = Math.sqrt(Math.pow(v.x-u.x, 2)+Math.pow(v.y-u.y, 2));
//                forcaDeAtracao += Math.pow(distancia, 2)/k;
//            }
//            /**
//             * FORCA DE REPULSAO
//             */
//            for(String vertice : grafo.pegaVertices()){
//                if(vertice.equals(verticeFixado))
//                    continue;
//                parSimples<Integer> v = new parSimples<>(coordenadas.get(verticeFixado).getX(), coordenadas.get(verticeFixado).getY());
//                parSimples<Integer> u = new parSimples<>(coordenadas.get(vertice).getX(), coordenadas.get(vertice).getY());
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
//            int novissimoX = new Double(coordenadas.pega(verticeFixado).getX()+(constante*forcaDoVertice)).intValue();
//            int novissimoY = new Double(coordenadas.pega(verticeFixado).getY()+(constante*forcaDoVertice)).intValue();
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
//            Par8<Integer, Integer> coordenadas = coordCartesianas(raio, angulo);
//            int xNovo, yNovo;
//            xNovo = coordenadas.getX()+xDoCentro;
//            yNovo = coordenadas.getY()+yDoCentro;
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
        for(int i=0;i<100;i++)
            imprime(Integer.toString(a.nextInt(10)));
    }

    public Par8<Integer,Integer> coordCartesianas(double raio,double angulo){
        Integer x, y;
        x=new Double(raio*Math.cos(angulo)).intValue();
        y=new Double(raio*Math.sin(angulo)).intValue();
        return new Par8<Integer,Integer>(x,y);
    }

    //@Test
    public void testa(){
        String texto="teste";
        String texto2="teste2";
        int posVerX=xDoCentro;
        int posVerY=yDoCentro;
        int posVerX2=xDoCentro-50;
        int posVerY2=yDoCentro-50;
        imagem=new Imagem(dimx,dimy);
        imagem.corDoFundo(Color.black);
        imagem.desenhaEixoCentral(dimx,dimy);
        imagem.desenhaLinha(Color.red,posVerX,posVerY,posVerX2,posVerY2);
        imagem.desenhaCircu(Color.white,posVerX,posVerY,imagem.larguraDoTexto(texto)+10);
        imagem.desenhaTexto(Color.black,texto,posVerX,posVerY).getX();
        imagem.desenhaCircu(Color.white,posVerX2,posVerY2,imagem.larguraDoTexto(texto2)+10);
        imagem.desenhaTexto(Color.black,texto2,posVerX2,posVerY2).getX();
        imagem.salvaNoArquivo("imagemgrafo.jpg");
    }

    public void imprime(String s){
        System.out.println(s);
    }
}
