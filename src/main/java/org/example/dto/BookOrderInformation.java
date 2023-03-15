package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class BookOrderInformation {
    @Getter
    @Setter
    private Integer sb_id;
    @Getter @Setter
    private Integer book_id;
    @Getter @Setter
    private String book_title;
    @Getter @Setter
    private String book_author;
    @Getter @Setter
    private LocalDateTime taken_time;
    @Getter @Setter
    private LocalDateTime returned_time;
    @Getter @Setter
    private String student_name;
    @Getter @Setter
    private String student_surname;
    @Getter @Setter
    private String student_phone;


}
