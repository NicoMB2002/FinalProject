package org.example;

import lombok.*;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Address {
    private int streetNo;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;

    public Address(int streetNo, String street, String city, String province, String postalCode, String country) {
        this.streetNo = streetNo;
        this.street = street;
        this.city = city;
        this.province = province;
        if (isPostalCodeValid(postalCode)) {
            this.postalCode = postalCode.toUpperCase();
        }
        else {
            this.postalCode = null;
        }
        this.country = country;
    }

    /**
     * checks if a postcode is valid or not. The length of a postal code can either be `6` or `7`
     * @param postalCode input String
     * @return true when valid
     */
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null) {
            return false;
        }
        char[] postalCodeArray = postalCode.toCharArray();
        int len = postalCodeArray.length;
        if (len == 6) {
            return Character.isLetter(postalCodeArray[0]) &&
            Character.isLetter(postalCodeArray[2]) &&
            Character.isLetter(postalCodeArray[4]) &&
            Character.isDigit(postalCodeArray[1]) &&
            Character.isDigit(postalCodeArray[3]) &&
            Character.isDigit(postalCodeArray[5]);

        }
        if (len == 7) {
            return Character.isLetter(postalCodeArray[0]) &&
                    Character.isLetter(postalCodeArray[2]) &&
                    Character.isLetter(postalCodeArray[5]) &&
                    Character.isWhitespace(postalCodeArray[3]) &&
                    Character.isDigit(postalCodeArray[1]) &&
                    Character.isDigit(postalCodeArray[4]) &&
                    Character.isDigit(postalCodeArray[6]);
        }
        return false;
    }
}
