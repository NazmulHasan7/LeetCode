// 875. Koko Eating Bananas
package Medium;

public class Medium_875_Koko_Eating_Bananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        // int end = Arrays.stream(piles).max().getAsInt();
        int end = -1;
        for (int pile : piles)
            end = Math.max(end, pile);
        int minSpeed = end;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            long hours = 0;
            for (int pile : piles)
                // hours += Math.ceilDiv(pile, mid);
                hours += (pile + mid - 1) / mid;

            if (hours <= h) {
                minSpeed = mid;
                end = mid - 1;
            } else start = mid + 1;
        } return minSpeed;
    }
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3,6,7,11},8));
        System.out.println(minEatingSpeed(new int[]{30,11,23,4,20},5));
        System.out.println(minEatingSpeed(new int[]{30,11,23,4,20},6));
        System.out.println(minEatingSpeed(new int[]{805306368,805306368,805306368},1000000000));
    }
}
