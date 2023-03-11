package org.example.repository;

import org.example.db.Database;
import org.example.dto.Book;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
@Repository
public class BookRepository {

    public Book getProfileTitle(String title) {
        String sql = "select * from book " +
                "where title = ?";
        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            ResultSet set = statement.executeQuery();
            List<Book> profileList = getProfileByResultSet(set);
            if (profileList.size()==1){
                return profileList.get(0);
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;


    }
    private List<Book> getProfileByResultSet(ResultSet set) {
        List<Book> profileList = new LinkedList<>();
        try {
            while (set.next()) {
                Book book = new Book();
                book.setId(set.getInt("id"));
                book.setTitle(set.getString("title"));
                book.setAuthor(set.getString("author"));
                book.setPublishYear(set.getTimestamp("publishYear").toString());
                book.setAmount(set.getString("amount"));
                book.setVisible(set.getBoolean("visible"));

            }
            return profileList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertBook(String title, String author, String amount) {

        String sql = "insert into book(title,author,amount)" +
                " values (?,?,?)";
        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setString(3,amount);
            statement.executeUpdate();
            System.out.println("Successfully");
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Book> getBookList() {
        String sql = "select id , title ,author , amount from book ";
        List<Book> bookList = new LinkedList<>();
        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Book book = new Book();
                book.setId(set.getInt("id"));
                book.setTitle(set.getString("title"));
                book.setAuthor(set.getString("author"));
                book.setAmount(set.getString("amount"));
                bookList.add(book);
            }
            connection.close();
            return bookList;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
