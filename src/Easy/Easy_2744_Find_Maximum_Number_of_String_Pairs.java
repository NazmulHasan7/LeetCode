// 2744. Find Maximum Number of String Pairs
package Easy;
import java.util.HashSet;

public class Easy_2744_Find_Maximum_Number_of_String_Pairs {
    public static String reverse(String s) {
        String reversedStr = "";
        for (int i=s.length()-1; i>=0; i--)
            reversedStr += s.charAt(i);
        return reversedStr;
    }
    public static int maximumNumberOfStringPairs(String[] words) {
        HashSet<String> set = new HashSet<>();
        int count = 0;
        for (String word : words) {
            if (set.contains(reverse(word)))
                count++;
            set.add(word);
        } return count;
    }
    public static int maximumNumberOfStringPairsBruteForce(String[] words) {
        int count = 0;
        for (int i=0; i<words.length; i++) {
            for (int j=i+1; j<words.length; j++) {
                if (words[i].charAt(0) == words[j].charAt(1)
                && words[i].charAt(1) == words[j].charAt(0))
                    count++;
            }
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(maximumNumberOfStringPairs(new String[]{"cd","ac","dc","ca","zz"}));
        System.out.println(maximumNumberOfStringPairsBruteForce(new String[]{"ab","ba","cc"}));
        System.out.println(maximumNumberOfStringPairs(new String[]{"aa","ab"}));
    }
}
