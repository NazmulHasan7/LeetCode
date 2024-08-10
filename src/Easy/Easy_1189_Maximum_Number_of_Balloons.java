// 1189. Maximum Number of Balloons
package Easy;

public class Easy_1189_Maximum_Number_of_Balloons {
    public static int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for (char c : text.toCharArray())
            freq[c-'a']++;

        String target = "balloon";
        int minCount = Integer.MAX_VALUE;
        for (char c : target.toCharArray()) {
            if (c == 'o' || c == 'l')
                minCount = Math.min(minCount, freq[c-'a']/2);
            else minCount = Math.min(minCount, freq[c-'a']);
        } return minCount;
    }
    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("nlaebolko"));
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(maxNumberOfBalloons("leetcode"));
    }
}
