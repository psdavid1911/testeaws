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


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author psdav
 */
public class NewMain extends Application{

    @Override
    public void start( Stage palco ) {
        palco.setScene(new Scene(new Group(), 800, 600));
        Button b = new Button("teste");
        ((Group)palco.getScene().getRoot()).getChildren().add(b);
        
        PathTransition pt =new PathTransition();
        pt.setNode(b);
        pt.setPath(new Path(new MoveTo(), new LineTo(200, 200)));
        pt.setDuration(seconds(1));
        pt.setCycleCount(1);
        PathTransition pt2 =new PathTransition();
        pt2.setNode(b);
        pt2.setPath(new Path(new MoveTo(200,200), new LineTo(-250, 200)));
        pt2.setDuration(seconds(1));
        pt2.setCycleCount(1);
        
        SequentialTransition st = new SequentialTransition();
        st.getChildren().addAll(pt,pt2);
        st.play();
        
        palco.show();
    }

    public static void main( String[] args ){
        launch(args);
    }
    
}
