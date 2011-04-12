package exercise;

import org.junit.Test;
import static org.junit.Assert.*;

public class TranslatorTest {
    private Translator translator = new Translator();

    @Test public void shouldTranslateASingleDigit() {
        shouldTranslate(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9,},
                     new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"});
    }

    @Test public void shouldTranslateMultiplesOfTenUpToNinety() {
        shouldTranslate(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90,},
                             new String[]{"ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"});
    }

    @Test public void shouldTranslateTheTeens() {
        shouldTranslate(new int[]{11, 12, 13, 14, 15, 16, 17, 18, 19,},
                     new String[]{"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"});

    }

    @Test public void shouldTranslateNumbersBetweenTwentyOneAndNinetyNine() {
        shouldTranslate(new int[]{21, 37, 99},
        new String[]{"twenty one", "thirty seven", "ninety nine"});
    }



    private void shouldTranslate(int[] from, String[] to) {
        for (int i=0; i< from.length; i++) {
            assertEquals(to[i], translator.translate(from[i]));
        }
    }
}
