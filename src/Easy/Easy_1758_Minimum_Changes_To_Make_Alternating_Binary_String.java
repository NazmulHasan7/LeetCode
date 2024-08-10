// 1758. Minimum Changes To Make Alternating Binary String
package Easy;

public class Easy_1758_Minimum_Changes_To_Make_Alternating_Binary_String {
    public static int count(char[] cArr, char prev) {
        int count = 0;
        for (char c : cArr) {
            if (c == prev) {
                count++;
                prev = (c == '0') ? '1' : '0';
            } else prev = c;
        } return count;
    }
    public static int minOperations(String s) {
        int count0 = count(s.toCharArray(), '0');
        int count1 = count(s.toCharArray(), '1');
        return Math.min(count0, count1);
    }
    public static void main(String[] args) {
        System.out.println(minOperations("0100"));
        System.out.println(minOperations("10"));
        System.out.println(minOperations("1111"));
        System.out.println(minOperations("10010100"));
        System.out.println(minOperations("01001"));
    }
}
