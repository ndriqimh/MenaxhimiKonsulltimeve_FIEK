package SMOK;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.Scene;

public class LoginForm extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		FlowPane pane = new FlowPane(Orientation.VERTICAL,10,10);
		
		pane.setPadding(new Insets(10,11,12,13));
		pane.setAlignment(Pos.CENTER); 
		
		pane.getChildren().addAll(new Label("Emri: "),new TextField(),new Label("Gjinia"));
		
		TextField tfGender = new TextField();
		tfGender.setPrefColumnCount(1);
		
		pane.getChildren().addAll(tfGender, new Label("Mbiemri: "),new TextField());
		
		Scene scene = new Scene(pane);
		
		primaryStage.setTitle("Perdorimi i FlowPane");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}

