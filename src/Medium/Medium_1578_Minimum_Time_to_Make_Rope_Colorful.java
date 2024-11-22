// 1578. Minimum Time to Make Rope Colorful
package Medium;

public class Medium_1578_Minimum_Time_to_Make_Rope_Colorful {
    public static int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int time = 0;

        char prev = colors.charAt(0);
        for (int i=1; i<n; i++) {
            char curr = colors.charAt(i);
            if (curr == prev) {
                // if the characters are same -> chose the one who has the minimum removal time
                if (neededTime[i-1] <= neededTime[i]) {
                    time += neededTime[i-1];
                    neededTime[i-1] = 0;
                } else {
                    time += neededTime[i];
                    neededTime[i] = neededTime[i-1];
                }
            }
            prev = curr;
        }
        return time;
    }
    public static void main(String[] args) {
        System.out.println(minCost("abaac", new int[]{1,2,3,4,5}));
        System.out.println(minCost("abc", new int[]{1,2,3}));
        System.out.println(minCost("aabaa", new int[]{1,2,3,4,1}));
    }
}