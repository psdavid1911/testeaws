package DesenhaGrafo2;

import AnalisadorSintatico.ManipuladorGrafo;
import EstruturasDeDados.Dupla;
import EstruturasDeDados.ForcasGrafo;
import EstruturasDeDados.Lista;
import EstruturasDeDados.TabelaHash;
import java.util.Map.Entry;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import static javafx.util.Duration.seconds;

public class Aplicacao extends Application{

    Double ALTURA=600.;
    Double LARGURA=800.;
    Double RAIO=5.;
    Double XCENTRAL=LARGURA/2;
    Double YCENTRAL=ALTURA/2;
    TabelaHash<Lista<String>, Path> caminhosLongo=new TabelaHash<Lista<String>, Path>();
    String gramatica="file:///C:/Users/psdav/Documents/NetBeansProjects/testeaws/src/test/java/DesenhaGrafo/testeDesenhaGrafo.txt";
    ForcasGrafo iterador=new ForcasGrafo(new ManipuladorGrafo(gramatica), new Dupla<Double>(XCENTRAL, YCENTRAL));
    Group tela=new Group();

    public Circle circulo(){
        Circle c=new Circle();
        c.setCenterX(XCENTRAL);
        c.setCenterY(YCENTRAL);
        c.setFill(Color.BLACK);
        c.setRadius(5.);
        c.setStroke(Color.BLUE);
        c.setStrokeWidth(1.);
        return c;
    }

    public void criaCaminho(){
        for(int i=0; i<3; i++){
            iterador.itera(new Dupla<Double>(XCENTRAL, YCENTRAL));
            for(Entry<Lista<String>, Path> elemento:caminhosLongo.conjunto()){
                Dupla<Double> c=iterador.VERTICES.pega(elemento.getKey());
                elemento.getValue().getElements().add(new LineTo(c.X, c.Y));
            }
        }
    }

    public void inicializaCaminho(){
        for(Entry<Lista<String>, Dupla<Double>> entrada:iterador.VERTICES.conjunto())
            caminhosLongo.adiciona(entrada.getKey(), new Path(new MoveTo(entrada.getValue().X, entrada.getValue().Y)));
    }

    @Override
    public void start(Stage palco) throws Exception{
        inicializaCaminho();
        criaCaminho();
        ParallelTransition pt=new ParallelTransition();
        for(Lista<String> vertice:iterador.VERTICES.keySet()){
            Circle c=circulo();
            PathTransition t=new PathTransition();
            t.setNode(c);
            t.setDuration(seconds(2));
            t.setPath(caminhosLongo.pega(vertice));
            t.setCycleCount(1);
            tela.getChildren().add(c);
            pt.getChildren().add(t);
        }

        pt.play();
        Scene cena=new Scene(tela, LARGURA, ALTURA);
        palco.setScene(cena);
        palco.setTitle("Manipulador de Grafo");
        palco.setResizable(false);
        palco.show();
    }

    public static void main(String args[]){
        launch(args);
    }
}
