package BVU;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class BVU extends Application{

    int LARGURA=1600;
    int MEIA_ALTURA=450;
    int MEIA_LARGURA=800;
    int delayLa=1500;

    public void MacroSalva( int delay ){
        try{
            Robot robo;
            robo=new Robot();
            robo.mouseMove(MEIA_LARGURA, 250);
            robo.delay(delay);
            robo.mousePress(InputEvent.BUTTON1_MASK);
            robo.mouseRelease(InputEvent.BUTTON1_MASK);
            robo.mousePress(InputEvent.BUTTON1_MASK);
            robo.mouseRelease(InputEvent.BUTTON1_MASK);
            robo.delay(delay);
            robo.delay(delay);
            robo.delay(delay);
            robo.delay(delay);
            robo.delay(delay);
            robo.mouseMove(MEIA_LARGURA, MEIA_ALTURA);
            robo.delay(delay);
            robo.keyPress(KeyEvent.VK_SHIFT);
            robo.mousePress(InputEvent.BUTTON1_MASK);
            robo.mouseRelease(InputEvent.BUTTON1_MASK);
            robo.mousePress(InputEvent.BUTTON1_MASK);
            robo.mouseRelease(InputEvent.BUTTON1_MASK);
            robo.keyRelease(KeyEvent.VK_SHIFT);
            robo.mouseMove(MEIA_LARGURA, 250);
            robo.delay(delay);
            robo.mousePress(InputEvent.BUTTON1_MASK);
            robo.mouseRelease(InputEvent.BUTTON1_MASK);
            robo.mousePress(InputEvent.BUTTON1_MASK);
            robo.mouseRelease(InputEvent.BUTTON1_MASK);
            robo.mouseMove(LARGURA, MEIA_ALTURA);
            robo.delay(delay);
            robo.mousePress(InputEvent.BUTTON1_MASK);
            robo.mouseRelease(InputEvent.BUTTON1_MASK);
            robo.delay(delay);
        }
        catch( AWTException ex ){
            System.out.println("Não pude criar a instancia de robo.");
        }
    }

    @Override public void start( Stage palco ){
        Button b1=new Button("Inicia");
        b1.setOnAction( x ->{
            int delayInicial = 1 ; // ms
            int tempoDeExecucao=9 * delayLa;
            int delay=1000;   // delay de 5 seg.
            int interval=tempoDeExecucao + 1000;  // intervalo de 1 seg.
            ScheduledExecutorService  e = Executors.newScheduledThreadPool(30); // 10 tempo de vida ???
            e.scheduleAtFixedRate(()->MacroSalva(delay), delayInicial, tempoDeExecucao, TimeUnit.MILLISECONDS);
        });
        Button b2=new Button("Inicia n");
        FlowPane fluido=new FlowPane();
        fluido.setVgap(5);
        fluido.setHgap(10);
        fluido.setPadding(new Insets(10., 10., 10., 10.));
        fluido.getChildren().addAll(b1, b2);
        Scene cena=new Scene(fluido);
        palco.setScene(cena);
        palco.sizeToScene();
        palco.setX(0);
        palco.setY(MEIA_ALTURA);
        palco.setResizable(false);
        palco.setTitle("Programa macro");
        palco.setAlwaysOnTop(true);
        palco.show();
    }

    public static void main( String args[] ){
        launch(args);
    }
}
