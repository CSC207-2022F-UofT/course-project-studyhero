package UI.screens.timer_screen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertTimeToSecondsHelperTest {

    @Test
    void convertTimeToSecondsMin() {
        ConvertTimeToSecondsHelper convertTimeToSecondsHelper = new ConvertTimeToSecondsHelper();
        assertEquals(0, convertTimeToSecondsHelper.convertTimeToSeconds("00:00:00"));
    }

    @Test
    void convertTimeToSecondsMax() {
        ConvertTimeToSecondsHelper convertTimeToSecondsHelper = new ConvertTimeToSecondsHelper();
        assertEquals(359999, convertTimeToSecondsHelper.convertTimeToSeconds("99:59:59"));
    }

    @Test
    void convertTimeToSeconds() {
        ConvertTimeToSecondsHelper convertTimeToSecondsHelper = new ConvertTimeToSecondsHelper();
        assertEquals(600, convertTimeToSecondsHelper.convertTimeToSeconds("00:10:00"));
    }
}