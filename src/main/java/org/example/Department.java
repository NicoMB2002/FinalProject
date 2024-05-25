package org.example;

import lombok.*;
import org.example.util.Util;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId = 1;

    public Department(String departmentName) {
        this.departmentId = String.format("D%02d", nextId++);
        if (validateDepartmentName(departmentName)) {
            this.departmentName = Util.toTitleCase(departmentName);
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
