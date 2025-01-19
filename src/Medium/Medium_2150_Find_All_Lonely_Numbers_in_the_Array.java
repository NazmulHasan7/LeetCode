// 2150. Find All Lonely Numbers in the Array
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_2150_Find_All_Lonely_Numbers_in_the_Array {
    public static List<Integer> findLonely(int[] nums) {
        /* HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        List<Integer> answer = new ArrayList<>();
        for (int key : map.keySet())
            if (map.get(key) == 1 && !map.containsKey(key-1) && !map.containsKey(key+1))
                answer.add(key);

        return answer; */

        int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] freq = new int[(max-min+1)+2]; // to check num-1 and num+1
        for (int num : nums)
            freq[num-min+1]++;

        List<Integer> answer = new ArrayList<>();
        for (int num : nums) {
            int idx = num - min + 1;
            if (freq[idx] == 1 && freq[idx-1] == 0 && freq[idx+1] == 0)
                answer.add(num);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(findLonely(new int[]{10,6,5,8}));
        System.out.println(findLonely(new int[]{1,3,5,3}));
    }
}
