// 1684. Count the Number of Consistent Strings
package Easy;

public class Easy_1684_Count_the_Number_of_Consistent_Strings {
    public static int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        boolean[] arr = new boolean[26];
        for (char c : allowed.toCharArray())
            arr[c-'a'] = true;

        boolean consistent;
        for (String word : words) {
            consistent = true;
            for (char c : word.toCharArray()) {
                if (!arr[c-'a']) {
                    consistent = false;
                    break;
                }
            } if (consistent) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countConsistentStrings("abc", new String[] {"a","b","c","ab","ac","bc","abc"}));
        System.out.println(countConsistentStrings("ab", new String[] {"ad","bd","aaab","baa","badab"}));
    }
}
