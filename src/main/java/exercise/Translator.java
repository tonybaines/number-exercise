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

    public String translate(int i) {
        if (i < TEN)
            return translateSingleDigit(i);
        else if(i < ONE_HUNDRED)
            return translateTens(i);
        else if(i < ONE_THOUSAND)
            return translateHundreds(i);
        else if(i < ONE_MILLION)
            return translateThousands(i);
        else if(i < ONE_BILLION)
            return translateMillions(i);
        else
            throw new IllegalArgumentException("I don't understand numbers bigger than " + MAX_VALUE);
    }

    private String translateSingleDigit(int i) {
        return DIGITS[i];
    }

    private String translateTens(int i) {
        if (i% TEN == 0)
            return TENS[i/ TEN];
        else if (i > 20)
            return translate(i - i% TEN)+" "+translate(i% TEN);
        else
            return TEENS[i- TEN];
    }

    private String translateHundreds(int i) {
        return translate(i/ONE_HUNDRED, i%ONE_HUNDRED, "hundred");
    }

    private String translateThousands(int i) {
        return translate(i/ONE_THOUSAND, i%ONE_THOUSAND, "thousand");
    }

    private String translateMillions(int i) {
        return translate(i/ONE_MILLION, i%ONE_MILLION, "million");
    }

    private String translate(int roundedDown, int remainder, String separator) {
        StringBuffer retVal = new StringBuffer(translate(roundedDown)+" "+separator);

        if (remainder > 0) {
            if (remainder < ONE_HUNDRED) { retVal.append(" and"); }
            retVal.append(" ");
            retVal.append(translate(remainder));
        }

        return retVal.toString();
    }

}
