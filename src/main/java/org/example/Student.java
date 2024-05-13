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
    private Address address;
    private String department;
    private String course;
    private String finalScores;
    private int nextId;

}
