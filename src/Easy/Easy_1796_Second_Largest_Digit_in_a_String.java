// 796. Second Largest Digit in a String
package Easy;

public class Easy_1796_Second_Largest_Digit_in_a_String {
    public static int secondHighest(String s) {
        int secondHighest = -1, highest = -1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int number = c-'0';
                if (number > highest) {
                    secondHighest = highest;
                    highest = number;
                } else if (number != highest && number > secondHighest)
                    secondHighest = number;
            }
        } return secondHighest;
    }
    public static int secondHighestBetter(String s) {
        int count = 0;
        for (char c='9'; c>='0'; c--) {
            if (s.indexOf(c) != -1) count++;
            if (count == 2) return c-'0';
        } return -1;
    }
    public static void main(String[] args) {
        System.out.println(secondHighest("dfa12321afd"));
        System.out.println(secondHighest("abc1111"));
        System.out.println(secondHighest("sjhtz8344"));
    }
}