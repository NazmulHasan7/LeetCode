// 1309. Decrypt String from Alphabet to Integer Mapping
package Easy;

public class Easy_1309_Decrypt_String_from_Alphabet_to_Integer_Mapping {
    public static String freqAlphabets(String s) {
        char[] cArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int value;
        for (int i=cArr.length-1; i>=0; i--) {
            if (cArr[i] == '#') {
                value = (cArr[i-1]-'0' + (cArr[i-2]-'0') * 10);
                sb.append((char) (value + 'a' - 1));
                i -= 2;
            } else sb.append((char)(cArr[i] - '0' + 'a' - 1));
        } return sb.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(freqAlphabets("10#11#12"));
        System.out.println(freqAlphabets("1326#"));
    }
}
