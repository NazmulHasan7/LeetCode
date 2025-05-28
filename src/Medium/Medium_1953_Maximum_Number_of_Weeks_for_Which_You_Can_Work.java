// 1953. Maximum Number of Weeks for Which You Can Work
package Medium;

public class Medium_1953_Maximum_Number_of_Weeks_for_Which_You_Can_Work {
    public static long numberOfWeeks(int[] milestones) {
        long totalMileStone = 0;
        int maxMileStone = 0;

        // the idea is to interleave the most demanding project with all others

        for (int m : milestones) {
            maxMileStone = Math.max(maxMileStone, m);
            totalMileStone += m;
        }

        long restOfMilestone = totalMileStone - maxMileStone;
        if (maxMileStone > restOfMilestone)
            return restOfMilestone * 2 + 1; // +1 for 1 extra week for the max milestone project

        return totalMileStone; // all projects can be completed
    }
    public static void main(String[] args) {
        System.out.println(numberOfWeeks(new int[]{1,2,3}));
        System.out.println(numberOfWeeks(new int[]{5,2,1}));
    }
}
