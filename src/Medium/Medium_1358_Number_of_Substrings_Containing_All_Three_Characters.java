// 1358. Number of Substrings Containing All Three Characters
package Medium;

public class Medium_1358_Number_of_Substrings_Containing_All_Three_Characters {
    public static int numberOfSubstrings(String s) {
        int left = 0, right = 0, n = s.length();
        int answer = 0, count = 0;
        int[] freq = new int[3];

        while (right < n) {
            char c = s.charAt(right);
            freq[c-'a']++;
            if (freq[c-'a'] == 1)
                count++;

            while (count >= 3 && left < n) {
                answer += n - right;
                char x = s.charAt(left);
                freq[x-'a']--;
                if (freq[x-'a'] == 0)
                    count--;
                left++;
            } right++;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
        System.out.println(numberOfSubstrings("aaacb"));
        System.out.println(numberOfSubstrings("abc"));
    }
}
