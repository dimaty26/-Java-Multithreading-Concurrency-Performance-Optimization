package deutsche;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        String unique1 = "abcd";
        String unique2 = "abca";

//        boolean result1 = isSymbolsInStringUniqueWithHashSet(unique1);
//        boolean result2 = isSymbolsInStringUniqueWithHashSet(unique2);

        boolean result1 = isSymbolsInStringUnique(unique1);
        boolean result2 = isSymbolsInStringUnique(unique2);

        System.out.println("Should be true = " + result1);
        System.out.println("Should be false = " + result2);
    }

    public static boolean isSymbolsInStringUnique(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return false;
            }
        }

        // 1, 2, 3, 4, 5

        return true;
    }

    public static boolean isSymbolsInStringUniqueWithHashSet(String string) {
        char[] chars = string.toCharArray();
        Set<Character> symbols = new HashSet<>();

        for (char c : chars) {
            if (!symbols.add(c)) {
                return false;
            }
        }

        return true;
    }
}
