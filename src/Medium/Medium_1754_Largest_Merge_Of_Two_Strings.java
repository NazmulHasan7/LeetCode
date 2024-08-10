// 1754. Largest Merge Of Two Strings
package Medium;

public class Medium_1754_Largest_Merge_Of_Two_Strings {
    public static String largestMerge(String word1, String word2) {
        StringBuilder answer = new StringBuilder();
        int w1ptr = 0, w2ptr = 0;
        int w1Len = word1.length(), w2Len = word2.length();

        while (w1ptr < w1Len && w2ptr < w2Len) {
            char c1 = word1.charAt(w1ptr);
            char c2 = word2.charAt(w2ptr);
            if (c1 > c2) {
                answer.append(c1);
                w1ptr++;
            } else if (c2 > c1) {
                answer.append(c2);
                w2ptr++;
            } else {
                answer.append(c1);
                // Find the lexicographically greater one
                if (word1.substring(w1ptr).compareTo(word2.substring(w2ptr)) > 0)
                    w1ptr++;
                else w2ptr++;
            }
        }
        if (w1ptr < w1Len) answer.append(word1.substring(w1ptr));
        else if (w2ptr < w2Len) answer.append(word2.substring(w2ptr));
        return answer.toString();
    }
    public static void main(String[] args) {
        System.out.println(largestMerge("cabaa", "bcaaa"));
        System.out.println(largestMerge("abcabc", "abdcaba"));
    }
}
