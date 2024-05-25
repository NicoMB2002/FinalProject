package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Address address = new Address(8025, "Papineau", "Montreal", "Quebec",
                "H2e 2h5", "Canada");
        System.out.println(address);

        Department department = new Department("Biology");
        System.out.println(department);

        Student student = new Student("nicolas", Gender.MALE, address, department);
        System.out.println(student);

        Student student2 = new Student("Michael", Gender.MALE, address, department);
        System.out.println(student2);
    }
}
