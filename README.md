# 📚 Library Management System (Java + MySQL + JDBC)

A simple **console-based Library Management System** that manages authors and books.  
Built using **Java**, **MySQL**, and **JDBC** for database connectivity.

## 💡 Features
- Add, update, delete, and list **Authors**
- Add, update, delete, and list **Books**
- Uses **JDBC** to connect and perform CRUD operations in MySQL
- Follows a **modular and object-oriented** design

## 🛠️ Technologies Used
- Java  
- MySQL  
- JDBC  
- Eclipse / IntelliJ (optional)

## 💾 Before running the Java program, open MySQL and execute the library.sql script to create the database and tables.
-- Create the database
CREATE DATABASE IF NOT EXISTS library;

-- Use the database
USE library;

-- Create table: authors
CREATE TABLE IF NOT EXISTS authors (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Create table: books
CREATE TABLE IF NOT EXISTS books (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(255) DEFAULT NULL,
  author_id INT DEFAULT NULL,
  PRIMARY KEY (id),
  KEY author_id (author_id),
  CONSTRAINT books_ibfk_1 FOREIGN KEY (author_id) REFERENCES authors (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Optional: Insert some sample data
INSERT INTO authors (name) VALUES 
('J.K. Rowling'),
('George R.R. Martin'),
('Agatha Christie');

INSERT INTO books (title, author_id) VALUES 
('Harry Potter and the Sorcerer\'s Stone', 1),
('A Game of Thrones', 2),
('Murder on the Orient Express', 3);


## ⚙️ How to Run
1. Create the database using the `library.sql` file.  
2. Update your MySQL username and password in the code.  
3. Run the `Main.java` file from the console or IDE.  
4. Use the menu options to manage the library system.

## 🧑‍💻 Author
Your Name  
www.linkedin.com/in/sneha-c-g-35aa18203  
