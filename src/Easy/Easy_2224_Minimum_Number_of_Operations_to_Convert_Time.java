// 2224. Minimum Number of Operations to Convert Time
package Easy;

public class Easy_2224_Minimum_Number_of_Operations_to_Convert_Time {
    public static int convertTime(String current, String correct) {
        int currentInMinutes = ((current.charAt(0)-'0')*10 + (current.charAt(1)-'0')) * 60
                + ((current.charAt(3)-'0')*10 + (current.charAt(4)-'0'));

        int correctInMinutes = ((correct.charAt(0)-'0')*10 + (correct.charAt(1)-'0')) * 60
                + ((correct.charAt(3)-'0')*10 + (correct.charAt(4)-'0'));

        int ops = 0, value;
        int diff = correctInMinutes - currentInMinutes;

        if (diff >= 60) {
            ops += value = diff / 60;
            diff -= value * 60;
        }
        if (diff >= 15) {
            ops += value = diff / 15;
            diff -= value * 15;
        }
        if (diff >= 5) {
            ops += value = diff / 5;
            diff -= value * 5;
        }
        ops += diff;
        return ops;
    }
    public static void main(String[] args) {
        System.out.println(convertTime("02:30", "04:35"));
        System.out.println(convertTime("11:00", "11:01"));
        System.out.println(convertTime("00:00", "23:59"));
    }
}
