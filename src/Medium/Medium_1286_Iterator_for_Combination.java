// 1286. Iterator for Combination
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_1286_Iterator_for_Combination {
    static class CombinationIterator {
        List<String> array;
        int k, n, current;
        char[] crr;
        public CombinationIterator(String characters, int combinationLength) {
            crr = characters.toCharArray();
            Arrays.sort(crr);
            array = new ArrayList<>();
            n = characters.length();
            k = combinationLength;
            current = 0;
            backtrack(0, k, n, new StringBuilder());
        }
        private void backtrack(int idx, int k, int n, StringBuilder sb) {
            if (k == 0) {
                array.add(sb.toString());
                return;
            }
            if (idx < n) {
                sb.append(this.crr[idx]);
                backtrack(idx + 1, k - 1, n, sb);
                sb.deleteCharAt(sb.length() - 1);
                backtrack(idx + 1, k, n, sb);
            }
        }
        public String next() {
            return array.get(current++);
        }
        public boolean hasNext() {
            return current < array.size();
        }
    }
    public static void main(String[] args) {
        CombinationIterator itr = new CombinationIterator("abc", 2);
        System.out.println(itr.next());    // return "ab"
        System.out.println(itr.hasNext()); // return True
        System.out.println(itr.next());    // return "ac"
        System.out.println(itr.hasNext()); // return True
        System.out.println(itr.next());    // return "bc"
        System.out.println(itr.hasNext()); // return False
    }
}
