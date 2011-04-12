package exercise;

import java.math.BigInteger;

public class Translator {
    String[] DIGITS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    String[] TENS = {"NaN", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    String[] TEENS = {"NaN", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    public String translate(int i) {
        if (i < 10)
            return DIGITS[i];
        else
            return translateTwoDigits(i);
    }

    private String translateTwoDigits(int i) {
        if (i%10 == 0)
            return TENS[i/10];
        else if (i > 20)
            return translateTwoDigits(i - i%10)+" "+translate(i%10);
        else
            return TEENS[i-10];
    }

}
