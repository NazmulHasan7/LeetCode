// 1629. Slowest Key
package Easy;

public class Easy_1629_Slowest_Key {
    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        char slowKey = keysPressed.charAt(0);
        int highestDuration = releaseTimes[0];
        int difference;
        int length = keysPressed.length();
        for (int i=1; i<length; i++) {
            difference = releaseTimes[i] - releaseTimes[i-1];
            if (difference >= highestDuration) {
                if (difference == highestDuration && slowKey < keysPressed.charAt(i) || difference > highestDuration)
                    slowKey = keysPressed.charAt(i);
                highestDuration = difference;
            }
        } return slowKey;
    }
    public static void main(String[] args) {
        System.out.println(slowestKey(new int[] {9,29,49,50}, "cbcd"));
        System.out.println(slowestKey(new int[] {12,23,36,46,62}, "spuda"));
    }
}
