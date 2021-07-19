import java.util.List;
import java.util.stream.Collectors;

public class CharsFromString {
    private static final char ENGLISH_ZERO = '0';
    private static final char BANGLA_ZERO = '০';
    private static final char HINDI_ZERO = '०';

    public static void main(String[] args) {
        String name = "test string";

        List<String> charactersAsString = name.chars()
                                              .mapToObj(c -> String.valueOf((char) c))
                                              .collect(Collectors.toList());
        System.out.println(name + " every characters as List<String> " + charactersAsString);

        String englishDigits = "0123456789 non digits wont't be converted! দেখা যাক!";

        String banglaDigits = getConvertedDigits(englishDigits, ENGLISH_ZERO, BANGLA_ZERO);
        System.out.println(englishDigits + " To " + banglaDigits);

        banglaDigits = "০১২৩৪৫৬৭৮৯ অংক ছাড়া বাকিটা রুপান্তরিত হবেনা! lets see!";

        englishDigits = getConvertedDigits(banglaDigits, BANGLA_ZERO, ENGLISH_ZERO);
        System.out.println(banglaDigits + " To " + englishDigits);

        String hindiDigits = getConvertedDigits(banglaDigits, BANGLA_ZERO, HINDI_ZERO);
        System.out.println(banglaDigits + " To " + hindiDigits);
    }

    private static String getConvertedDigits(String digits, char fromZero, char toZero) {
        return digits.chars()
                     .mapToObj(c -> (char) c)
                     .map(c -> convertDigit(c, fromZero, toZero))
                     .map(String::valueOf)
                     .collect(Collectors.joining(""));
    }

    public static char convertDigit(char c, char fromZero, char toZero) {
        int order = c - fromZero;
        if (order < 0 || order > 9) return c;
        return (char) (toZero + order);
    }
}
