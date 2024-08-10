// 2027. Minimum Moves to Convert String
package Easy;

public class Easy_2027_Minimum_Moves_to_Convert_String {
    public static int minimumMoves(String s) {
        int count = 0, i = 0;
        int length = s.length();
        while (i < length) {
            if (s.charAt(i) == 'X') {
                count++;
                i += 3;
            } else i++;
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(minimumMoves("XXX"));
        System.out.println(minimumMoves("XXOX"));
        System.out.println(minimumMoves("OOOO"));
    }
}
