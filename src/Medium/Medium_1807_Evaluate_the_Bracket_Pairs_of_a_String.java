// 1807. Evaluate the Bracket Pairs of a String
package Medium;
import java.util.HashMap;
import java.util.List;

public class Medium_1807_Evaluate_the_Bracket_Pairs_of_a_String {
    // TC & SC -> O(n+k)
    public static String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> list : knowledge)
            map.put(list.get(0), list.get(1));

        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<n; i++) {
            if (s.charAt(i) == '(') {
                int start = i+1;
                while (s.charAt(i) != ')') i++;
                sb.append(map.getOrDefault(s.substring(start, i), "?"));
            } else {
                sb.append(s.charAt(i));
            }
        } return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(evaluate("(name)is(age)yearsold", List.of(List.of("name","bob"),
                List.of("age", "two"))));
    }
}
