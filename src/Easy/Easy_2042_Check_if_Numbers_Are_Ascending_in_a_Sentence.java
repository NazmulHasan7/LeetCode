// 2042. Check if Numbers Are Ascending in a Sentence
package Easy;

public class Easy_2042_Check_if_Numbers_Are_Ascending_in_a_Sentence {
    public static boolean areNumbersAscending(String s) {
        String[] strArr = s.split(" ");
        int prev = 0, number;
        for (String str : strArr) {
            try {
                number = Integer.parseInt(str);
                if (number <= prev)
                    return false;
                else prev = number;
            } catch (Exception ignored) {}
        } return true;
    }
    public static boolean areNumbersAscendingBetter(String s) {
        int number, prev = 0;
        int length = s.length();
        for (int i=0; i<length; i++) {
            number = 0;
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                while (i < length && s.charAt(i) != ' ') {
                    number = number * 10 + (s.charAt(i) - '0');
                    i++;
                } if (number <= prev) return false;
                else prev = number;
            }
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
        System.out.println(areNumbersAscending("hello world 5 x 5"));
        System.out.println(areNumbersAscending("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"));
        System.out.println(areNumbersAscendingBetter("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
        System.out.println(areNumbersAscendingBetter("hello world 5 x 5"));
        System.out.println(areNumbersAscendingBetter("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"));
    }
}
