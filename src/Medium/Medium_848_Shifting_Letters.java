// 848. Shifting Letters
package Medium;

public class Medium_848_Shifting_Letters {
    public static String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        char[] crr = new char[n];

        int shift = 0;
        for (int i=n-1; i>=0; i--) {
            shift = (shift + shifts[i]) % 26;
            crr[i] = (char) ('a' + (s.charAt(i) - 'a' + shift) % 26);
        }
        return new String(crr);
    }
    public static void main(String[] args) {
        System.out.println(shiftingLetters("aaa", new int[]{1,2,3}));
        System.out.println(shiftingLetters("abc", new int[]{3,5,9}));
    }
}
