package Strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    private static final Map<Character, Integer> romanToInt = new HashMap<>();
    static {
        romanToInt.put('I', 1);
        romanToInt.put('V', 5);
        romanToInt.put('X', 10);
        romanToInt.put('L', 50);
        romanToInt.put('C', 100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);
    }

    public int romanToInt(String s) {
        int sum = 0;

        for (var i = 0; i < s.length() - 1; i++) {
            if (romanToInt.get(s.charAt(i)) < romanToInt.get(s.charAt(i + 1))) {
                sum -= romanToInt.get(s.charAt(i));
            } else {
                sum += romanToInt.get(s.charAt(i));
            }
        }

        sum += romanToInt.get(s.charAt(s.length() - 1));

        return sum;
    }

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();

        System.out.println(romanToInt.romanToInt("III"));
        System.out.println(romanToInt.romanToInt("IV"));
        System.out.println(romanToInt.romanToInt("IX"));
        System.out.println(romanToInt.romanToInt("LVIII"));
        System.out.println(romanToInt.romanToInt("MCMXCIV"));
    }
}
