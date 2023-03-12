package org.example.service;

import org.example.dto.Student;
import org.example.repository.Studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private Studentrepository studentrepository = new Studentrepository();

    public void addStudent(String name, String surname, String phone) {
        Student student = studentrepository.getProfileByPhone(phone);
        if (student != null) {
            System.out.println(" bu foydalanuvchi bor");
        }
        studentrepository.addStudent(name,surname,phone);
    }

    public void deleteStudent(int n) {
      studentrepository.deleteStudent(n);
    }
}
