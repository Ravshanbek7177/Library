package org.example;

import org.example.Config.Config;
import org.example.Controller.AdminController;
import org.example.Controller.MainController;
import org.example.Controller.StudentController;
import org.example.Enum.Role;
import org.example.db.Database;
import org.example.dto.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
      //  AdminController adminController = (AdminController) context.getBean("adminController");
      //  adminController.start();
//        MainController mainController = (MainController) context.getBean("mainController");
//          mainController.start();
//        System.out.println("drop table  studentbook ;create table if not exists  student_book(id serial primary key," +
//                "student_id integer REFERENCES profile(id) ," +
//                        "book_id integer REFERENCES book(id)," +
//                        "created_date timestamp default now() ," +
//                        "status default 'TAKEN'" +
//                        "returned_date timestamp )");
        Student student =  new Student();
        student.setPhone("852");
        student.setRole(Role.STUDENT);
        StudentController studentController = (StudentController) context.getBean("studentController");
        studentController.start(student);
    }
}