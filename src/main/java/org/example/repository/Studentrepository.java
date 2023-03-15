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
    private  JdbcTemplate jdbcTemplate;

    public  List<Student> studentList() {
        String sql = "select * from profile";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        return studentList;
    }

    public Student getProfileByPhone(String phone) {
            String sql = "SELECT * FROM profile Where phone = '" + phone + "';";
            List<Student> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
            if (list.size() > 0) {
                return list.get(0);
            }
            return null;
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
        String sql = "Select  * from profile where name  and phone '" + name +"''"  + phone +"';";
        Student student = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Student.class));
        return student;
        }



    public int deleteStudent(int id) {
        String sql = "delete from profile " +
                "where id = " +id;
         return  jdbcTemplate.update(sql);
    }

    public void addStudent(Student student1) {
        String sql = "insert into profile(name,surname,phone) " +
                "values('%s','%s','%s')";
        sql = String.format(sql,student1.getName(),student1.getSurname(),student1.getPhone());
        int n = jdbcTemplate.update(sql);
        System.out.println(n);
    }
}
