package org.example.service;

import jdk.jshell.Snippet;
import org.example.Enum.Status;
import org.example.dto.Book;
import org.example.dto.StudentBook;
import org.example.repository.StudentBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuddentBookservice {
    @Autowired
    private StudentBookRepository studentBookRepository;
    @Autowired
    private StudentBook studentBook;


    public void TakeBook(int id) {

            StudentBook studentBook = (StudentBook) studentBookRepository.getProfileID(id);
            if(studentBook == null){
                System.out.println(" not book");
            }else if (studentBookRepository.count(studentBook.getStatus().equals(Status.TAKEN))<5) {
                studentBookRepository.takeBook(id);
            }else if(studentBookRepository.count(studentBook.getStatus().equals(Status.RETURNED))<5){
                 studentBookRepository.takeBook(id);
            }else if (studentBookRepository.count(studentBook.getStatus().equals(Status.TAKEN))>5) {
                System.out.println("sizda olinga kitoblar ko'pku");
            }else if(studentBookRepository.count(studentBook.getStatus().equals(Status.RETURNED))>5){
                System.out.println("sizda olinga kitoblar ko'pku");
            }

        }

    public void TakeBook1() {
        if(Status.RETURNED.equals("RETURNED")){
        List<Book> studentBookList = studentBookRepository.TakeBook1();
        for (Book book : studentBookList){
            System.out.println(book);
        }
        }
    }
}
