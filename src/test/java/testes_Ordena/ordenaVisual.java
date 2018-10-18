package testes_Ordena;

import EstruturasDeDados.Dupla;
import EstruturasDeDados.Lista;
import Ordenacao.Bolha;
import java.util.Random;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import static javafx.util.Duration.seconds;

public class ordenaVisual extends Application{

    public Double ALTURA = 600.;
    public Double LARGURA = 800.;
    public Double XCENTRAL = LARGURA / 2;
    public Double YCENTRAL = ALTURA / 2;

    @Override
    public void start(Stage palco){
        Scene cena = new Scene(new Group(), LARGURA, ALTURA);
        palco.setScene(cena);
        Lista<No> cartoes = new Lista<>();
        ParallelTransition ptInicia = new ParallelTransition();
        for (int i = 0; i < 10; i++){
            int valor = new Random().nextInt(11);
            Button baux = new Button("" + valor);
            cartoes.add(new No(baux, valor, i * 50 + 100, YCENTRAL));
            PathTransition pt = new PathTransition();
            pt.setNode(baux);
            pt.setPath(new Path(new MoveTo(0, 0), new LineTo(i * 50 + 100, YCENTRAL)));
            pt.setDuration(seconds(1));
            ptInicia.getChildren().add(pt);
        }
        SequentialTransition st = new SequentialTransition();
        st.getChildren().add(ptInicia);
        Lista<No> inicial = new Lista<>(cartoes);
        for (No no : inicial)((Group) cena.getRoot()).getChildren().add(no.b);
        Bolha.ordena(cartoes);
        for (Dupla<Integer> indicesTrocados : cartoes.historicoDeTrocas){
            int indice1 = indicesTrocados.X;
            int indice2 = indicesTrocados.Y;
            No ni1 = inicial.get(indice1);
            No ni2 = inicial.get(indice2);
            double aux1 = ni1.x;
            Path p1 = new Path(new MoveTo(ni1.x, ni1.y), new LineTo(ni2.x, ni1.y));
            PathTransition pt1 = new PathTransition();
            pt1.setNode(ni1.b);
            pt1.setDuration(seconds(1));
            pt1.setCycleCount(1);
            pt1.setPath(p1);
            Path p2 = new Path(new MoveTo(ni2.x, ni2.y), new LineTo(aux1, ni2.y));
            PathTransition pt2 = new PathTransition();
            pt1.setNode(ni2.b);
            pt1.setDuration(seconds(1));
            pt1.setCycleCount(1);
            pt1.setPath(p2);
            ParallelTransition plt = new ParallelTransition();
            plt.setCycleCount(1);
            plt.getChildren().addAll(pt1, pt2);
            double aux = ni1.x;
            ni1.x = ni2.x;
            ni2.x = aux;
            st.getChildren().add(plt);
        }
        st.setCycleCount(1);
        st.setDelay(seconds(1));
        st.play();
        palco.show();
    }

    public static void main(String args[]){
        launch(args);
    }
}
