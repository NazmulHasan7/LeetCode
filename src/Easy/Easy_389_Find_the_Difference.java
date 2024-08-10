// 389. Find the Difference
package Easy;

public class Easy_389_Find_the_Difference {
    public static char findTheDifference(String s, String t) {
        int tSum = 0, sSum = 0;
        int i = 0, n = s.length();
        while (i < n) {
            sSum += s.charAt(i);
            tSum += t.charAt(i);
            i++;
        } tSum += t.charAt(i);
        return (char) (tSum - sSum);
    }
    public static char findTheDifferenceBitManipulation(String s, String t) {
        int xor = 0;
        int i = 0, n = s.length();
        while (i < n) {
            xor ^= s.charAt(i);
            xor ^= t.charAt(i);
            i++;
        } xor ^= t.charAt(i);
        return (char) xor;
    }
    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
        System.out.println(findTheDifference("", "y"));
        System.out.println(findTheDifferenceBitManipulation("abcd", "abcde"));
        System.out.println(findTheDifferenceBitManipulation("", "y"));
    }
}
