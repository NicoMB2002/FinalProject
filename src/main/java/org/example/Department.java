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
    private int nextId;

    public Department(String departmentId, String departmentName, int nextId) {
        this.departmentId = departmentId;
        if (validateDepartmentName(departmentName)) {
            this.departmentName = departmentName;
        } else {
            this.departmentName = null;
        }
        this.nextId = nextId;
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
