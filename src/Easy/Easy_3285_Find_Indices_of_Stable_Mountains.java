// 3285. Find Indices of Stable Mountains
package Easy;
import java.util.ArrayList;
import java.util.List;

public class Easy_3285_Find_Indices_of_Stable_Mountains {
    public static List<Integer> stableMountains(int[] height, int threshold) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i=1; i<height.length; i++)
            if (height[i-1] > threshold)
                answer.add(i);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(stableMountains(new int[]{1,2,3,4,5},2));
        System.out.println(stableMountains(new int[]{10,1,10,1,10},3));
        System.out.println(stableMountains(new int[]{10,1,10,1,10},10));
    }
}
