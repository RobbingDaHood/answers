import java.util.Map;
import java.util.Optional;

public class Main {
    // https://stackoverflow.com/questions/70837554/roman-calculator-does-not-accept-invalid-input-format
    private static Map<Integer, Character> romanString = Map.of(
            1, 'A',
            2, 'B',
            3, 'C'
    );

    public static void main(String[] args) {
        System.out.println(letterToNumber('A'));
        try {
            System.out.println(letterToNumber('D'));
        } catch(UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(toRomanNumber(2));
        try {
            System.out.println(toRomanNumber(4));
        } catch(UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(toArabicNumber("ABC"));
        try {
            System.out.println(toArabicNumber("ABCD"));
        } catch(UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }

    }

    private static int letterToNumber(char letter) {
        return romanString.entrySet().stream()
                .filter(integerStringEntry -> integerStringEntry.getValue().equals(letter))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("DO not use this, make some custom exception!"))
                .getKey();
    }

    static Character toRomanNumber(int number) {
        Optional<Character> i = romanString.entrySet().stream()
                .filter(integerStringEntry -> integerStringEntry.getKey().equals(number))
                .map(Map.Entry::getValue)
                .findFirst();

        if (i.isPresent()) {
            return i.get();
        } else {
            throw new UnsupportedOperationException("DO not use this, make some custom exception!");
        }
    }

    static int toArabicNumber(String roman) {
        return roman.chars()
                .map(letter -> letterToNumber((char) letter))
                .sum();
    }
}