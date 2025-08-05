// 3477. Fruits Into Baskets II
package Easy;

public class Easy_3477_Fruits_Into_Baskets_II {
    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int unplaced = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (fruits[i] <= baskets[j]) {
                    baskets[j] = 0;
                    break;
                }
            }
        }
        for (int basket : baskets)
            if (basket != 0) unplaced++;
        return unplaced;
    }
    public static void main(String[] args) {
        System.out.println(numOfUnplacedFruits(new int[]{4,2,5}, new int[]{3,5,4}));
        System.out.println(numOfUnplacedFruits(new int[]{3,6,1}, new int[]{6,4,7}));
    }
}
