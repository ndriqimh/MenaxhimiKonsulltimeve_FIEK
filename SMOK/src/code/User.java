package code;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class User {
	
	private int id;
	private String saltedhashpw;
	
	public User(int id,String saltedhashpw) {
		this.setId(id);
		this.setSaltedhashpw(saltedhashpw);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSaltedhashpw() {
		return saltedhashpw;
	}

	public void setSaltedhashpw(String saltedhashpw) {
		this.saltedhashpw = saltedhashpw;
	}
	
	
	public static List<User> getUsers() {
		List<User> userList = new ArrayList();
		
		String query = "Select * from allusers";
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) DbConnection.getConnection().prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				User user = new User(resultSet.getInt(1), resultSet.getString(2));
				userList.add(user);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return userList;
	}

	
	public static boolean deleteUser(int id) {
		String query = "Delete from allusers where id=?";
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) DbConnection.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, id);
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
