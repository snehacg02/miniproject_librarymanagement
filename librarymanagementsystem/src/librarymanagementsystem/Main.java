package librarymanagementsystem;

import java.sql.*;
import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		DBConnector connector=new DBConnector();
		Connection connection=connector.getConnection();
		if(connection!=null)
		{
			System.out.println("Connection Succesful");
		}
		
		Author author=new Author(connection);
		Book book=new Book(connection);
		
		Scanner sc=new Scanner(System.in);
		int choice;
		do
		{
			System.out.println("Library Management System");
			System.out.println("1. Add Authors");
			System.out.println("2. Update Authors");
			System.out.println("3. Delete Author");
			System.out.println("4. List all Authors");
			System.out.println("5. Add Books");
			System.out.println("6. Update Books");
			System.out.println("7. Delete Book");
			System.out.println("8. List all Books");
			System.out.println("9. Exit");
		
		System.out.println("Enter your Choice:\n");
		choice=sc.nextInt();
		
		switch(choice)
		{
		case 1: System.out.println("Enter the Author Name");
		        String authorName=sc.next();
		        author.addAuthor(authorName);
		        System.out.println("Author added sucessfully");
		        break;
		case 2: System.out.println("Enter Author ID to update");
		        int updateAuthorId=sc.nextInt();
		        System.out.println("Enter the new Author Name");
                String newAuthorName=sc.next();
                author.updateAuthor(updateAuthorId,newAuthorName);
                System.out.println("Author updated sucessfully");
                break;
		case 3: System.out.println("Enter Author ID to delete");
                int deleteAuthorId=sc.nextInt();
                author.deleteAuthor(deleteAuthorId);
                System.out.println("Author deleted sucessfully");
                break;
		case 4: System.out.println("List of Authors");
		        for(String a:author.getAllAuthors()) {
		        	System.out.println(a);
		        }
		        break;
		case 5: System.out.println("Enter the Book title");
                String bookTitle=sc.nextLine();
                sc.nextLine();
                System.out.println("Enter the author ID");
                int authorId=sc.nextInt();
                book.addBook(bookTitle,authorId);
                System.out.println("Book added sucessfully");
                break;
        case 6: System.out.println("Enter Book ID to update");
                int updateBookId=sc.nextInt();
                System.out.println("Enter the new Book Name");
                String newBookName=sc.next();
                System.out.println("Enter the author Id");
                int author_Id=sc.nextInt();
                book.updateBook(updateBookId,newBookName,author_Id);
                System.out.println("Author updated sucessfully");
                break;
        case 7: System.out.println("Enter Book ID to delete");
                int deleteBookId=sc.nextInt();
                book.deleteBook(deleteBookId);
                System.out.println("Book deleted sucessfully");
                break;
        case 8: System.out.println("List of Books");
                for(String b:book.getAllBooks()) {
        	    System.out.println(b);
                }
                break;
        case 9: 
        	    System.out.println("Exit");
        	    break;
        default:
        	    System.out.println("Invalid Choices");
        	    break;  
		}
     }while(choice!=9);
     
     connector.closeConnection();
	}
}
