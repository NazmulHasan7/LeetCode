// 1415. The k-th Lexicographical String of All Happy Strings of Length n
package Medium;

public class Medium_1415_The_k_th_Lexicographical_String_of_All_Happy_Strings_of_Length_n {
    static char[] chars = {'a','b','c'};
    static int count;
    static String answer;
    public static String getHappyString(int n, int k) {
        answer = "";
        count = 0;
        backtrack(new StringBuilder(), n, k);
        return answer;
    }
    private static void backtrack(StringBuilder sb, int n, int k) {
        if (!answer.isEmpty()) return;
        if (sb.length() == n) {
            count++;
            if (count == k)
                answer = sb.toString();
            return;
        }
        for (char c : chars) {
            if (sb.isEmpty() || sb.charAt(sb.length()-1) != c) {
                sb.append(c);
                backtrack(sb, n, k);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(getHappyString(1,3));
        System.out.println(getHappyString(1,4));
        System.out.println(getHappyString(3,9));
    }
}
