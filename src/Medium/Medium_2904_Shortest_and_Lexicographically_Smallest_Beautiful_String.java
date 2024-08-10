// 2904. Shortest and Lexicographically Smallest Beautiful String
package Medium;

public class Medium_2904_Shortest_and_Lexicographically_Smallest_Beautiful_String {
    public static String shortestBeautifulSubstring(String s, int k) {
        String answer = "";
        int left = 0, right = 0, n = s.length();
        int count1 = 0, minLen = Integer.MAX_VALUE;

        while (right < n) {
            if (s.charAt(right) == '1')
                count1++;

            while (count1 == k) {
                int window = right-left+1;
                if (minLen > window) {
                    minLen = window;
                    answer = s.substring(left, right+1);
                } else if (minLen == window) {
                    String sub = s.substring(left, right+1);
                    if (sub.compareTo(answer) < 0)
                        answer = sub;
                }
                if (s.charAt(left) == '1') count1--;
                left++;
            } right++;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(shortestBeautifulSubstring("100011001",3));
        System.out.println(shortestBeautifulSubstring("1011",2));
        System.out.println(shortestBeautifulSubstring("000",1));
        System.out.println(shortestBeautifulSubstring("001110101101101111", 10));
    }
}
