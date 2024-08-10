// 1208. Get Equal Substrings Within Budget
package Medium;

public class Medium_1208_Get_Equal_Substrings_Within_Budget {
    public static int equalSubstring(String s, String t, int maxCost) {
        int answer = 0, left = 0, right = 0;
        int cost = 0;
        while (right < s.length()) {
            cost += Math.abs(s.charAt(right)-t.charAt(right));
            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(left)-t.charAt(left));
                left++;
            }
            answer = Math.max(answer, right-left+1);
            right++;
        } return answer;
    }
    public static int equalSubstringFaster(String s, String t, int maxCost) {
        int answer = 0, left = 0, right = 0;
        int cost = 0;
        int n = s.length();
        int[] diff = new int[n];

        for (int i=0; i<n; i++)
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));

        while (right < n) {
            cost += diff[right];
            while (cost > maxCost) {
                cost -= diff[left];
                left++;
            }
            answer = Math.max(answer, right-left+1);
            right++;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(equalSubstring("abcd", "bcdf", 3));
        System.out.println(equalSubstring("abcd", "cdef", 3));
        System.out.println(equalSubstring("abcd", "acde", 0));
    }
}
