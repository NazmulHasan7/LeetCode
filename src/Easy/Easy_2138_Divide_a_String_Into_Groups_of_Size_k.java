// 2138. Divide a String Into Groups of Size k
package Easy;
import java.util.Arrays;

public class Easy_2138_Divide_a_String_Into_Groups_of_Size_k {
    public static String[] divideString(String s, int k, char fill) {
        int size = s.length();
        int lastStringX = size % k;
        int times = (int)((double)size/k);

        String[] result = new String[lastStringX > 0 ? times+1: times];
        int i;
        for (i=0; i<times; i++)
            result[i] = s.substring(k*i, k*i+k);
        if (lastStringX > 0)
            result[i] = s.substring(k*i, k*i+lastStringX) + String.valueOf(fill).repeat(k-lastStringX);
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(divideString("abcdefghi", 3, 'x')));
        System.out.println(Arrays.toString(divideString("abcdefghij", 3, 'x')));
    }
}
