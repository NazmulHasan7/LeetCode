// 658. Find K Closest Elements
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_658_Find_K_Closest_Elements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0, end = arr.length-1;
        while (end - start >= k) {
            if (Math.abs(arr[start]-x) > Math.abs(arr[end]-x))
                start++;
            else end--;
        }
        List<Integer> answer = new ArrayList<>();
        while (start <= end)
            answer.add(arr[start++]);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1,2,3,4,5},4,3));
        System.out.println(findClosestElements(new int[]{1,2,3,4,5},4,-1));
    }
}
