// 1023. Camelcase Matching
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_1023_Camelcase_Matching {
    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> answer = new ArrayList<>();
        int pLen = pattern.length();

        for (String query : queries) {
            int ptr = 0, idx;
            int qLen = query.length();
            for (idx=0; idx<qLen; idx++) {
                char c = query.charAt(idx);
                if (ptr < pLen && c == pattern.charAt(ptr)) {
                    ptr++;
                } else if (c>='A' && c<='Z') {
                    answer.add(false);
                    break;
                }
            }
            if (idx == qLen) {
                if (ptr == pLen) answer.add(true);
                else answer.add(false); // FrameBuffer - FoBa
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(camelMatch(new String[]
                {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FB").toArray()));
        System.out.println(Arrays.toString(camelMatch(new String[]
                {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FoBa").toArray()));
    }
}