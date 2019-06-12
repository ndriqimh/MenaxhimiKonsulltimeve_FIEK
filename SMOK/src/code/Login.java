package code;
import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Login extends Application {
ProgressBar progressBar = new ProgressBar();	
 TextField txtId=new TextField();
 PasswordField txtPassword=new PasswordField();
 GridPane grid;
	@Override
    public void start(Stage s) {
		s.getIcons().add(new Image("images/titleicon.png"));

		VBox vbox = new VBox();
		
		Image logo = new Image("images/up_logo.png");
		
		ImageView iv = new ImageView(logo);
		iv.setFitHeight(180);
		iv.setFitWidth(180);
		
		StackPane stackpane = new StackPane();
		stackpane.setPadding(new Insets(50,0,50,0));
		stackpane.getChildren().add(iv);
		
		
		
        
         grid=new GridPane();
        
        
        grid.setStyle("-fx-background-color:lightgray");
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(0);
        grid.setPadding(new Insets(10));

        Label perdoruesi=new Label("Perdoruesi:");
        grid.add(perdoruesi,0,4);
        
        
        txtId.setPromptText("Sheno emrin e perdoruesit");
        grid.add(txtId, 1, 4);
        
        Label password=new Label("Fjalkalimi:");
        grid.add(password, 0, 5);
        
        
        txtPassword.setPromptText("Sheno fjalkalimin");
        grid.add(txtPassword, 1, 5);
        
        CheckBox chk=new CheckBox("Ruaj fjalkalimin");
    //    grid.add(chk, 1, 6);
        
        
        Button logInButtoni=new Button("                                      Hyr                                        ");
        logInButtoni.setStyle("-fx-background-color:lightblue");
        
        grid.add(logInButtoni, 1, 7);
        
        
       logInButtoni.setOnAction(e->{
		try {
			
			login();
			
	        
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	});
       
       
       txtPassword.setOnKeyPressed(new EventHandler<KeyEvent>()
       {
           @Override
           public void handle(KeyEvent ke)
           {
               if (ke.getCode().equals(KeyCode.ENTER))
               {
                   try {
					login();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               }
           }
       });
       
       txtId.setOnKeyPressed(new EventHandler<KeyEvent>()
       {
           @Override
           public void handle(KeyEvent ke)
           {
               if (ke.getCode().equals(KeyCode.ENTER))
               {
                   try {
					login();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               }
           }
       });
        
        vbox.getChildren().addAll(stackpane,grid);
        
        Scene scene=new Scene(vbox,500,600);
     
        s.setResizable(false);
        s.setScene(scene);
        s.setTitle("Sistemi per menagjimin e orarit te konsulltimeve");
        s.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
	
	public void login () throws SQLException {
		
		//grid.add(progressBar, 1, 6);
		
		DbConnection dbconnection = new DbConnection();
	    Connection connection  = dbconnection.getConnection();
	    

	    
	    try {
	        Integer.parseInt(txtId.getText());
	        
	    
	        
	        

			String verifyusername = "SELECT * FROM allusers WHERE id = ?";
			PreparedStatement ps_userverifier = connection.prepareStatement(verifyusername);
			ps_userverifier.setInt(1, Integer.parseInt(txtId.getText()));
			ResultSet rs = ps_userverifier.executeQuery();
			String pwplain = txtPassword.getText();
			
			if(!rs.next()) {
				errorAlert1();
				
			}
			else {
				
				//String generatedSecuredPasswordHash = BCrypt.hashpw(pwplain, BCrypt.gensalt(12));
				//System.out.println(generatedSecuredPasswordHash);
				String verifypassword ="SELECT saltedhashpw FROM allusers WHERE id = ? ";
				PreparedStatement st =connection.prepareStatement(verifypassword);
				st.setInt(1, Integer.parseInt(txtId.getText()));
				
				
				ResultSet pwColumnResults =st.executeQuery();
				
				while(pwColumnResults.next()) {
					String pwHash = pwColumnResults.getString("saltedhashpw");
					boolean checkPassword =BCrypt.checkpw(txtPassword.getText(),pwHash );
					if (!checkPassword) {
						errorAlert1();
					}
					else 
					{
						
						if(txtId.getText().startsWith("9"))
						{   
							
							//hapet dritarja e adminit
							
                    	    Stage stageTjeter = new Stage();
					        AdminWindow adm = new AdminWindow();
					        adm.start(stageTjeter);
					        stageTjeter.show();
					        // mbyll loginin s'ka logjik me mbet hapur pasi  t'kycesh me sukses
					       this.txtId.getScene().getWindow().hide();
					       loginSucceedAlert();
						}
						
					     if(txtId.getText().startsWith("1")) 
					     {
					    	//hapet dritarja e studentit
					    	 Stage sT = new Stage();
					    	 StudentWindow std = new StudentWindow();
					    	 std.start(sT);
					    	 // mbyll loginin s'ka logjik me mbet hapur pasi  t'kycesh me sukses
						       this.txtId.getScene().getWindow().hide();
					    	   loginSucceedAlert();
					     }
					     if(txtId.getText().startsWith("2"))
					     {
					    	 // hapet dritarja e profesorit
					    	 Stage stageprof = new Stage();
					    	 ProfessorWindow prof = new ProfessorWindow();
					    	 prof.start(stageprof);
					    	 // mbyll loginin s'ka logjik me mbet hapur pasi  t'kycesh me sukses
						       this.txtId.getScene().getWindow().hide();
						       loginSucceedAlert();
					     }
					    	 
					    // }//
					        
					      
						//}//
						//loginSucceedAlert();
					}
					  
				} //qetu kryhet loop e resultsetit
			
		
				
			}
		
	        
	   } ///try kryhet qetu
	   catch (NumberFormatException e) {
	        errorAlert2();
	   }
	    
	    
		
	}

	public void clearfields() {
		txtId.setText("");
	}
	
	public void mainwindow() {
		Stage  student_window = new Stage();
		Pane pane = new  Pane();
		Scene scene =  new Scene(pane);
		student_window.show();
		}
	
	
public void errorAlert1() {
	
	Alert alert = new Alert(AlertType.ERROR);
	alert.setTitle("S.M.O.K - Sistemi per menagjimin e orarit te konsulltimeve");
	alert.setHeaderText("KUJDES!");
	alert.setContentText("Emri i perdoruesit apo fjalekalimi jane gabim!");
	alert.showAndWait();
	
	}
	
public void errorAlert2() {	
	
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("S.M.O.K - Sistemi per menagjimin e orarit te konsulltimeve");
	alert.setHeaderText("RIKUJTIM!");
	alert.setContentText("Emri i perdoruesit eshte ID e juaj");
	alert.showAndWait();
	
}
	
public void loginSucceedAlert() {
	
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("S.M.O.K - Sistemi per menagjimin e orarit te konsulltimeve");
	alert.setHeaderText(null);
	alert.setContentText("Ju u kycet me sukses!");
	

	alert.show();
	
}
	
	
	
	
	
	
}
