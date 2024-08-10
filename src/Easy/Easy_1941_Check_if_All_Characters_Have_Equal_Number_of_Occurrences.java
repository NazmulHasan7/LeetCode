// 1941. Check if All Characters Have Equal Number of Occurrences
package Easy;

public class Easy_1941_Check_if_All_Characters_Have_Equal_Number_of_Occurrences {
    public static boolean areOccurrencesEqual(String s) {
        int[] freqArr = new int[26];
        for (char c : s.toCharArray())
            freqArr[c - 'a']++;
        int count = freqArr[s.charAt(0)-'a'];
        for (int f : freqArr)
            if (f != 0 && f != count) return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(areOccurrencesEqual("abacbc"));
        System.out.println(areOccurrencesEqual("aaabb"));
        System.out.println(areOccurrencesEqual("vvvvvvvvvvvvvvvvvvv"));
    }
}
