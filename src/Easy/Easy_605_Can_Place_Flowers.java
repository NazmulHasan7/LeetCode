// 605. Can Place Flowers
package Easy;

public class Easy_605_Can_Place_Flowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int prev, next;
        int length = flowerbed.length;
        for (int i=0; i<length && n>0; i++) {
            if (flowerbed[i] == 1)
                continue;
            // For 3 consecutive 0's a flower can be placed
            prev = (i > 0) ? flowerbed[i-1] : 0;
            next = (i < length-1) ? flowerbed[i+1] : 0;
            if (prev == 0 && next == 0) {
                flowerbed[i] = 1;
                n--;
            }
        } return n == 0;
    }
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[] {1,0,0,0,1}, 1));
        System.out.println(canPlaceFlowers(new int[] {1,0,0,0,1}, 2));
        System.out.println(canPlaceFlowers(new int[] {1,0,0,0,0,1}, 2));
    }
}
