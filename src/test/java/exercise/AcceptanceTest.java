package exercise;/*
Take a number and give the equivalent number in British English words e.g.
	1 = one
	21 = twenty one
	105 = one hundred and five
	56945781 = fifty six million nine hundred and forty five thousand seven hundred and eighty one
 */

import org.junit.Test;
import static org.junit.Assert.*;
public class AcceptanceTest {

    @Test public void shouldTakeANumberAndGiveTheEquivalentNumberInBritishEnglishWords() {
        Translator translator = new Translator();
        assertEquals("fifty six million nine hundred and forty five thousand seven hundred and eighty one", translator.translate(56945781));
    }


}
