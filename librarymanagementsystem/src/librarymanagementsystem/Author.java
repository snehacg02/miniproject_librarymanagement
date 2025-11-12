package librarymanagementsystem;

import java.util.*;
import java.sql.*;

public class Author {
	
	private Connection connection;
	public Author(Connection connection)
	{
		this.connection=connection;
	}
	
	public void addAuthor(String name) {
		try
		{
			String sql="Insert into authors (name) values (?)";
			PreparedStatement smt=connection.prepareStatement(sql);
			smt.setString(1,name);
			smt.executeUpdate();
			smt.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	public void updateAuthor(int updateAuthorId,String newAuthorName) {
		try
		{
			String sql="update authors set name=? where id=?";
			PreparedStatement smt=connection.prepareStatement(sql);
			smt.setString(1,newAuthorName);
			smt.setInt(2,updateAuthorId);
			smt.executeUpdate();
			smt.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	public void deleteAuthor(int deleteAuthorId) {
		try
		{
			String sql="delete from authors where id=(?)";
			PreparedStatement smt=connection.prepareStatement(sql);
			smt.setInt(1,deleteAuthorId);
			smt.executeUpdate();
			smt.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	public List<String> getAllAuthors()
	{
		List<String> author = new ArrayList<>();
		try {
			String sql="select * from authors";
			Statement smt=connection.createStatement();
			ResultSet rs=smt.executeQuery(sql);
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				author.add("Authors ID:"+ id + ",Name:" + name);
			}
			rs.close();
			smt.close();
			}catch(SQLException e){
				e.printStackTrace();
		}
		return author;
	}
	
}
