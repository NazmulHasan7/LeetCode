// 2769. Find the Maximum Achievable Number
package Easy;

public class Easy_2769_Find_the_Maximum_Achievable_Number {
    public static int theMaximumAchievableX(int num, int t) {
        // Equation --> num + t = x - t => x = num + t + t
        return num + t + t;
    }
    public static void main(String[] args) {
        System.out.println(theMaximumAchievableX(4, 1));
        System.out.println(theMaximumAchievableX(3, 2));
    }
}
