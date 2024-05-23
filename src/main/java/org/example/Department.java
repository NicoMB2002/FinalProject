package org.example;

import lombok.*;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId = 4;

    public Department(String departmentId, String departmentName) {
        this.departmentId = String.format("D%02d", nextId++);
        if (validateDepartmentName(departmentName)) {
            this.departmentName = departmentName;
        } else {
            this.departmentName = null;
        }
    }



    public static boolean validateDepartmentName(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) {
            return false;
        }
        char[] departmentNameArray = departmentName.toCharArray();
        for (char c : departmentNameArray) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }
}
