package org.example.Controller;

import org.example.dto.Student;
import org.example.repository.Studentrepository;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class StudentController {

    @Autowired
    private Studentrepository studentrepository;
    @Autowired
    private static StudentService studentService;

    public static void studentList() {
        List<Student> studentList = Studentrepository.studentList();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }


    public static void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter name ");
        String name  = scanner.next();
        System.out.println("enter surname ");
        String surname = scanner.next();
        System.out.println(" enter phone");
        String phone = scanner.next();

      //  studentService.addStudent(name,surname,phone);

    /*public static void addStudent() {
        Student student = studentrepository.getProfileByPhone(phone);
        if(student != null){
            System.out.println(" bu foydalanuvchi bor");
        }

    }*/
/*    Scanner scanner = new Scanner(System.in);
        System.out.println("enter name ");
    String name  = scanner.next();
        System.out.println("enter surname ");
    String surname = scanner.next();
        System.out.println(" enter phone");
    String phone = scanner.next();

        studentController.addStudent(name,surname,phone);*/
    }
}
