// 792. Number of Matching Subsequences
package Medium;
import java.util.HashMap;

public class Medium_792_Number_of_Matching_Subsequences {
    public static int numMatchingSubseq(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word,0)+1);

        int answer = 0;
        char[] crr = s.toCharArray();

        for (String str : map.keySet()) {
            char[] trr = str.toCharArray();
            int i = 0, j = 0;

            while (i < crr.length && j < trr.length) {
                if (crr[i] == trr[j]) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            if (j == trr.length)
                answer+= map.get(str);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(numMatchingSubseq("abcde", new String[]{"a","bb","acd","ace"}));
        System.out.println(numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"}));
    }
}
