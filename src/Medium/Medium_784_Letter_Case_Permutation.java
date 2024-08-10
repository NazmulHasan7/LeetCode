// 784. Letter Case Permutation
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_784_Letter_Case_Permutation {
    public static List<String> letterCasePermutation(String s) {
        List<String> answer = new ArrayList<>();
        backtrack(0, s.length(), s, new StringBuilder(), answer);
        return answer;
    }
    private static void backtrack(int idx, int n, String s, StringBuilder sb, List<String> answer) {
        if (idx == n) {
            answer.add(sb.toString());
            return;
        }
        if (idx < n) {
            char c = s.charAt(idx);
            if (Character.isAlphabetic(c)) {
                // Add Lowercase
                sb.append(Character.toLowerCase(c));
                backtrack(idx + 1, n, s, sb, answer);
                sb.deleteCharAt(sb.length()-1);
                // Add Uppercase
                sb.append(Character.toUpperCase(c));
                backtrack(idx + 1, n, s, sb, answer);
                sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(c);
                backtrack(idx+1, n, s, sb, answer);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public static List<String> letterCasePermutationBetter(String s) {
        char[] arr = s.toCharArray();
        ArrayList<String> answer = new ArrayList<>();
        backtrackBetter(arr, 0, answer);
        return answer;
    }
    private static void backtrackBetter (char[] arr, int idx, ArrayList<String> ans){
        if(idx == arr.length) {
            ans.add(new String(arr));
            return;
        }
        if(Character.isAlphabetic(arr[idx])){
            arr[idx] = Character.toUpperCase(arr[idx]);
            backtrackBetter(arr,idx + 1,ans);
            arr[idx] = Character.toLowerCase(arr[idx]);
            backtrackBetter(arr,idx + 1,ans);
        } else {
            backtrackBetter(arr,idx + 1,ans);
        }
    }
    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
        System.out.println(letterCasePermutationBetter("a1b2"));
    }
}
