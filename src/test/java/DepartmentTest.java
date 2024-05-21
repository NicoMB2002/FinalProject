import org.example.Address;
import org.example.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DepartmentTest {
    @Test
    public void testValidateDepartmentName1() {
        String departmentName = "Programming";
        boolean expectedResult = true;
        boolean result = Department.validateDepartmentName(departmentName);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testValidateDepartmentName2() {
        String departmentName = "Game Programming";
        boolean expectedResult = true;
        boolean result = Department.validateDepartmentName(departmentName);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testValidateDepartmentName3() {
        String departmentName = "M";
        boolean expectedResult = true;
        boolean result = Department.validateDepartmentName(departmentName);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testValidateDepartmentName4() {
        String departmentName = "420-141";
        boolean expectedResult = false;
        boolean result = Department.validateDepartmentName(departmentName);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testValidateDepartmentName5() {
        String departmentName = " ";
        boolean expectedResult = true;
        boolean result = Department.validateDepartmentName(departmentName);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testValidateDepartmentName6() {
        String departmentName = null;
        boolean expectedResult = false;
        boolean result = Department.validateDepartmentName(departmentName);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testValidateDepartmentName7() {
        String departmentName = "";
        boolean expectedResult = false;
        boolean result = Department.validateDepartmentName(departmentName);

        Assertions.assertEquals(expectedResult, result);
    }
}
