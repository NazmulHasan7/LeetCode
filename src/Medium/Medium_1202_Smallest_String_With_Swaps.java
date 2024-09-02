// 1202. Smallest String With Swaps
package Medium;
import java.util.*;

public class Medium_1202_Smallest_String_With_Swaps {
    private static int find(int i, int[] parent) {
        if (i == parent[i]) return i;
        return parent[i] = find(parent[i], parent);
    }
    private static void union(int x, int y, int[] parent) {
        int xParent = find(x, parent);
        int yParent = find(y, parent);

        if (xParent != yParent)
            parent[yParent] = xParent;
    }
    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        int[] parent = new int[n];
        for (int i=0; i<n; i++) parent[i] = i;

        for (List<Integer> pair : pairs)
            union(pair.get(0), pair.get(1), parent);

        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            int par = find(i, parent);

            if (!map.containsKey(par))
                map.put(par, new PriorityQueue<>());

            // add current character to it's parent's min heap
            map.get(par).add(s.charAt(i));
        }
        char[] answer = s.toCharArray();
        for (int i=0; i<n; i++) {
            int par = find(i, parent);
            answer[i] = map.get(par).poll();
        }
        return new String(answer);
    }
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(0,3));
        arr.add(Arrays.asList(1,2));
        System.out.println(smallestStringWithSwaps("dcab", arr));

        arr = new ArrayList<>();
        arr.add(Arrays.asList(0,3));
        arr.add(Arrays.asList(1,2));
        arr.add(Arrays.asList(0,2));
        System.out.println(smallestStringWithSwaps("dcab", arr));
    }
}
