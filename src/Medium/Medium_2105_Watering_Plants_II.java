// 2105. Watering Plants II
package Medium;

public class Medium_2105_Watering_Plants_II {
    public static int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int count = 0, capA = capacityA, capB = capacityB;
        int ptrA = 0, ptrB = plants.length-1;

        while (ptrA <= ptrB) {
            if (ptrA == ptrB) {
                if (capA >= capB) {
                    if (plants[ptrA] > capA) count++;
                    else return count;
                } else if (plants[ptrB] > capB) count++;
                // No more plants left to be watered
                return count;
            }
            if (plants[ptrA] > capA) {
                capA = capacityA;
                count++;
            } capA -= plants[ptrA++];

            if (plants[ptrB] > capB) {
                capB = capacityB;
                count++;
            } capB -= plants[ptrB--];
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(minimumRefill(new int[]{2,2,3,3},5,5));
        System.out.println(minimumRefill(new int[]{2,2,3,3},3,4));
        System.out.println(minimumRefill(new int[]{5},10,8));
        System.out.println(minimumRefill(new int[]{2,3,3},5,5));
    }
}
