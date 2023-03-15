package org.example.Controller;

import org.example.dto.Student;
import org.example.service.AddBookService;
import org.example.service.AdminService;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller

public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private StudentController studentController;
    @Autowired
    private AddBookService addBookService;
    @Autowired
    private StudentService studentService;
    Scanner scanner = new Scanner(System.in);

    public void start(Student student) {
        boolean b = true;

        while (b) {
            menyu();
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            switch (n) {
                case 1 -> BookList();
                case 2 -> AddBook();
                case 3 -> DeleteBook();
                case 4 -> StudentLIST();
                case 5 -> AddStudent();
                case 6 -> DeleteStudent();
                case 7 -> StudentTask();
                case 8 -> BookTask();
            }

        }
    }

    private void BookTask() {

    }

    private void StudentTask() {

    }

    private void DeleteStudent() {
        System.out.println("enter ID");
        int n = scanner.nextInt();
//        studentService.deleteStudent(n);
    }

    private void AddStudent() {

        System.out.println("enter name ");
        String name = scanner.nextLine();
        System.out.println("enter surname ");
        String surname = scanner.nextLine();
        System.out.println(" enter phone");
        String phone = scanner.nextLine();



//        studentService.addStudent(name,surname,phone);

    }

    private void StudentLIST() {
//        studentController.studentList();
    }

    private void DeleteBook() {
        System.out.println("enter ID ");
        int id = scanner.nextInt();
        addBookService.deleteBook(id);

    }

    private void AddBook() {
        System.out.println("enter title");
        String title = scanner.next();
        System.out.println("enter author ");
        String author = scanner.next();
        System.out.println(" enter amount");
        String amount = scanner.next();

        addBookService.addBook(title, author, amount);


    }

    private void BookList() {

        addBookService.bookList();


    }

    private void menyu() {
        System.out.println("1.BookList \n" +
                "2.AddBook \n" +
                "3.DeleteBook \n" +
                "4.StudentLIST \n" +
                "5.AddStudent \n" +
                "6.DeleteStudent\n" +
                "7.StudentTask \n" +
                "8.BookTask");

    }
}
