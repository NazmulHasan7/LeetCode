// 17. Letter Combinations of a Phone Number
package Medium;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Medium_17_Letter_Combinations_of_a_Phone_Number {
    static HashMap<Integer, String> map;
    public static List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if (digits.isEmpty()) return answer;

        map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        backtrack(0, digits, new StringBuilder(), answer);
        return answer;
    }
    private static void backtrack(int idx, String digits, StringBuilder sb, List<String> answer) {
        if (idx == digits.length()) {
            answer.add(sb.toString());
            return;
        }
        String currentStr = map.get(digits.charAt(idx) - '0');
        for (int i=0; i<currentStr.length(); i++) {
            sb.append(currentStr.charAt(i));
            backtrack(idx+1, digits, sb, answer);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("27"));
    }
}
