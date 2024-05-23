package org.example;

import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private ArrayList<Double> finalScores;
    private static int nextId = 2;

    public Course(String courseId, String courseName, double credits, Department department, ArrayList<Assignment> assignments,
                  ArrayList<Student> registeredStudents, ArrayList<Double> finalScores) {
        this.courseId = String.format("C%02d", nextId++);
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.assignments = assignments;
        this.registeredStudents = registeredStudents;
        this.finalScores = finalScores;
    }
}
