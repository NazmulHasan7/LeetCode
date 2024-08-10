// 187. Repeated DNA Sequences
package Medium;
import java.util.*;

public class Medium_187_Repeated_DNA_Sequences {
    public static List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (int i=0; i<s.length()-9; i++) {
            String sub = s.substring(i, i+10);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet())
            if (entry.getValue() > 1) result.add(entry.getKey());
        return result;
    }
    public static List<String> findRepeatedDnaSequencesBetter(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        int length = s.length();

        for (int i=0; i<length-9; i++) {
            String sub = s.substring(i, i+10);
            if (!seen.add(sub))
                repeated.add(sub);
        } return new ArrayList<>(repeated);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRepeatedDnaSequences(
                "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").toArray()));
        System.out.println(Arrays.toString(findRepeatedDnaSequences("AAAAAAAAAAAAA").toArray()));
    }
}
