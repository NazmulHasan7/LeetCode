// 179. Largest Number
package Medium;
import java.util.Arrays;
import java.util.Comparator;

public class Medium_179_Largest_Number {
    public static String largestNumber(int[] nums) {
        String[] srr = new String[nums.length];
        for (int i=0; i<nums.length; i++)
            srr[i] = String.valueOf(nums[i]);

        Arrays.sort(srr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });
        // Handle edge case where the array contains only zeros
        if (srr[0].equals("0")) return "0";

        StringBuilder result = new StringBuilder();
        for (String s : srr) result.append(s);
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[] {10, 2}));
        System.out.println(largestNumber(new int[] {3,30,34,5,9}));
    }
}
