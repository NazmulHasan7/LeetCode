// 2390. Removing Stars From a String
package Medium;

public class Medium_2390_Removing_Stars_From_a_String {
    public static String removeStars(String s) {
        int ptr = -1;
        char[] crr = s.toCharArray();
        int length = crr.length;

        for (int i=0; i<length; i++) {
            if (crr[i] == '*' && ptr > -1) ptr--;
            else crr[++ptr] = crr[i];
        }
        return String.valueOf(crr, 0, ptr+1);
    }
    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
        System.out.println(removeStars("erase*****"));
    }
}
