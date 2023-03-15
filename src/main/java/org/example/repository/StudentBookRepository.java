package org.example.repository;

import org.example.Enum.Status;
import org.example.dto.Book;
import org.example.dto.BookOrderInformation;
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

    public int save(StudentBook studentBook) {
        String sql = "insert into student_book (student_id,book_id,created_date,status,returned_date) values (%s,%s,now(),'%s',now())";
        sql = String.format(sql,studentBook.getStudent_id(),studentBook.getBook_id(),studentBook.getStatus());
        return jdbcTemplate.update(sql);
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
        return jdbcTemplate.queryForObject("select count(*) from student_book" +
                " where status = 'TAKEN' and student_id = " + studentId, Integer.class);
    }

    public List<Book> getBookListByStudentIdAndStatus(Integer id, Status status) {
        if (status == null){
            String sql = "SELECT * FROM book where id in (select book_id from student_book where student_id = " + id + " );" ;
            List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
            return bookList;
        }
        String sql = "SELECT * FROM book where id in (select book_id from student_book where student_id = " + id + " and status = '"+status.toString()+"' );" ;
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
        return bookList;
    }


    public StudentBook getBookListByStudentId(Integer bookId, Integer StudentBookId) {
        String sql = "select * from student_book  where BookId =" + bookId + "and StudentId = " + StudentBookId + ";";
        List<StudentBook> studentBookList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(StudentBook.class));
        if (studentBookList.size() > 0) {
            return studentBookList.get(0);
        }
        return null;
    }

    public int getUpdetStudentBook(Integer sb_id, StudentBook studentBook) {
        String sql = "Update student_book set id =%d,created_date ='%s',status ='%s' , returned_date ='%s',duration ='%s',student_id =%s,book_id =%s   where id = %d";
        sql = String.format(sql,sb_id,studentBook.getCreatedDate(), studentBook.getStatus(), studentBook.getReturnedDate(), studentBook.getDuration(),studentBook.getStudent_id(),studentBook.getBook_id() , sb_id);
        return jdbcTemplate.update(sql);
    }
    public List<BookOrderInformation> getHistory(){
        String sql = " select sb.id as sb_id,b.id as book_id,b.title as book_title, b.author as book_author,sb.created_date as taken_time,sb.returned_date as returned_time ,s.name as student_name , s.surname as student_surname, s.phone as student_phone from student_book as sb " +
                "inner join book as b on sb.book_id = b.id " +
                "inner join users as s on sb.student_id = s.id where sb.status != 'TAKEN'";
        List<BookOrderInformation> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BookOrderInformation.class));
        return list;
    }
}
