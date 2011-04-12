package exercise;

import org.junit.Test;
import static org.junit.Assert.*;

public class TranslatorTest {
    private Translator translator = new Translator();

    @Test public void shouldTranslateASingleDigit() {
        assertEquals("zero", translator.translate(0));
        assertEquals("one", translator.translate(1));
        assertEquals("two", translator.translate(2));
        assertEquals("three", translator.translate(3));
        assertEquals("four", translator.translate(4));
        assertEquals("five", translator.translate(5));
        assertEquals("six", translator.translate(6));
        assertEquals("seven", translator.translate(7));
        assertEquals("eight", translator.translate(8));
        assertEquals("nine", translator.translate(9));
    }

    @Test public void shouldTranslateMultiplesOfTenUpToNinety() {
        assertEquals("ten", translator.translate(10));
        assertEquals("twenty", translator.translate(20));
        assertEquals("thirty", translator.translate(30));
        assertEquals("fourty", translator.translate(40));
        assertEquals("fifty", translator.translate(50));
        assertEquals("sixty", translator.translate(60));
        assertEquals("seventy", translator.translate(70));
        assertEquals("eighty", translator.translate(80));
        assertEquals("ninety", translator.translate(90));
    }

    @Test public void shouldTranslateTheTeens() {
        assertEquals("eleven", translator.translate(11));
        assertEquals("twelve", translator.translate(12));
        assertEquals("thirteen", translator.translate(13));
        assertEquals("fourteen", translator.translate(14));
        assertEquals("fifteen", translator.translate(15));
        assertEquals("sixteen", translator.translate(16));
        assertEquals("seventeen", translator.translate(17));
        assertEquals("eighteen", translator.translate(18));
        assertEquals("nineteen", translator.translate(19));
    }

    @Test public void shouldTranslateNumbersBetweenTwentyOneAndNinetyNine() {
        assertEquals("twenty one", translator.translate(21));
    }
}
