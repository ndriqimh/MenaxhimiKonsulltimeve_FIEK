package code;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class PostimetOrareve {
	

	private int post_id;
	private String post_titulli;
	private String post_lenda;
	private String post_dataora;
	private String post_salla;
	private String post_pershkrimi;
	
	public PostimetOrareve(int post_id,String post_titulli,String post_lenda,String post_dataora,String post_salla, String post_pershkrimi) {
		this.setPost_id(post_id);
		this.setPost_titulli(post_titulli);
		this.setPost_lenda(post_lenda);
		this.setPost_dataora(post_dataora);
		this.setPost_salla(post_salla);
		this.setPost_pershkrimi(post_pershkrimi);
		
	}
	
	
	
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getPost_titulli() {
		return post_titulli;
	}
	public void setPost_titulli(String post_titulli) {
		this.post_titulli = post_titulli;
	}
	public String getPost_lenda() {
		return post_lenda;
	}
	public void setPost_lenda(String post_lenda) {
		this.post_lenda = post_lenda;
	}
	public String getPost_dataora() {
		return post_dataora;
	}
	public void setPost_dataora(String post_dataora) {
		this.post_dataora = post_dataora;
	}
	public String getPost_salla() {
		return post_salla;
	}
	public void setPost_salla(String post_salla) {
		this.post_salla = post_salla;
	}
	public String getPost_pershkrimi() {
		return post_pershkrimi;
	}
	public void setPost_pershkrimi(String post_pershkrimi) {
		this.post_pershkrimi = post_pershkrimi;
	}
	
	
	
	public static List<PostimetOrareve> getOraret() {
		List<PostimetOrareve> postimetList = new ArrayList();
		
		String query = "Select * from postimet";
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) DbConnection.getConnection().prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				PostimetOrareve postimetorareve = new PostimetOrareve(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
				postimetList.add(postimetorareve);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return postimetList;
	}

	
	
	
}
