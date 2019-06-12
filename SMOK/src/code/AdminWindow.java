package code;

import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class AdminWindow  extends Application{
	ComboBox combobox;
	TextField txtEmri;
	TextField txtMbiemri;
	TextField txtId;
	TextField txtEmail;
	TableView table = new TableView();
	

	@Override
    public void start(Stage stage) {
		stage.getIcons().add(new Image("images/titleicon.png"));
		showUsers();
	Pane withleftside = new Pane();
	VBox leftside = new VBox();
	VBox rightside = new VBox();
	BorderPane btnsOfTable = new BorderPane();
	HBox entireWindow = new HBox();
	
	
	//leftside//
	Label lblRegisterSection = new Label("                 Regjistro anetar");
	lblRegisterSection.setFont(new Font("Arial", 18));
	withleftside.getChildren().add(lblRegisterSection);
	
	
	GridPane registerHolder = new GridPane();
	registerHolder.setPadding(new Insets(20));
	registerHolder.setVgap(15);
	registerHolder.setMinWidth(350);
	registerHolder.setMaxWidth(350);
	  ColumnConstraints col1 = new ColumnConstraints();
      col1.setPercentWidth(25);
      ColumnConstraints col2 = new ColumnConstraints();
      col2.setPercentWidth(75);
     
      registerHolder.getColumnConstraints().addAll(col1, col2);
	
	Label lblStudOrProf= new Label("Lloji i \nanetarit: ");
	registerHolder.add(lblStudOrProf, 0, 0); 
    String opsionet[] =  { "Student", "Profesor"}; 
     combobox= new ComboBox(FXCollections .observableArrayList(opsionet));	
    registerHolder.add(combobox, 1, 0);
    Label lblEmri = new Label("Emri:");
    registerHolder.add(lblEmri, 0, 1);
    txtEmri = new TextField();
    registerHolder.add(txtEmri, 1, 1);
    Label lblMbiemri = new Label ("Mbiemri:");
    registerHolder.add(lblMbiemri, 0, 2);
    txtMbiemri = new TextField();
    registerHolder.add(txtMbiemri, 1, 2);
    Label lblId = new Label ("ID:");
    registerHolder.add(lblId, 0, 3);
    txtId = new TextField ();
    registerHolder.add(txtId, 1, 3);
    Label lblEmail = new Label ("Email:");
    registerHolder.add(lblEmail, 0, 4);
    txtEmail = new TextField ();
    registerHolder.add(txtEmail, 1, 4);
    Button btnRegjistro = new Button("Regjistro");
    registerHolder.add(btnRegjistro, 1, 5);
	
    leftside.setPadding(new Insets(20,0,0,0));
    leftside.getChildren().addAll(withleftside,registerHolder);
    
    
    //rightside//
    TableColumn<String, User> column1 = new TableColumn<>("ID");
	column1.setCellValueFactory(new PropertyValueFactory("id"));
	column1.setPrefWidth(60);
	
	TableColumn<String, User> column2 = new TableColumn<>("SALTED HASH PASSWORD");
	column2.setCellValueFactory(new PropertyValueFactory("saltedhashpw"));
	column2.setPrefWidth(150);
	
	

	table.getColumns().add(column1);
	table.getColumns().add(column2);
    
    //table.setEditable(true);
    table.setMinWidth(450);
    table.setMaxWidth(450);
    table.setMinHeight(380);
    table.setMaxHeight(380);

    //TableColumn idCol = new TableColumn("ID");
    //TableColumn emriCol = new TableColumn("Emri");
    //TableColumn mbiemriCol = new TableColumn("Mbiemri");
    //TableColumn emailCol = new TableColumn("Email");
    
            
    //table.getColumns().addAll(idCol, emriCol, mbiemriCol,emailCol);
    rightside.getChildren().add(table);
    //qetu kryhet table
    Button btnFshijAnetar = new Button("Fshij");
    btnFshijAnetar.setOnAction(e->deletetableEntry());
    btnsOfTable.setPadding(new Insets(15));
    btnFshijAnetar.setPadding(new Insets(5,25,5,25));
    btnsOfTable.setBottom(btnFshijAnetar);
    btnsOfTable.setMargin(btnFshijAnetar, new Insets(0,0,18,0));
    
    
    //System.out.println((String) combobox.getValue());
    btnRegjistro.setOnAction(e->{
		try {
			regjistroAntar();
			showUsers();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	});
    
    
    
    //entireWindow//
    entireWindow.getChildren().addAll(leftside,rightside,btnsOfTable);
    Scene scene = new Scene(entireWindow,940,400);
    stage.setTitle("Sistemi i Menagjimit Te Orarit Te Konsulltimeve");
    stage.setScene(scene);
    stage.setResizable(false);
    stage.show();
    
    entireWindow.setStyle("-fx-background-color:#b5b4a6");

		
		
    }
	public void regjistroAntar () throws SQLException {

		DbConnection dbconnection = new DbConnection();
	    Connection connection  = dbconnection.getConnection();
		
		  if(combobox.getValue()=="Student") {
			  System.out.println("studenti");
			  String password = generateRandomPassword(8);
			  String generatedSecuredPasswordHash = BCrypt.hashpw(password, BCrypt.gensalt(12));
			  String query = "INSERT INTO students(s_id,s_emri,s_mbiemri,s_email,s_saltedhashpw) VALUES (?,?,?,?,?)";
			  String query2 ="INSERT INTO allusers(id,saltedhashpw) VALUES (?,?)";
			  PreparedStatement ps2 = connection.prepareStatement(query2);
			  PreparedStatement ps = connection.prepareStatement(query);
			  ps.setInt(1, Integer.parseInt(txtId.getText()));
			  ps.setString(2, txtEmri.getText());
			  ps.setString(3, txtMbiemri.getText());
			  ps.setString(4, txtEmail.getText());
			  ps.setString(5, generatedSecuredPasswordHash);
			  ps2.setInt(1, Integer.parseInt(txtId.getText()));
			  ps2.setString(2, generatedSecuredPasswordHash);
			  ps.executeUpdate();
			  ps2.executeUpdate();
			  
			  final String username ="smok.unipr@gmail.com";
				final String passwordd = "Knk20192019";
				
				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");
				
				Session session = Session.getInstance(props, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username,passwordd);
					}
				});
				
				try {
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("smok.unipr@gmail.com"));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("smok.unipr@gmail.com"));
					message.setSubject("REGJISTRIMI ");
					message.setText(password);
					
					Transport.send(message);
				}
				catch (MessagingException e) {
					throw new RuntimeException(e);
				}
			  
			  
			  
		  }
		  else if (combobox.getValue()=="Profesor"){
			  System.out.println("profesori");

			  String password = generateRandomPassword(8);
			  String generatedSecuredPasswordHash = BCrypt.hashpw(password, BCrypt.gensalt(12));
			  String query = "INSERT INTO professors(p_id,p_emri,p_mbiemri,p_email,p_saltedhashpw) VALUES (?,?,?,?,?)";
			  String query2 ="INSERT INTO allusers(id,saltedhashpw) VALUES (?,?)";
			  PreparedStatement ps2 = connection.prepareStatement(query2);
			  PreparedStatement ps = connection.prepareStatement(query);
			  ps.setInt(1, Integer.parseInt(txtId.getText()));
			  ps.setString(2, txtEmri.getText());
			  ps.setString(3, txtMbiemri.getText());
			  ps.setString(4, txtEmail.getText());
			  ps.setString(5, generatedSecuredPasswordHash);
			  ps2.setInt(1, Integer.parseInt(txtId.getText()));
			  ps2.setString(2, generatedSecuredPasswordHash);
			  ps.executeUpdate();
			  ps2.executeUpdate();
			  
			  final String username ="smok.unipr@gmail.com";
				final String passwordd = "Knk20192019";
				
				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");
				
				Session session = Session.getInstance(props, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username,passwordd);
					}
				});
				
				try {
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("smok.unipr@gmail.com"));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("smok.unipr@gmail.com"));
					message.setSubject("REGJISTRIMI ");
					message.setText(password);
					
					Transport.send(message);
				}
				catch (MessagingException e) {
					throw new RuntimeException(e);
				}
			  
			  
			  
			    }
		  else {
			// local class 
		        class Local { 
		            void alert() 
		            { 
		            	Alert alert = new Alert(AlertType.ERROR);
		    			alert.setContentText("Ju lutem caktoni llojin e anetarit!");
		    			alert.showAndWait();
		            } 
		        } 
		  
		        new Local().alert(); 
	
	}
	
	}
	
	public  String generateRandomPassword(int n) 
    { 
  
        // length is bounded by 256 Character 
        byte[] array = new byte[256]; 
        new Random().nextBytes(array); 
  
        String randomString 
            = new String(array, Charset.forName("UTF-8")); 
  
        // Create a StringBuffer to store the result 
        StringBuffer r = new StringBuffer(); 
  
        // Append first 20 alphanumeric characters 
        // from the generated random String into the result 
        for (int k = 0; k < randomString.length(); k++) { 
  
            char ch = randomString.charAt(k); 
  
            if (((ch >= 'a' && ch <= 'z') 
                 || (ch >= 'A' && ch <= 'Z') 
                 || (ch >= '0' && ch <= '9')) 
                && (n > 0)) { 
  
                r.append(ch); 
                n--; 
            } 
        } 
  
        // return the resultant string 
        return r.toString(); 
    } 
  
   
	
    public static void main(String[] args) {
        launch(args);
        
        
    }
    
    //qekjo per tableview 
    //
    
    public void showUsers() {
		List<User> users = User.getUsers();
		
		ObservableList<User> userList = FXCollections.observableArrayList();
		
		for(int i = 0; i < users.size(); i++) {
			userList.add(users.get(i));
		}
		
		table.setItems(userList);
	}
    
    public void deletetableEntry() {
    	User selectedItem = (User) table.getSelectionModel().getSelectedItem();
        table.getItems().remove(selectedItem);
        int idpermufshi=selectedItem.getId();
        selectedItem.deleteUser(idpermufshi);
    }
	
	
}
