// 2287. Rearrange Characters to Make Target String
package Easy;

public class Easy_2287_Rearrange_Characters_to_Make_Target_String {
    public static int rearrangeCharacters(String s, String target) {
        int[] sFreq = new int[26];
        for (char c : s.toCharArray())
            sFreq[c-'a']++;

        int[] targetFreq = new int[26];
        for (char c : target.toCharArray())
            targetFreq[c-'a']++;

        int count = Integer.MAX_VALUE;
        for (char c : target.toCharArray())
            count = Math.min(count, sFreq[c-'a']/targetFreq[c-'a']);
        return count;
    }
    public static void main(String[] args) {
        System.out.println(rearrangeCharacters("ilovecodingonleetcode", "code"));
        System.out.println(rearrangeCharacters("abcba", "abc"));
        System.out.println(rearrangeCharacters("abbaccaddaeea", "aaaaa"));
    }
}
