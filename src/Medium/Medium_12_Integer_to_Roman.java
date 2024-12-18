// 12. Integer to Roman
package Medium;

public class Medium_12_Integer_to_Roman {
    public static String intToRoman(int num) {
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values =    {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder answer = new StringBuilder();
        int idx = 0;
        while (num > 0) {
            if (num >= values[idx]) {
                num -= values[idx];
                answer.append(symbol[idx]);
            } else {
                idx++;
            }
        } return answer.toString();
    }
    public static void main(String[] args) {
        System.out.println(intToRoman(3749));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }
}
