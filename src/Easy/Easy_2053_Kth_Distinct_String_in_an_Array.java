// 2053. Kth Distinct String in an Array
package Easy;
import java.util.HashMap;
import java.util.HashSet;

public class Easy_2053_Kth_Distinct_String_in_an_Array {
    public static String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : arr)
            map.put(str, map.getOrDefault(str, 0)+1);
        for (int i=0, count=0; i<arr.length && count<k; i++) {
            if (map.get(arr[i]) == 1) {
                count++;
                if (count == k) return arr[i];
            }
        } return "";
    }
    public static String kthDistinctBetter(String[] arr, int k) {
        HashSet<String> unique = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();
        for (String str : arr) {
            if (unique.contains(str))
                repeated.add(str);
            else unique.add(str);
        }
        for (String str : arr) {
            if (!repeated.contains(str))
                if (--k == 0) return str;
        } return "";
    }
    public static void main(String[] args) {
        System.out.println(kthDistinctBetter(new String[] {"d","b","c","b","c","a"}, 2));
        System.out.println(kthDistinctBetter(new String[] {"aaa","aa","a"}, 1));
        System.out.println(kthDistinctBetter(new String[] {"a", "b", "a"}, 3));
    }
}
