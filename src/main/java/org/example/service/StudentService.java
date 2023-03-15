package org.example.service;

import org.example.Enum.Status;
import org.example.dto.Book;
import org.example.dto.BookOrderInformation;
import org.example.dto.Student;
import org.example.dto.StudentBook;
import org.example.repository.BookRepository;
import org.example.repository.StudentBookRepository;
import org.example.repository.Studentrepository;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

@Service
public class StudentService {
    @Autowired
    private Studentrepository studentrepository ;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private StudentBookRepository studentBookRepository;




//    public void deleteStudent(int n) {
//      studentrepository.deleteStudent(n);
//    }

//    public void addStudent(String name, String surname, String phone) {
//        Student student = studentrepository.getProfileByPhone(phone);
//        if (student != null) {
//            System.out.println(" bu foydalanuvchi bor");
//        }
//        Student student1 = new Student();
//        student1.setName(name);
//        student1.setSurname(surname);
//        student1.setPhone(phone);
//        studentrepository.addStudent(student1);
//    }

    public void BookList() {
        List<Book> list = bookRepository.getBookList();
        for (Book b : list){
            System.out.println(b.toString());
        }
    }

    public void TakeBook(Student student) {
        int count = studentBookRepository.getBookListByStudentIdAndStatus(student.getId(),Status.TAKEN).size();
        System.out.print("Enter book id :");
        Book book = bookRepository.getBookBYId(ScannerUtil.scannerInt.nextInt());
        if (book == null ) {
            System.out.println("not found book");
            return;
        } else if (count > 5) {
            System.out.println("Sorry, you can't get more than 5 books!");
        }
        StudentBook studentBook = new StudentBook();
        studentBook.setStudent_id(student.getId());
        studentBook.setBook_id(book.getId());
        studentBook.setStatus(Status.TAKEN);
        studentBook.setReturnedDate(LocalDateTime.now());
        LocalDateTime localDateTime = LocalDateTime.now();
        studentBook.setDuration(localDateTime.plusDays(30));
        getResult(studentBookRepository.save(studentBook));
        book.setAmount(book.getAmount() + " - 1 ");
        bookRepository.getBook(book.getId(),book);

    }

    public void Takenbook(Student student) {
       List<Book> bookList = studentBookRepository.getBookListByStudentIdAndStatus(student.getId(),Status.TAKEN);
       for (Book book:bookList){
           System.out.println("Book ( id ='" + book.getId() + "', title ='" + book.getTitle() + "', author ='" + book.getAuthor() + "' );");
       }
    }




    public void History() {
        List<BookOrderInformation> informations= studentBookRepository.getHistory();
        for (BookOrderInformation i : informations) System.out.println("Book (Order number ='" + i.getSb_id() + "', Book title ='" + i.getBook_title() +
                "', Book author ='" + i.getBook_author() + "', Taken date ='" + i.getTaken_time() + "', Returned date ='" + i.getReturned_time() + "' );");
    }

    public void OrderBook() {

    }
    private void getResult(int n){
        if (n == 1) System.out.println("succsusfully");
        else System.out.println("ishlamadi");
    }

    public void ReturnBook(Student student) {
        System.out.println(" Enter book id ");
        Book book = bookRepository.getBookBYId(ScannerUtil.scannerInt.nextInt());
        if(book == null){
            System.out.println("Sorry, the book you were looking for does not exist. \nPlease, try again");
        }
        StudentBook studentBook = studentBookRepository.getBookListByStudentId(book.getId(),student.getId());
        if(studentBook.getStatus().equals(Status.TAKEN)){
            System.out.println("Sorry, you didn't return the book to the library");
        }

        studentBook.setStatus(Status.RETURNED);
        studentBook.setReturnedDate(LocalDateTime.now());
        getResult(studentBookRepository.getUpdetStudentBook(studentBook.getId(), studentBook));
        book.setAmount(book.getAmount() + 1);
        bookRepository.updateBook(book.getId(),book);

    }
}
