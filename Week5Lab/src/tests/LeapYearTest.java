import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LeapYearTest {
    @Test
    void testLeapYear() {
        LeapYear leapYear = new LeapYear();
        leapYear.setInputYear(2000);
        assertTrue(leapYear.getLeapYear(), "2000 should be a leap year");
    }

    @Test
    void testLeapYear2000() {
        LeapYear leapYear = new LeapYear();
        leapYear.setInputYear(2000);
        assertTrue(leapYear.getLeapYear(), "2000 should be a leap year");
    }

    @Test
    void testLeapYear2400() {
        LeapYear leapYear = new LeapYear();
        leapYear.setInputYear(2400);
        assertTrue(leapYear.getLeapYear(), "2400 should be a leap year");
    }

    @Test
    void testLeapYear1800() {
        LeapYear leapYear = new LeapYear();
        leapYear.setInputYear(1800);
        assertFalse(leapYear.getLeapYear(), "1800 should be a leap year");
    }

    @Test
    void testLeapYear1900() {
        LeapYear leapYear = new LeapYear();
        leapYear.setInputYear(1900);
        assertFalse(leapYear.getLeapYear(), "1900 should not be a leap year");
    }

    @Test
    void testLeapYear2100() {
        LeapYear leapYear = new LeapYear();
        leapYear.setInputYear(2100);
        assertFalse(leapYear.getLeapYear(), "2100 should not be a leap year");
    }

    @Test
    void testLeapYear2200() {
        LeapYear leapYear = new LeapYear();
        leapYear.setInputYear(2200);
        assertFalse(leapYear.getLeapYear(), "2200 should not be a leap year");
    }

    @Test
    void testLeapYear2300() {
        LeapYear leapYear = new LeapYear();
        leapYear.setInputYear(2300);
        assertFalse(leapYear.getLeapYear(), "2300 should not be a leap year");
    }

    @Test
    void testLeapYear2500() {
        LeapYear leapYear = new LeapYear();
        leapYear.setInputYear(2500);
        assertFalse(leapYear.getLeapYear(), "2500 should not be a leap year");
    }
}