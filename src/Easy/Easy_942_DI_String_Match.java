// 942. DI String Match
package Easy;
import java.util.Arrays;

public class Easy_942_DI_String_Match {
    public static int[] diStringMatch(String s) {
        int length = s.length();
        int[] perm = new int[length+1];
        int i=0, d=length;
        for (int x=0; x<length; x++) {
            if (s.charAt(x) == 'I')
                perm[x] = i++;
            else perm[x] = d--;
        } perm[length] = i;
        return perm;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(diStringMatch("IDID")));
        System.out.println(Arrays.toString(diStringMatch("III")));
        System.out.println(Arrays.toString(diStringMatch("DDI")));
    }
}
