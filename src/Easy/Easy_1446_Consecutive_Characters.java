// 1446. Consecutive Characters
package Easy;

public class Easy_1446_Consecutive_Characters {
    public static int maxPower(String s) {
        int maxScore = 0, count = 0;
        int length = s.length();
        for (int i=0; i<length-1; i++) {
            if (s.charAt(i) == s.charAt(i+1))
                count++;
            else count = 0;
            maxScore = Math.max(maxScore, count);
        } return maxScore + 1;
    }
    public static void main(String[] args) {
        System.out.println(maxPower("leetcode"));
        System.out.println(maxPower("abbcccddddeeeeedcba"));
        System.out.println(maxPower("abc"));
    }
}
