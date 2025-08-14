// 2007. Find Original Array From Doubled Array
package Medium;
import java.util.Arrays;
import java.util.HashMap;

public class Medium_2007_Find_Original_Array_From_Doubled_Array {
    public static int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) return new int[]{};
        Arrays.sort(changed);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : changed)
            map.put(num, map.getOrDefault(num, 0)+1);


        int[] answer = new int[n/2];
        int idx = 0;
        for (int num : changed) {
            if (map.containsKey(num)) {
                if (num == 0 && map.get(num) % 2 != 0)
                    return new int[]{};

                int target = num * 2;
                if (map.containsKey(target)) {
                    if (map.get(num) == 1) map.remove(num);
                    else map.put(num, map.get(num)-1);

                    if (map.get(target) == 1) map.remove(target);
                    else map.put(target, map.get(target)-1);

                    answer[idx++] = num;
                } else { // double not found for num
                    return new int[]{};
                }
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOriginalArray(new int[]{1,3,4,2,6,8})));
        System.out.println(Arrays.toString(findOriginalArray(new int[]{6,3,0,1})));
        System.out.println(Arrays.toString(findOriginalArray(new int[]{1})));
    }
}
