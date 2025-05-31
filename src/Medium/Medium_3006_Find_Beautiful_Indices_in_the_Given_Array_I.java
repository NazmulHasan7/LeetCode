// 3006. Find Beautiful Indices in the Given Array I
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_3006_Find_Beautiful_Indices_in_the_Given_Array_I {
    public static List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> aIndices = new ArrayList<>();
        List<Integer> bIndices = new ArrayList<>();

        int iIdx = s.indexOf(a);
        while (iIdx != -1) {
            aIndices.add(iIdx);
            iIdx = s.indexOf(a, iIdx+1);
        }

        int jIdx = s.indexOf(b);
        while (jIdx != -1) {
            bIndices.add(jIdx);
            jIdx = s.indexOf(b, jIdx+1);
        }

        List<Integer> answer = new ArrayList<>();
        for (int i : aIndices) {
            for (int j : bIndices) {
                if (Math.abs(j - i) <= k) {
                    answer.add(i);
                    break;
                }
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(beautifulIndices("isawsquirrelnearmysquirrelhouseohmy", "my", "squirrel", 15));
        System.out.println(beautifulIndices("abcd","a","a",4));
    }
}
