// 42. Trapping Rain Water
package Hard;

public class Hard_42_Trapping_Rain_Water {
    public static int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        // System.out.println(Arrays.toString(height));

        // Finding the max height in the left
        for (int i=1; i<height.length; i++)
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        // System.out.println(Arrays.toString(maxLeft));

        // Finding the max height in the right
        for (int i=height.length-2; i>=0; i--)
            maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
        // System.out.println(Arrays.toString(maxRight));

        int waterAmount = 0, amount;
        for (int i=0; i<height.length; i++) {
            // At Index 2 -> max left 1, max right 3, height 0 => 1
            amount = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (amount > 0)
                waterAmount += amount;
        } return waterAmount;
    }
    // https://www.youtube.com/watch?v=4Y7irecfvLM - (6-8) min
    // Whenever we have a left and right bound we can trap the water at that point
    public static int trapBetter(int[] height) {
        int left = 0, right = height.length-1;
        int maxInLeft = height[left];
        int maxInRight = height[right];

        int waterAmount = 0;
        while (left < right) {
            if (maxInLeft <= maxInRight) {
                waterAmount += maxInLeft - height[left];
                left++;
                maxInLeft = Math.max(maxInLeft, height[left]);
            } else {
                waterAmount += maxInRight - height[right];
                right--;
                maxInRight = Math.max(maxInRight, height[right]);
            }
        } return waterAmount;
    }
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trapBetter(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
