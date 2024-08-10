// 1710. Maximum Units on a Truck
package Easy;
import java.util.Arrays;
import java.util.Comparator;

public class Easy_1710_Maximum_Units_on_a_Truck {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int units = 0, maxBox;
        Arrays.sort(boxTypes, Comparator.comparingInt(a -> a[1]));
        for (int i=boxTypes.length-1; i>=0 && truckSize>0; i--) {
            maxBox = Math.min(truckSize, boxTypes[i][0]);
            units += maxBox * boxTypes[i][1];
            truckSize -= maxBox;
        }
        return units;
    }
    // Frequency Array
    public static int maximumUnitsBetter(int[][] boxTypes, int truckSize) {
        int units = 0, maxBox;
        int[] arr = new int[1001];
        for (int i=0; i<boxTypes.length; i++)
            arr[boxTypes[i][1]] += boxTypes[i][0];

        for (int i=1000; i>0 && truckSize > 0; i--) {
            if (arr[i] > 0) {
                maxBox = Math.min(truckSize, arr[i]);
                units += maxBox * i;
                truckSize -= maxBox;
            }
        } return units;
    }
    public static void main(String[] args) {
        System.out.println(maximumUnits(new int[][] {{1,3},{2,2},{3,1}}, 4));
        System.out.println(maximumUnits(new int[][] {{5,10},{2,5},{4,7}, {3,9}}, 10));
        System.out.println(maximumUnitsBetter(new int[][] {{1,3},{2,2},{3,1}}, 4));
        System.out.println(maximumUnitsBetter(new int[][] {{5,10},{2,5},{4,7}, {3,9}}, 10));
    }
}
