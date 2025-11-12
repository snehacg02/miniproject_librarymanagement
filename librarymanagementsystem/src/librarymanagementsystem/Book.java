package librarymanagementsystem;

import java.util.*;
import java.sql.*;

public class Book {
	
	private Connection connection;
	public Book(Connection connection)
	{
		this.connection=connection;
	}
	
	public void addBook(String title,int authorId) {
		try
		{
			String sql="Insert into books (title,author_id) values (?,?)";
			PreparedStatement smt=connection.prepareStatement(sql);
			smt.setString(1,title);
			smt.setInt(2, authorId);
			smt.executeUpdate();
			smt.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	public void updateBook(int id,String newTitle,int newAuthorId) {
		try
		{
			String sql="update authors set name=? where id=?";
			PreparedStatement smt=connection.prepareStatement(sql);
			smt.setString(1,newTitle);
			smt.setInt(2,newAuthorId);
			smt.setInt(3, id);
			smt.executeUpdate();
			smt.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	public void deleteBook(int id) {
		try
		{
			String sql="delete from books where id=(?)";
			PreparedStatement smt=connection.prepareStatement(sql);
			smt.setInt(1,id);
			smt.executeUpdate();
			smt.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	public List<String> getAllBooks()
	{
		List<String> books = new ArrayList<>();
		try {
			String sql="select * from books";
			Statement smt=connection.createStatement();
			ResultSet rs=smt.executeQuery(sql);
			while(rs.next()) {
				int id=rs.getInt("id");
				String title=rs.getString("title");
				int authorId=rs.getInt("author_id");
				books.add("Book ID:"+ id + ",title:" + title + ",Author id"+authorId);
			}
			rs.close();
			smt.close();
			}catch(SQLException e){
				e.printStackTrace();
		}
		return books;
	}
	
}
