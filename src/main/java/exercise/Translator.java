package exercise;

public class Translator {
    private static final int TEN = 10;
    private static final int ONE_HUNDRED = 100;
    private static final int ONE_THOUSAND = 1000;
    private static final int ONE_MILLION = 1000000;
    private static final int ONE_BILLION = 1000000000;
    private static final int MAX_VALUE = ONE_BILLION;

    private static final String[] DIGITS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] TENS = {"NaN", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] TEENS = {"NaN", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String EMPTY_STRING = "";
    private static final String SPACE = " ";

    public String translate(final int i) {
        if (i < TEN)
            return translateSingleDigit(i);
        else if (i < ONE_HUNDRED)
            return translateTens(i);
        else if (i < ONE_THOUSAND)
            return translate(i, ONE_HUNDRED, "hundred");
        else if (i < ONE_MILLION)
            return translate(i, ONE_THOUSAND, "thousand");
        else if (i < ONE_BILLION)
            return translate(i, ONE_MILLION, "million");
        else
            throw new IllegalArgumentException("I don't understand numbers bigger than " + MAX_VALUE);
    }

    private String translateSingleDigit(final int i) {
        return DIGITS[i];
    }

    private String translateTens(final int i) {
        int scaledDown = scaledDown(i, TEN);
        int remainder = remainder(i, TEN);
        if (remainder == 0)
            return TENS[scaledDown];
        else if (i > 20)
            return translate(i - remainder) + SPACE + translate(remainder);
        else
            return TEENS[i - TEN];
    }

    private String translate(final int i, final int scale, final String separator) {
        int scaledDown = scaledDown(i, scale);
        int remainder = remainder(i, scale);
        return translate(scaledDown) + SPACE + separator + translateRemainder(remainder);
    }

    private String translateRemainder(final int remainder) {
        if (remainder > 0)
            return lessThanOneHundredSpecialCase(remainder) + SPACE + translate(remainder);
        else
            return EMPTY_STRING;
    }

    private String lessThanOneHundredSpecialCase(final int remainder) {
        if (remainder < ONE_HUNDRED)
            return " and";
        else
            return EMPTY_STRING;
    }

    private int scaledDown(final int i, final int scale) { return i/scale; }
    private int remainder(final int i, final int scale) { return i%scale; }

}
