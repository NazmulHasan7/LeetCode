// 1344. Angle Between Hands of a Clock
package Medium;

public class Medium_1344_Angle_Between_Hands_of_a_Clock {
    public static double angleClock(int hour, int minutes) {
        /*How minute hand affects the position of hour hand
            Minute position
            360 / 60 = 6
            1 min = 6 deg

            Hour position
            360 / 12 = 30
            1 hour = 30 deg
            1 min = 30 / 60 = 0.5 deg
         */
        double hourPosition = 30 * hour + minutes * 0.5;
        double minPosition = minutes * 6;
        double angle = Math.abs(hourPosition - minPosition);
        return Math.min(angle, 360-angle);
    }
    public static void main(String[] args) {
        System.out.println(angleClock(12,30));
        System.out.println(angleClock(3,30));
        System.out.println(angleClock(3,15));
    }
}
