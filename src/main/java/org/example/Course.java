package org.example;

import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
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

    public Course(String courseName, double credits, Department department, ArrayList<Assignment> assignments,
                  ArrayList<Student> registeredStudents, ArrayList<Double> finalScores) {
        this.courseId = "C-" + department.getDepartmentId() + "-" + String.format("%02d", nextId++);
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.assignments = assignments;
        this.registeredStudents = registeredStudents;
        this.finalScores = finalScores;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", department=" + department +
                ", assignments=" + assignments +
                ", registeredStudents=" + registeredStudents +
                ", finalScores=" + finalScores +
                '}';
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

    public int[] calcStudentsAverage() {
        int[] averages = new int[registeredStudents.size()];
        for (int i = 0; i < registeredStudents.size(); i++) {
            double total = 0;
            for (Assignment assignment : assignments) {
                total += assignment.getScores().get(i) * assignment.getWeight();
            }
            averages[i] = (int) total;
        }
        return averages;
    }
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        if (isAssignmentWeightValid()){
            assignments.add(new Assignment(assignmentName, weight, maxScore));
            for (Student student : registeredStudents) {
                assignments.get(assignments.size() - 1).getScores().add(null);
            }
            return true;
        }
        return false;
    }

    public void generateScores() {
        for (Assignment assignment : assignments) {
            assignment.generateRandomScore();
        }
        for (int i = 0; i < registeredStudents.size(); i++) {
            finalScores.set(i, (double) calcStudentsAverage()[i]);
        }
    }

    public void displayScores() {
        System.out.println("Course: " + courseName + "(" + courseId + ")");
        System.out.print("Student");
        for (Assignment assignment : assignments) {
            System.out.print("\t" + assignment.getAssignmentName());
        }
        System.out.println("\tFinal Score");
        for (int i = 0; i < registeredStudents.size(); i++) {
            System.out.print(registeredStudents.get(i).toSimplifiedString());
            for (Assignment assignment : assignments) {
                System.out.print("\t" + assignment.getScores().get(i));
            }
            System.out.println("\t" + finalScores.get(i));
        }
        System.out.print("Average");
        for (Assignment assignment : assignments) {
            System.out.print("\t" + assignment.getAssignmentAverage());
        }
        System.out.println();
    }

    public String toSimplifiedString() {
        return courseId + ": " + courseName + ", Credits: " + credits + ", Department: " + department.getDepartmentName();
    }
}
