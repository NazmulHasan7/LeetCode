// 14. Longest Common Prefix
package Easy;

public class Easy_14_Longest_Common_Prefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i=1; i<strs.length; i++) {
            while (!strs[i].startsWith(prefix))
                prefix = prefix.substring(0, prefix.length()-1);
        } return prefix;
    }
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[] {"dog","racecar","car"}));
    }
}
