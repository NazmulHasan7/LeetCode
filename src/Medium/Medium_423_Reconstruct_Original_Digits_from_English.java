// 423. Reconstruct Original Digits from English
package Medium;

public class Medium_423_Reconstruct_Original_Digits_from_English {
    public static String originalDigits(String s) {
        int[] charFreq = new int[26];
        for (char c : s.toCharArray())
            charFreq[c-'a']++;

        int[] digCount = new int[10];
        // unique characters against the digit
        digCount[0] = charFreq['z'-'a']; // zero
        digCount[2] = charFreq['w'-'a']; // two
        digCount[4] = charFreq['u'-'a']; // four
        digCount[6] = charFreq['x'-'a']; // six
        digCount[8] = charFreq['g'-'a']; // eight

        // derived numbers
        digCount[1] = charFreq['o'-'a'] - digCount[0] - digCount[2] - digCount[4];
        digCount[3] = charFreq['h'-'a'] - digCount[8]; // three
        digCount[5] = charFreq['f'-'a'] - digCount[4]; // five
        digCount[7] = charFreq['s'-'a'] - digCount[6]; // seven
        digCount[9] = (charFreq['n'-'a'] - digCount[1] - digCount[7])/2;

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<10; i++)
            while (digCount[i]-- > 0)
                sb.append(i);

        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(originalDigits("owoztneoer"));
        System.out.println(originalDigits("fviefuro"));
    }
}
