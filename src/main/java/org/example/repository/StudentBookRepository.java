package org.example.repository;

import org.example.dto.Book;
import org.example.dto.StudentBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentBookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<StudentBook> getProfileID(int id) {
        String sql = "select * from studentbook " +
                "where book_id = " + id;
        List<StudentBook> bookList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(StudentBook.class));
        if(bookList.size()<=5){
            return (List<StudentBook>) bookList.get(5);
        }
        return null;
    }

    public List<StudentBook> takeBook(int id) {
        String sql = "select * from studentbook " +
                "where book_id = " + id;
        List<StudentBook> bookList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(StudentBook.class));
        return bookList;
    }

    public List<Book> TakeBook1() {
        String sql = "select * from book ";
        List<Book>bookList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Book.class));
        return bookList;
    }
    public int count(boolean studentId) {
        return jdbcTemplate.queryForObject("select count(*) from studentBook" +
                " where status = 'TAKEN' and student_id = " + studentId, Integer.class);
    }
}
