// 3028. Ant on the Boundary
package Easy;

public class Easy_3028_Ant_on_the_Boundary {
    public static int returnToBoundaryCount(int[] nums) {
        int onBoundary = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum == 0) onBoundary++;
        } return onBoundary;
    }
    public static void main(String[] args) {
        System.out.println(returnToBoundaryCount(new int[] {2,3,-5}));
        System.out.println(returnToBoundaryCount(new int[] {3,2,-3,-4}));
    }
}
