// 1980. Find Unique Binary String
package Medium;
import java.util.HashSet;
import java.util.List;

public class Medium_1980_Find_Unique_Binary_String {
    public static String findDifferentBinaryString(String[] nums) {
        StringBuilder answer = new StringBuilder();
        HashSet<String> set = new HashSet<>(List.of(nums));
        return backtrack(nums[0].length(), answer, nums, set);
    }
    private static String backtrack(int k, StringBuilder sb, String[] nums, HashSet<String> set) {
        if (k == 0) {
            String candidate = sb.toString();
            if (!set.contains(candidate))
                return candidate;
            return null;
        }
        // Choose to add 0
        sb.append("0");
        String result = backtrack(k-1, sb, nums, set);
        if (result != null) return result;
        sb.deleteCharAt(sb.length()-1);

        // Choose to add 1
        sb.append("1");
        result = backtrack(k-1, sb, nums, set);
        if (result != null) return result;
        sb.deleteCharAt(sb.length()-1);

        return null;
    }
    public static String findDifferentBinaryStringBetter(String[] nums) {
        int len = nums.length;
        char[] arr = new char[len];

        for (int i=0; i<len; i++) {
            // Flip the ith character of nums[i] to create a unique string
            arr[i] = nums[i].charAt(i) == '0' ? '1' : '0';
        } return new String(arr);
    }
    public static void main(String[] args) {
        System.out.println(findDifferentBinaryString(new String[]{"01", "10"}));
        System.out.println(findDifferentBinaryString(new String[]{"00", "01"}));
        System.out.println(findDifferentBinaryString(new String[]{"111","011","001"}));
    }
}
