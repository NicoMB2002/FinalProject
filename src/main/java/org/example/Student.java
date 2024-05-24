package org.example;

import lombok.*;

import java.util.ArrayList;
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1;

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("S%06d", nextId++);
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            System.out.printf("%s has already been registered.\n", course.getCourseName());
            return false;
        }

        registeredCourses.add(course);
        course.registerStudent(this);
        System.out.printf("%s is successfully registered.\n", course.getCourseName());
        return true;
    }

    public boolean dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            System.out.printf("%s has already been registered.\n", course.getCourseName());
            return false;
        }
        registeredCourses.remove(course);
        course.dropStudent(this);
        System.out.printf("%s is successfully removed.\n", course.getCourseName());
        return true;
    }
}
