// 387. First Unique Character in a String
package Easy;

public class Easy_387_First_Unique_Character_in_a_String {
    public static int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c-97]++;
        for (int i=0; i<s.length(); i++)
            if (freq[s.charAt(i)-97] == 1)
                return i;
        return -1;
    }
    public static int firstUniqCharBetter(String s) {
        int resIndex = Integer.MAX_VALUE;
        int index;
        for (char c='a'; c<='z'; c++) {
            index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c))
                resIndex = Math.min(resIndex, index);
        } return (resIndex == Integer.MAX_VALUE) ? -1 : resIndex;
    }
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("aabb"));
    }
}
