// 2185. Counting Words With a Given Prefix
package Easy;

public class Easy_2185_Counting_Words_With_a_Given_Prefix {
    public static int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words)
            if (word.startsWith(pref))
                count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(prefixCount(new String[] {"pay","attention","practice","attend"}, "at"));
        System.out.println(prefixCount(new String[] {"leetcode","win","loops","success"}, "code"));
    }
}
