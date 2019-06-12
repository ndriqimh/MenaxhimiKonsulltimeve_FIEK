package code;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.javafx.tk.Toolkit;

//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ProfessorWindow  extends Application{
	TextField L=new TextField();
    TextField T=new TextField();
    TextField S=new TextField();
    Label labelInfo = new Label();
//    Label postoOrar=new Label("                       Posto Orar");
   
//    Label Pershkrimi=new Label("Pershkrimi");
   
    
    TextArea textArea;
    
    ComboBox<String> languagesCbo = new ComboBox<>();
    
    
    public void start(Stage s) {
    	
    	s.getIcons().add(new Image("images/titleicon.png"));
    	//gjuha
    	ObservableList<String> allowedLanguages = FXCollections.observableArrayList();
		
		for(int i = 0;i < I18N.getLanguages().size();i++) {
			allowedLanguages.add(I18N.getLanguages().get(i).getLanguage());		
		}
		
		languagesCbo.getItems().addAll(allowedLanguages);
		languagesCbo.setValue(I18N.getDefaultLocale().getLanguage());
		languagesCbo.setOnAction(e -> switchLanguage());
	
        ProgressBar progressBar = new ProgressBar();
        ProgressIndicator progressIndicator = new ProgressIndicator();
 	
        GridPane panePerLabel=new GridPane();
        panePerLabel.setPadding(new Insets(5,5,5,5));
        panePerLabel.setHgap(20);
        panePerLabel.setVgap(20);
        
        panePerLabel.add(I18N.getLabel("lenda"),0,0);
        panePerLabel.add(L,1,0);
        panePerLabel.add(I18N.getLabel("titulli"), 0, 1);
        panePerLabel.add(T,1,1);
        panePerLabel.add(I18N.getLabel("salla"),0,2);
        panePerLabel.add(S,1,2);
        Button posto = new Button();
        
        //qetu 
        // mire o tash veq per kthej qeto
        posto=I18N.getButton("posto");
        panePerLabel.add(posto, 0, 3);
        
        posto.setOnAction(e->{
			try {
				RegjistroOrar();
				postuarMeSukses();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
//        
//        panePerLabel.add(I18N.getButton("posto"),0,3);
//        panePerLabel.add(progressBar,1,3);
//        panePerLabel.setHalignment(Posto, HPos.RIGHT); 
        
        Label label = new Label("Vlereso : ");
        
       
        
        labelInfo.setTextFill(Color.BLUE);
 
       // Group
       ToggleGroup group = new ToggleGroup();
 
       group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
           @Override
           public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
               // Has selection.
               if (group.getSelectedToggle() != null) {
                   RadioButton button = (RadioButton) group.getSelectedToggle();
                   
                   
                  // System.out.println("Button: " + button.getText());
                   labelInfo.setText("Ju keni vleresuar me: " + button.getText());
                   
                   
                   
               }
           }
       });
       
       RadioButton button1 = new RadioButton("1");
       button1.setToggleGroup(group);
      // button1.setSelected(true);
 
       
       RadioButton button2 = new RadioButton("2");
       button2.setToggleGroup(group);
       
       RadioButton button3 = new RadioButton("3");
       button3.setToggleGroup(group);
       
       RadioButton button4 = new RadioButton("4");
       button4.setToggleGroup(group);
       
       RadioButton button5 = new RadioButton("5");
       button5.setToggleGroup(group);
 
       HBox root = new HBox();
       root.setPadding(new Insets(10));
       root.setSpacing(5);
       root.getChildren().addAll(I18N.getLabel("vlereso"), button1, button2,button3,button4,button5, labelInfo);
       
        
        VBox Leftpane=new VBox(10);
        VBox Rightpane=new VBox(10);
        
        HBox entireWindow=new HBox(10);
        Label orari = I18N.getLabel("postoOrar");
        orari.setTranslateX(80);
        Leftpane.getChildren().addAll(orari,panePerLabel);
       
        
        
        Menu mm=new Menu();
        mm = I18N.getMenu("profili");
        Menu mmm=new Menu();
        mmm = I18N.getMenu("gjuhet");
        MenuItem menu1 = new MenuItem(null,languagesCbo);
        mmm.getItems().add(menu1);
        //---Krijimi i menuItemave--
       
        MenuItem m2 = new MenuItem("Menyja 2"); 
        MenuItem m3 = new MenuItem("Menyja 3");
        //-----------------------------------//
        MenuItem mm1 = new MenuItem();
        mm1 = I18N.getMenuItem("rreth");
        mm1.setOnAction(e->{
        	Help.about();
        });
        
        Menu subMenu= new Menu();
        MenuItem mm21=new MenuItem();
        mm21 = I18N.getMenuItem("kalter");
        MenuItem mm22=new MenuItem();
        mm22 = I18N.getMenuItem("hiri");
        MenuItem mm23=new MenuItem();
        mm23 = I18N.getMenuItem("gjelber");
        MenuItem mm24=new MenuItem();
        mm24 = I18N.getMenuItem("parazgjedhur");
        
        
        subMenu = I18N.getMenu("ngjyrat");
        subMenu.getItems().addAll(mm21,mm22,mm23,mm24);
        mm.getItems().add(subMenu);
        
        //....Shtimi i eventeve per Ngjyra...////
        
        MenuItem mm3 = new MenuItem();
        mm3 = I18N.getMenuItem("dil");
       
        mm.getItems().add(mm1);        
        mm.getItems().add(mm3); 
        MenuBar mb=new MenuBar();
        
        
       
        
        mb.getMenus().addAll(mm,mmm);
        
        mb.setStyle("-fx-border-color:lightgray;-fx-border-width:4");
        
        textArea = new TextArea();
            
        
      
        Rightpane.getChildren().addAll(I18N.getLabel("pershkrimi"),textArea,root);
        
        
        entireWindow.getChildren().addAll(Leftpane,Rightpane);
        textArea.setMaxWidth(400);
        textArea.setMaxHeight(140);
        
        
        
         BorderPane pane=new BorderPane();
         pane.setTop(mb);
         pane.setLeft(entireWindow);
         pane.setStyle("-fx-background-color:lightblue");
                
         //...Eventet per ngjyra...///
         mm21.setOnAction(e->{
             pane.setStyle("-fx-background-color:blue");
         });
         mm22.setOnAction(e->{
             pane.setStyle("-fx-background-color:gray");
         });
         mm23.setOnAction(e->{
             pane.setStyle("-fx-background-color:green");
         });
         mm24.setOnAction(e->{
             pane.setStyle("-fx-background-color:lightblue");
         });
         
         entireWindow.setPadding(new Insets(40));
         ///------DIL----///
         mm3.setOnAction(e->{
             s.close();
         });
         
        
         
         
        
         
         
         
        Scene scene=new Scene(pane,940,400);
        s.setTitle("S.M.O.K");
        s.setScene(scene);
        s.setResizable(false);
        s.show();
        
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent ke)
            {
                if (ke.getCode().equals(KeyCode.TAB))
                {
                 Help.about();  
                 
 				
                }
                else if (ke.getCode().equals(KeyCode.ESCAPE))
                {
                	Stage backToLogin = new Stage();
                    Login login = new Login();
                    login.start(backToLogin);
                    ProfessorWindow.this.L.getScene().getWindow().hide();
                
                }
                else if(ke.getCode().equals(KeyCode.F1)) {
                	pane.setStyle("-fx-background-color:blue"); // bcg e kalter shortcut
                }
                else if(ke.getCode().equals(KeyCode.F2)) {
                	pane.setStyle("-fx-background-color:gray"); // bcg e hirte shortcut
                }
                else if(ke.getCode().equals(KeyCode.F3)) {
                	pane.setStyle("-fx-background-color:green"); // bcg e gjelber shortcut
                }
            }
        });
  
}
///Pjesa e Lidhjes/Konfigurimeve nga ana e Databazes///
       
   public void RegjistroOrar () throws SQLException {

	DbConnection dbconnection = new DbConnection();
	    Connection connection  = dbconnection.getConnection();
                       
	    String query="INSERT INTO postimet(post_titulli,post_lenda,post_dataora,post_salla,post_pershkrimi) VALUES(?,?,?,?,?)";
        PreparedStatement ps=connection.prepareStatement(query);
        LocalDateTime postedTime=LocalDateTime.now();
        ps.setString(1, T.getText());
        ps.setString(2,L.getText());
        ps.setString(3, postedTime.toString());
        ps.setString(4,S.getText());
        ps.setString(5, textArea.getText());
            
            ps.executeUpdate();
     
	}
    public void switchLanguage() {
		I18N.setLocale(new Locale(languagesCbo.getValue()));
	}
 public static void main(String[] args) {

     Application.launch(args);
	}
	
	  
	public void postuarMeSukses() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("S.M.O.K - Sistemi per menagjimin e orarit te konsulltimeve");
		alert.setHeaderText(null);
		alert.setContentText("Postimi u shtua me sukses! ");
		alert.show();
	}
}

