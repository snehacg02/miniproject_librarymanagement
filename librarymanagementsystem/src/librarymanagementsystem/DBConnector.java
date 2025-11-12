package librarymanagementsystem;

import java.sql.*;

public class DBConnector 
{
	private Connection connection;
	
	public DBConnector() {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 String url="jdbc:mysql://localhost:3306/library";     //library - database name
			 String user="root";
			 String password="Admin12345";     //root Password 
			 connection = DriverManager.getConnection(url,user,password);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}	 
	public Connection getConnection() {
		return connection;
	}
	public void closeConnection()
	{
		try {
			if(connection!=null && !connection.isClosed()){
				connection.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
				
			}
		}
	}
