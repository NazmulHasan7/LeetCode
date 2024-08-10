// 1996. The Number of Weak Characters in the Game
package Medium;
import java.util.Arrays;
import java.util.Comparator;

public class Medium_1996_The_Number_of_Weak_Characters_in_the_Game {
    public static int numberOfWeakCharacters(int[][] properties) {
        // Sort the properties based on attack first, then on defense
        Arrays.sort(properties, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) // [10,9] [10,7], [10,4]
                    return o2[1] - o1[1];
                return o1[0] - o2[0]; // [4,3] [8,8] [10,5]
            }
        });
        int count = 0;
        int maxDefense = Integer.MIN_VALUE;
        for (int i=properties.length-1; i>=0; i--) {
            if (properties[i][1] < maxDefense)
                count++;
            else maxDefense = properties[i][1];
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(numberOfWeakCharacters(new int[][] {{5,5},{6,3},{3,6}}));
        System.out.println(numberOfWeakCharacters(new int[][] {{2,2},{3,3}}));
        System.out.println(numberOfWeakCharacters(new int[][] {{1,5},{10,4},{4,3}}));
    }
}
