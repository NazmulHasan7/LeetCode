// 455. Assign Cookies
package Easy;
import java.util.Arrays;

public class Easy_455_Assign_Cookies {
    public static int findContentChildren(int[] g, int[] s) {
        // g -> greed, s -> cookies size
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0, j=0, count=0;
        while (i<g.length && j<s.length) {
            System.out.printf("Greed %d [%d] -> Cookie size %d [%d]\n", i, g[i], j, s[j]);
            if (g[i] <= s[j]) {
                i++;
                count++;
            } j++;
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
        System.out.println(findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }
}
