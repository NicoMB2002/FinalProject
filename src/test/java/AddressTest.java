import org.example.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressTest {
    @Test
    public void testIsPostalCodeValid1() {
        String postalCode = "h2e2H5";
        boolean expectedResult = true;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid2() {
        String postalCode = "2h2e5h";
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid3() {
        String postalCode = "x3a 1k9";
        boolean expectedResult = true;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid4() {
        String postalCode = "b4t 7L4";
        boolean expectedResult = true;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid5() {
        String postalCode = "h2e  h5";
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid6() {
        String postalCode = "";
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid7() {
        String postalCode = null;
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expectedResult, result);
    }
}
