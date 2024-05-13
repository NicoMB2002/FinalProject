package org.example;

import lombok.*;

import java.util.ArrayList;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private int studentId;
    private String studentName;
    private Gender gender;
    private String address;
    private String department;
    private ArrayList course;
    private ArrayList finalScores;
    private int nextId;

}
