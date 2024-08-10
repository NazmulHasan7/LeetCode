// 1103. Distribute Candies to People
package Easy;
import java.util.Arrays;

public class Easy_1103_Distribute_Candies_to_People {
    public static int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int count = 1;
        while (candies != 0) {
            for (int i=0; i<num_people; i++) {
                if (count >= candies) {
                    result[i] += candies;
                    candies = 0;
                    break;
                } else {
                    result[i] += count;
                    candies -= count;
                    count++;
                }
            }
        } return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(7,4)));
        System.out.println(Arrays.toString(distributeCandies(10,3)));
    }
}
