// 1324. Print Words Vertically
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_1324_Print_Words_Vertically {
    public static List<String> printVertically(String s) {
        List<String> result = new ArrayList<>();
        String[] srr = s.split(" ");

        int maxLength = srr[0].length();
        for (int i=1; i<srr.length; i++)
            maxLength = Math.max(maxLength, srr[i].length());

        for (int i=0; i<maxLength; i++) {
            StringBuilder sb = new StringBuilder();
            for (String word : srr) {
                if (i < word.length()) {
                    sb.append(word.charAt(i));
                } else sb.append(" ");
            } result.add(sb.toString().stripTrailing());
        } return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(printVertically("TO BE OR NOT TO BE").toArray()));
        System.out.println(Arrays.toString(printVertically("CONTEST IS COMING").toArray()));
        System.out.println(Arrays.toString(printVertically("HOW ARE YOU").toArray()));
    }
}
