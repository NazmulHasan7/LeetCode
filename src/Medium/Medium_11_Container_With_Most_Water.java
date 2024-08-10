// 11. Container With Most Water
package Medium;

public class Medium_11_Container_With_Most_Water {
    public static int maxArea(int[] height) {
        int start = 0, end = height.length-1;
        int maxArea = 0, area;
        while (start <= end) {
            area = Math.min(height[start], height[end]) * (end - start);
            if (height[start] <= height[end])
                start++;
            else end--;
            maxArea = Math.max(maxArea, area);
        } return maxArea;
    }
    public static int maxAreaBetter(int[] height) {
        int start = 0, end = height.length-1;
        int maxArea = 0, area, minHeight;
        while (start < end) {
            minHeight = Math.min(height[start], height[end]);
            area = minHeight * (end - start);
            maxArea = Math.max(maxArea, area);

            while (height[start]<=minHeight && start<end)
                start++;
            while(height[end]<=minHeight && start<end)
                end--;
        } return maxArea;
    }
    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[] {1,1}));
        System.out.println(maxAreaBetter(new int[] {1,8,6,2,5,4,8,3,7}));
        System.out.println(maxAreaBetter(new int[] {1,1}));
    }
}
