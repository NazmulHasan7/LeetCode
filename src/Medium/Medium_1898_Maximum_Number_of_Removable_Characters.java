// 1898. Maximum Number of Removable Characters
package Medium;

public class Medium_1898_Maximum_Number_of_Removable_Characters {
    public static int maximumRemovals(String s, String p, int[] removable) {
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();

        int start = 0, end = removable.length-1;
        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            // Assuming of removal of character
            for (int i=start; i<=mid; i++)
                sArr[removable[i]] = '*';

            if (isSubsequence(sArr, pArr)) {
                start = mid + 1;
                answer = start; // since mid is index [start at 0]
            } else { // Reset the character array
                for (int i=start; i<=mid; i++)
                    sArr[removable[i]] = s.charAt(removable[i]);
                end = mid - 1;
            }
        } return answer;
    }
    private static boolean isSubsequence(char[] sArr, char[] pArr) {
        int i1 = 0, i2 = 0;
        while (i1 < sArr.length && i2 < pArr.length) {
            if (sArr[i1] == pArr[i2])
                i2++;
            i1++;
        } return i2 == pArr.length;
    }
    public static void main(String[] args) {
        System.out.println(maximumRemovals("abcacb", "ab", new int[]{3,1,0}));
        System.out.println(maximumRemovals("abcbddddd", "abcd", new int[]{3,2,1,4,5,6}));
        System.out.println(maximumRemovals("abcab", "abc", new int[]{0,1,2,3,4}));
    }
}
