package org.example.service;

import org.example.dto.Book;
import org.example.dto.Student;
import org.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddBookService {
@Autowired
private BookRepository bookRepository;

    public void addBook(String title, String author, String amount) {
       Student bookTitle = bookRepository.getProfileTitle(title);
        if(bookTitle != null){
            System.out.println("there is this book");
        }
        bookRepository.insertBook(title,author,amount);
    }


        public void bookList() {
        List<Book> bookList= bookRepository.getBookList();
        for (Book book : bookList){
            System.out.println(book);
        }

    }
    public void bookList1() {
        List<Book> bookList= bookRepository.getBookList1();
        for (Book book : bookList){
            System.out.println(book);
        }

    }

    public void deleteBook(int id) {
        bookRepository.deleteBook(id);
    }

    /*public void bookListUser() {
        List<Book>bookList = bookRepository.UserBookList();
        for (Book book : bookList){
            System.out.println(book);
        }
    }*/



}
