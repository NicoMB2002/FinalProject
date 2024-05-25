package org.example;

import lombok.*;
import org.example.util.Util;

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
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    /**
     * registers a course,
     * adds the course to the student's registeredCourses list,
     * adds the student to the course's registeredStudents list,
     * appends a `null` for the `scores` of each assignment of the course. If the course is already registered, directly returns `false`
     * @param course Input object of Course class
     * @return true when a course is registered
     */
    public boolean registerCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            registeredCourses.add(course);
            course.getRegisteredStudents().add(this);
            for (Assignment assignment : course.getAssignments()) {
                assignment.getScores().add(null);
            }
            course.getFinalScores().add(null);
            return true;
        }
        return false;
    }

    /**
     * drops a course, remove the course from the student's registeredCourses list,
     * and remove the student from the course's registeredStudents list.
     * If the course is not registered yet, directly returns `false`
     * @param course Input object of Course class
     * @return true when a course has been dropped
     */
    public boolean dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.getRegisteredStudents().remove(this);
            for (Assignment assignment : course.getAssignments()) {
                assignment.getScores().remove(this);
            }
            course.getFinalScores().remove(this);
            return true;
        }
        return false;
    }

    /**
     * converts a student to a simple string `studentId`, the `studentName`, and `departmentName`
     * @return simplified string
     */
    public String toSimplifiedString() {
        return studentId + ": " + studentName + ", " + department.getDepartmentName();
    }
}
