package org.example.dto;

import lombok.*;
import org.example.Enum.Status;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentBook {
    private Integer id ;
    private  Integer Student_id;
    private Integer book_id;
    private LocalDateTime createdDate;
    private LocalDateTime returnedDate;
    private Status status;
    private  LocalDateTime Duration;

}
