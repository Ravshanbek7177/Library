package org.example.Controller;

import org.example.dto.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class StudentController {

    @Autowired
    private  StudentService studentService;

    public void start(Student student) {
        boolean b = true;

        while (b){
            System.out.println("""
                    ** ->menu<- **
                    1.BookList;
                    2.TakeBook;
                    3.Takenbook;
                    4.ReturnBook; 
                    5.HistornBook;
                    6.OrderBook;
                    0. Exit;
                    """);
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            switch (n){
                case 1 -> studentService.BookList();
                case 2 -> studentService.TakeBook(student);
                case  3 -> studentService.Takenbook(student);
                case 4 -> studentService.ReturnBook(student);
                case  5 -> studentService.History();
                case 6 -> studentService.OrderBook();
            }

        }
    }











//    public static void addStudent() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("enter name ");
//        String name  = scanner.next();
//        System.out.println("enter surname ");
//        String surname = scanner.next();
//        System.out.println(" enter phone");
//        String phone = scanner.next();

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

//    public  void studentList() {
//        List<Student> studentList = studentrepository.studentList();
//        for (Student student : studentList) {
//            System.out.println(student);
//        }
//    }

