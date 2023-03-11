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
private BookRepository bookRepository = new BookRepository();

    public void addBook(String title, String author, String amount) {
        Book bookTitle = bookRepository.getProfileTitle(title);
        if(bookTitle != null){
            System.out.println("there is this book");
        }
        bookRepository.insertBook(title,author,amount);
    }


        public void bookList(String title) {
            Book bookTitl = bookRepository.getProfileTitle(title);
            if(bookTitl == null){
                System.out.println(" user not found ");
            }
        List<Book> bookList= bookRepository.getBookList();
        for (Book book : bookList){
            System.out.println(book);
        }

    }
}
