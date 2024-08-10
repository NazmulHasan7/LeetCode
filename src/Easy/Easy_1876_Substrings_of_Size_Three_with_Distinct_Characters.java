// 1876. Substrings of Size Three with Distinct Characters
package Easy;

public class Easy_1876_Substrings_of_Size_Three_with_Distinct_Characters {
    public static int countGoodSubstrings(String s) {
        int count = 0;
        char[] cArr = s.toCharArray();
        for (int i=0; i<cArr.length-2; i++) {
            if (cArr[i] != cArr[i+1] && cArr[i+1] != cArr[i+2] && cArr[i+2] != cArr[i])
                count++;
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("xyzzaz"));
        System.out.println(countGoodSubstrings("aababcabc"));
    }
}
