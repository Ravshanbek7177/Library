package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.Enum.Role;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private  Integer id ;
    private String  name ;
    private String surname ;
    private String phone;
    private Role role;
    private LocalDateTime createdDate;
    private Boolean visible;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", createdDate=" + createdDate +
                ", visible=" + visible +
                '}';
    }
}
