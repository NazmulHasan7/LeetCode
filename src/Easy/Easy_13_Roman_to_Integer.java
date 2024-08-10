// 13. Roman to Integer
package Easy;
import java.util.HashMap;

public class Easy_13_Roman_to_Integer {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int number = 0, value;
        for (int i=s.length()-1; i>=0; i--) {
            value = map.get(s.charAt(i));
            if (i < s.length()-1 && value < map.get(s.charAt(i+1)))
                number -= value;
            else number += value;
        }
        return number;
    }
    public static int romanToIntBetter(String s) {
        int number = 0, prev = 0, current = 0;
        int i=s.length()-1;
        while (i>=0) {
            current = switch (s.charAt(i)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> current;
            };
            if (current < prev) number -= current;
            else number += current;
            prev = current;
            i--;
        }
        return number;
    }
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToIntBetter("III"));
        System.out.println(romanToIntBetter("LVIII"));
        System.out.println(romanToIntBetter("MCMXCIV"));
    }
}
