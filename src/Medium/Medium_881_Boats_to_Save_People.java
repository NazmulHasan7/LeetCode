// 881. Boats to Save People
package Medium;
import java.util.Arrays;

public class Medium_881_Boats_to_Save_People {
    public static int numRescueBoats(int[] people, int limit) {
        int boatCount = 0;
        Arrays.sort(people);

        int left = 0, right = people.length-1;
        while (left <= right) {
            if (people[left]+people[right] <= limit) {
                // They together fit in a boat, update the pointers
                left++; right--;
            } else {
                // They together do not fit, the heaviest between them takes a boat
                right--;
            } boatCount++;
        } return boatCount;
    }
    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[] {1,2}, 3));
        System.out.println(numRescueBoats(new int[] {3,2,2,1}, 3));
        System.out.println(numRescueBoats(new int[] {3,5,3,4}, 5));
        System.out.println(numRescueBoats(new int[] {5,1,4,2}, 6));
    }
}
