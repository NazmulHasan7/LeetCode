// 2300. Successful Pairs of Spells and Potions
package Medium;
import java.util.Arrays;

public class Medium_2300_Successful_Pairs_of_Spells_and_Potions {
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int pn = potions.length;
        int[] answer = new int[spells.length];
        Arrays.sort(potions);

        for (int i=0; i<spells.length; i++) {
            // Binary Search
            int start = 0, end = pn-1;
            while (start <= end) {
                int mid = (start+end) / 2;
                if ((long) spells[i] * potions[mid] >= success)
                    end = mid - 1;
                else
                    start = mid + 1;
            } answer[i] = pn - start;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(successfulPairs(new int[]{5,1,3}, new int[]{1,2,3,4,5}, 7)));
        System.out.println(Arrays.toString(successfulPairs(new int[]{3,1,2}, new int[]{8,5,8}, 16)));
    }
}
