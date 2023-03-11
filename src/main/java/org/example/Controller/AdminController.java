package org.example.Controller;

import org.example.dto.Student;
import org.example.service.AddBookService;
import org.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;
@Controller

public class AdminController {
    @Autowired
private AdminService adminService = new AdminService();
    @Autowired
    private AddBookService addBookService = new AddBookService();

    public void start() {
        boolean b = true;

        while (b){
            menyu();
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            switch (n){
                case 1 ->BookList();
                case 2 -> AddBook();
                case  3 -> DeleteBook();
                case 4 -> BookStudent();
                case  5 -> AddStudent();
                case 6 -> DeleteStudent();
                case  7 -> StudentTask();
                case 8 -> BookTask();
            }

        }
    }

    private void BookTask() {

    }

    private void StudentTask() {

    }

    private void DeleteStudent() {

    }

    private void AddStudent() {

    }

    private void BookStudent() {

    }

    private void DeleteBook() {

    }

    private void AddBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter title");
        String title  = scanner.next();
        System.out.println("enter author ");
        String author = scanner.next();
        System.out.println(" enter amount");
        String amount = scanner.next();

        addBookService.addBook(title,author,amount);



    }

    private void BookList() {
        System.out.println("enter title");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.next();
        addBookService.bookList(title);


    }

    private void menyu(){
            System.out.println("1.BookList \n" +
                    "2.AddBook \n" +
                    "3.DeleteBook \n" +
                    "4.StudentBook \n" +
                    "5.AddStudent \n" +
                    "6.DeleteStudent\n" +
                    "7.StudentTask \n" +
                    "8.BookTask");

    }
}
