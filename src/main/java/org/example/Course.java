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
    private static int nextId = 1;

    public Course(String courseId, String courseName, double credits, Department department, ArrayList<Assignment> assignments,
                  ArrayList<Student> registeredStudents, ArrayList<Double> finalScores) {
        this.courseId = "C-" + department.getDepartmentId() + "-" + String.format("%02d", nextId++);
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.assignments = assignments;
        this.registeredStudents = registeredStudents;
        this.finalScores = finalScores;
    }

    public boolean isAssignmentWeightValid() {
        double totalWeight = 0;
        for (Assignment assignment : assignments) {
            totalWeight += assignment.getWeight();
        }
        return totalWeight == 1.0;
    }

    public boolean registerStudent(Student student) {
        if (!registeredStudents.contains(student)) {
            registeredStudents.add(student);
            for (Assignment assignment : assignments) {
                assignment.getScores().add(null);
            }
            finalScores.add(null);
            return true;
        }
        return false;
    }

    public void dropStudent(Student student) {
        if (registeredStudents.contains(student)) {
            int index = registeredStudents.indexOf(student);
            registeredStudents.remove(index);
            for (Assignment assignment : assignments) {
                assignment.getScores().remove(index);
            }
            finalScores.remove(index);
        }
    }
}
