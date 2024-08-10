// 1431. Kids With the Greatest Number of Candies
package Easy;
import java.util.ArrayList;
import java.util.List;

public class Easy_1431_Kids_With_the_Greatest_Number_of_Candies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> status = new ArrayList<>();
        int maxCandies = candies[0];
        for (int i=1; i<candies.length; i++)
            if (candies[i] > maxCandies) maxCandies = candies[i];

        for (int i=0; i<candies.length; i++)
            status.add(candies[i] + extraCandies >= maxCandies);
        return status;
    }
    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[] {2,3,5,1,3}, 3));
        System.out.println(kidsWithCandies(new int[] {4,2,1,1,2}, 1));
        System.out.println(kidsWithCandies(new int[] {12,1,12}, 10));
    }
}
