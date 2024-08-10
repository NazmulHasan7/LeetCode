// 1370. Increasing Decreasing String
package Easy;

public class Easy_1370_Increasing_Decreasing_String {
    public static String sortString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c-'a']++;
        StringBuilder sb = new StringBuilder();

        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i=0; i<26; i++) {
                if (freq[i] > 0) {
                    sb.append((char)(i+'a'));
                    freq[i]--;
                    flag = true;
                }
            }
            for (int i=25; i>=0; i--) {
                if (freq[i] > 0) {
                    sb.append((char)(i+'a'));
                    freq[i]--;
                    flag = true;
                }
            }
        } return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(sortString("aaaabbbbcccc"));
        System.out.println(sortString("rat"));
    }
}
