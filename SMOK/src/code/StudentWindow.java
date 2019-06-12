package code;




import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class StudentWindow extends Application {
	
	private TableView oraretTable = new TableView();
	
	
	@Override
	public void start (Stage s) {
		s.getIcons().add(new Image("images/titleicon.png"));
		// Books table
				TableColumn<String, PostimetOrareve> column1 = new TableColumn<>("Nr");
				column1.setCellValueFactory(new PropertyValueFactory("post_id"));
				column1.setPrefWidth(60);
				
				TableColumn<String, PostimetOrareve> column2 = new TableColumn<>("Titulli");
				column2.setCellValueFactory(new PropertyValueFactory("post_titulli"));
				column2.setPrefWidth(150);
				
				TableColumn<String, PostimetOrareve> column3 = new TableColumn<>("Lenda");
				column3.setCellValueFactory(new PropertyValueFactory("post_lenda"));
				column3.setPrefWidth(150);
				
				TableColumn<String, PostimetOrareve> column4 = new TableColumn<>("Koha e Postimit");
				column4.setCellValueFactory(new PropertyValueFactory("post_dataora"));
				column4.setPrefWidth(120);
				
				TableColumn<String, PostimetOrareve> column5 = new TableColumn<>("Salla");
				column5.setCellValueFactory(new PropertyValueFactory("post_salla"));
				column5.setPrefWidth(120);
				
				TableColumn<String, PostimetOrareve> column6 = new TableColumn<>("Pershkrimi");
				column6.setCellValueFactory(new PropertyValueFactory("post_pershkrimi"));
				column6.setPrefWidth(120);
				
				
				
				
				
				
				oraretTable.getColumns().add(column1);
				oraretTable.getColumns().add(column2);
				oraretTable.getColumns().add(column3);
				oraretTable.getColumns().add(column4);
				oraretTable.getColumns().add(column5);
				oraretTable.getColumns().add(column6);
				
				oraretTable.setPrefWidth(650);
				oraretTable.setPrefHeight(200);
				
				Scene scene = new Scene(oraretTable, 650, 400);
				
				
				s.setScene(scene);
				
				showOraret();
				
				s.show();
		
		
		
		
	    
		
	}
	
	
	
	
	public static void main (String[] args) {
		launch(args);
	}

	
	public void showOraret() {
		List<PostimetOrareve> oraret = PostimetOrareve.getOraret();
		
		ObservableList<PostimetOrareve> postimetList = FXCollections.observableArrayList();
		
		for(int i = 0; i < oraret.size(); i++) {
			postimetList.add(oraret.get(i));
		}
		
		oraretTable.setItems(postimetList);
	}
}
