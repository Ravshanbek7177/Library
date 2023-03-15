package org.example.service;

import org.example.Enum.Status;
import org.example.dto.Book;
import org.example.dto.Student;
import org.example.dto.StudentBook;
import org.example.repository.BookRepository;
import org.example.repository.StudentBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuddentBookservice {
    @Autowired
    private StudentBookRepository studentBookRepository;
    @Autowired
    private BookRepository bookRepository;











    public void TakeBook1() {
        if(Status.RETURNED.equals("RETURNED")){
        List<Book> studentBookList = studentBookRepository.TakeBook1();
        for (Book book : studentBookList){
            System.out.println(book);
        }
        }
    }
}
    /*else if (studentBookRepository.count(studentBook.getStatus().equals(Status.TAKEN))<5) {
        studentBookRepository.takeBook(id);
    }else if(studentBookRepository.count(studentBook.getStatus().equals(Status.RETURNED))<5){
         studentBookRepository.takeBook(id);
    }else if (studentBookRepository.count(studentBook.getStatus().equals(Status.TAKEN))>5) {
        System.out.println("sizda olinga kitoblar ko'pku");
    }else if(studentBookRepository.count(studentBook.getStatus().equals(Status.RETURNED))>5){
        System.out.println("sizda olinga kitoblar ko'pku");
    }*/

