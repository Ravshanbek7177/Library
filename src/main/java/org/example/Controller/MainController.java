package org.example.Controller;

import org.example.Enum.Role;
import org.example.Enum.Status;
import org.example.dto.Student;
import org.example.dto.StudentBook;
import org.example.repository.Studentrepository;
import org.example.service.AddBookService;
import org.example.service.StuddentBookservice;
import org.example.service.StudentService;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;
@Controller

public class MainController {

    @Autowired
    private Studentrepository studentrepository ;
    @Autowired
    private StudentController studentController;
    @Autowired
    private AdminController adminController;

    public void start(Student student) {
           boolean b = true;

           while (b){
               System.out.println("""
                       ** -> menu <- **
                       1. Login;
                       0. Exit;
                       """);
               Scanner scanner = new Scanner(System.in);
               int n = scanner.nextInt();
               switch (n){
                   case 1 ->Login();
                   case 0 -> {
                       System.out.println("Exited!");
                       b = false;
                   }
               }

           }
    }

    private void Login() {
        System.out.print(" Enter phone: ");
        Student student = studentrepository.getProfileByPhone(ScannerUtil.scannerStr.nextLine());
        if (student == null) {
            System.out.println("Not found people");
            return;
        }
        if (student.getRole().equals(Role.ADMIN)) adminController.start(student);
        else if (student.getRole().equals(Role.STUDENT)) studentController.start(student);

    }


}
