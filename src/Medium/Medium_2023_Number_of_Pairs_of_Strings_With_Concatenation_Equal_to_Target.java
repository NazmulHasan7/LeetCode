// 2023. Number of Pairs of Strings With Concatenation Equal to Target
package Medium;
import java.util.HashMap;

public class Medium_2023_Number_of_Pairs_of_Strings_With_Concatenation_Equal_to_Target {
    // Brute Force -> O(n^2)
    public static int numOfPairs(String[] nums, String target) {
        int n = nums.length;
        int count = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i != j) {
                    if ((nums[i] + nums[j]).equals(target))
                        count++;
                }
            }
        } return count;
    }
    // TC -> O(max(n,t)), SC -> O(n)
    public static int numOfPairsOpt(String[] nums, String target) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        int count = 0;
        int t = target.length();
        for (int i=1; i<t; i++) {
            String sub1 = target.substring(0, i);
            String sub2 = target.substring(i);

            if (map.containsKey(sub1) && map.containsKey(sub2)) {
                if (sub1.equals(sub2)) {
                    // If sub1 and sub2 are the same, it means we are dealing with duplicate substrings
                    // To avoid counting the same pair twice, we reduce the occurrence of sub1 by 1
                    count += ((map.get(sub1) - 1) * map.get(sub2));
                } else {
                    count += (map.get(sub1) * map.get(sub2));
                }
            }
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(numOfPairs(new String[]{"777","7","77","77"}, "7777"));
        System.out.println(numOfPairs(new String[]{"123","4","12","34"}, "1234"));
        System.out.println(numOfPairs(new String[]{"1","1","1"}, "11"));
    }
}
