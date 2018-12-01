package trabFinalPoo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InterfaceGrafica extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override public void start(Stage palco){
		Group quadro = new Group();
		
		
		
		palco.setScene(new Scene(quadro, 800, 600));
		
	}
}
