import org.example.Address;
import org.example.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilTest {

    @Test
    public void testToTitleCase1() {
        String str = "nicolas moncayo";
        String expectedResult = "Nicolas Moncayo";
        String result = Util.toTitleCase(str);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase2() {
        String str = "nICOLAS Moncayo";
        String expectedResult = "Nicolas Moncayo";
        String result = Util.toTitleCase(str);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase3() {
        String str = "nicOlas MonCayO";
        String expectedResult = "Nicolas Moncayo";
        String result = Util.toTitleCase(str);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase4() {
        String str = "nicolas MONCAYO";
        String expectedResult = "Nicolas Moncayo";
        String result = Util.toTitleCase(str);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase5() {
        String str = "";
        String expectedResult = "";
        String result = Util.toTitleCase(str);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase6() {
        String str = null;
        String expectedResult = null;
        String result = Util.toTitleCase(str);
        Assertions.assertEquals(expectedResult, result);
    }
}
