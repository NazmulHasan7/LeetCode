// Easy_1768_Merge_Strings_Alternately
package Easy;

public class Easy_1768_Merge_Strings_Alternately {
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int i=0, j=0;
        while (i < len1 && j<len2) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }
        if (i < len1)
            sb.append(word1, i, len1);
        if (j < len2)
            sb.append(word2, j, len2);
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
        System.out.println(mergeAlternately("ab", "pqrs"));
        System.out.println(mergeAlternately("abcd", "pq"));
    }
}
