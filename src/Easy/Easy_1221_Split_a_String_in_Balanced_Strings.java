// 1221. Split a String in Balanced Strings
package Easy;

public class Easy_1221_Split_a_String_in_Balanced_Strings {
    public static int balancedStringSplit(String s) {
        int countL = 0, countR = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') countL++;
            else countR++;
            if (countL == countR) {
                count++;
                countL = countR = 0;
            }
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
        System.out.println(balancedStringSplit("LLLLRRRR"));
    }
}
