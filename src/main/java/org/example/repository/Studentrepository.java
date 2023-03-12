package org.example.repository;

import org.example.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class Studentrepository {
    @Autowired
    private static JdbcTemplate jdbcTemplate;

    public static List<Student> studentList() {
        String sql = "select * from profile";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        return studentList;
    }

    public Student getProfileByPhone(String phone) {
        String sql = "select * from profile " +
                "where phone ="+ phone;
        Student dto = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Student.class));
        return dto;

    }

/*
    private List<Student> getProfileByResultSet(ResultSet set) {
        List<Student> profileList = new LinkedList<>();
        try {
            while (set.next()) {
                Student student = new Student();
                student.setId(set.getInt("id"));
                student.setName(set.getString("name"));
                student.setSurname(set.getString("surname"));
                student.setPhone(set.getString("phone"));
                student.setCreatedDate(set.getTimestamp("created_date").toLocalDateTime());
                student.setVisible(set.getBoolean("visible"));
            }
            return profileList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/

    public Student getProfileByPhoneAndPassword(String name , String phone) {
        String sql = "Select  * from profile where name  and phone " + name + phone;
        Student student = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Student.class));
        return student;
        }

    public void addStudent(String name, String surname, String phone) {
        String sql = "insert into profile(name,surname,phone) " +
                "values('%s','%s','%s')";
        sql = String.format(sql,name,surname,phone);
        int n = jdbcTemplate.update(sql);
        System.out.println(n);
    }

    public int deleteStudent(int id) {
        String sql = "delete from profile " +
                "where id = " +id;
         return  jdbcTemplate.update(sql);
    }
}
