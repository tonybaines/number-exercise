package exercise;

import java.math.BigInteger;

public class Translator {
    String[] DIGITS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    String[] TENS = {"NaN", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    String[] TEENS = {"NaN", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    public String translate(int i) {
        if (i < 10)
            return translateSingleDigit(i);
        else if(i < 100)
            return translateTwoDigits(i);
        else if(i < 1000)
            return translateThreeDigits(i);
        else
            throw new IllegalArgumentException("Not implemented yet");
    }

    private String translateSingleDigit(int i) {
        return DIGITS[i];
    }

    private String translateTwoDigits(int i) {
        if (i%10 == 0)
            return TENS[i/10];
        else if (i > 20)
            return translate(i - i%10)+" "+translate(i%10);
        else
            return TEENS[i-10];
    }

    private String translateThreeDigits(int i) {
        if (i%100 == 0)
            return translate(i/100) + " hundred";
        else
            return translate(i - i%100)+" and "+translate(i%100);
    }

}
