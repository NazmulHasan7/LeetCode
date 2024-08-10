// 1385. Find the Distance Value Between Two Arrays
package Easy;

public class Easy_1385_Find_the_Distance_Value_Between_Two_Arrays {
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int a1 : arr1) {
            for (int a2 : arr2) {
                if (Math.abs(a1 - a2) <= d) {
                    count++;
                    break;
                }
            }
        } return arr1.length - count;
    }
    public static void main(String[] args) {
        System.out.println(findTheDistanceValue(new int[]{4,5,8}, new int[]{10,9,1,8}, 2));
    }
}
