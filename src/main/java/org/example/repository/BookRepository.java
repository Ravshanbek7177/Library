package org.example.repository;

import org.example.dto.Book;
import org.example.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class BookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;



    public Student getProfileTitle(String title) {
                String sql = "SELECT * FROM book Where title = '" + title + "';";
                List<Student> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
                if (list.size() > 0) {
                    return list.get(0);
                }
                return null;

    }
    public Book getBookBYId(Integer id) {
        String sql = "SELECT * FROM book Where id = " + id + ";";
        List<Book> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;

    }
    private Book getProfileByResultSet(ResultSet set) {
        String sql = "SELECT * FROM book Where set =" + set;
        Book dto = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class));
        return dto;
    }

    public void insertBook(String title, String author, String amount) {

        String sql = "insert into book(title,author,amount)" +
                " values ('%s','%s','%s')";
        sql = String.format(sql,title,author,amount);
        int n = jdbcTemplate.update(sql);
        System.out.println(n);

    }

    public List<Book> getBookList() {
        String sql = "select id , title ,author , amount from book ";
        List<Book> bookList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Book.class));
        return bookList;
    }
    public List<Book> getBookList1() {
        String sql = "select * from book ";
        List<Book> bookList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Book.class));
        return bookList;
    }

    public int deleteBook(int id) {
            String sql = "delete from  book " +
                    "where id =" + id;
         return jdbcTemplate.update(sql);
    }

    public Book getBookById(Integer id) {
        String sql = "SELECT * FROM book where id =" + id;
        List<Book> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }


    public int getBook(Integer id, Book book) {
        String sql = "Update book set id =%d, title ='%s', author ='%s',publishYear ='%s',amount =%s where id = %d";
        sql = String.format(sql, book.getId(),book.getTitle(),book.getAuthor(),book.getPublishYear(), book.getAmount(), id);
        return jdbcTemplate.update(sql) ;
    }

    public int updateBook(Integer bookId, Book book) {
        String sql = "Update book set id =%d, title ='%s', author ='%s',publishYear ='%s',amount =%s  where id = %d";
        sql = String.format(sql, book.getId(),book.getTitle(),book.getAuthor(),book.getPublishYear(), book.getAmount(), bookId);
        return jdbcTemplate.update(sql);
    }
}
