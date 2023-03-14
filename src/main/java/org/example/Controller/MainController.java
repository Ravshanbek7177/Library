package org.example.Controller;

import org.example.dto.Student;
import org.example.service.AddBookService;
import org.example.service.StuddentBookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;
@Controller

public class MainController {

    @Autowired
    private AddBookService addBookService;
    @Autowired
            private StuddentBookservice studdentBookservice;
    Scanner scanner = new Scanner(System.in);

    public void start() {
           boolean b = true;
           Student student = new Student();

           while (b){
               menyu();
               Scanner scanner = new Scanner(System.in);
               int n = scanner.nextInt();
               switch (n){
                   case 1 ->BookList();
                   case 2 -> TakeBook();
                   case  3 -> Takebook1();
                   case 4 -> ReturnBook();
                   case  5 -> History();
                   case 6 -> OrderBook();
               }

           }
    }

    private void OrderBook() {

    }

    private void History() {

    }

    private void ReturnBook() {
       addBookService.bookList1();
    }

    private void Takebook1() {
       studdentBookservice.TakeBook1();
    }

    private void TakeBook() {
        System.out.println("Enter ID ");
        int Id = scanner.nextInt();
        studdentBookservice.TakeBook(Id);
    }

    private void BookList() {
        addBookService.bookListUser();
    }
    public void menyu(){
        System.out.println("1.BookList \n" +
                "2.TakeBook \n" +
                "3.Takebook1 \n" +
                "4.ReturnBook \n" +
                "5.HistornBook\n" +
                "6.OrderBook");
    }

}
