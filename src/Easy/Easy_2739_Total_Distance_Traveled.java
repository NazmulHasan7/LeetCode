// 2739. Total Distance Traveled
package Easy;

public class Easy_2739_Total_Distance_Traveled {
    public static int distanceTraveled(int mainTank, int additionalTank) {
        int distance = 0;
        while (mainTank > 0) {
            if (mainTank < 5)
                return distance + mainTank * 10;
            else {
                distance += 50;
                if (additionalTank >= 1) {
                    mainTank -= 4;
                    additionalTank--;
                } else mainTank -= 5;
            }
        } return distance;
    }
    public static void main(String[] args) {
        System.out.println(distanceTraveled(5, 10));
        System.out.println(distanceTraveled(1, 2));
    }
}
