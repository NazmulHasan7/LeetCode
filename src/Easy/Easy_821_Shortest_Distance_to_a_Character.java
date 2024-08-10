// 821. Shortest Distance to a Character
package Easy;
import java.util.Arrays;

public class Easy_821_Shortest_Distance_to_a_Character {
    public static int[] shortestToChar(String s, char c) {
        int length = s.length();
        int[] distance = new int[length];
        // Forward distance - Considering c is at the last index
        int prevOcc = length;
        for (int i=0; i<length; i++) {
            if (s.charAt(i) == c)
                distance[i] = prevOcc = 0;
            else distance[i] = Math.abs(--prevOcc);
        }
        // Reverse distance - Considering c is at the first index
        prevOcc = length;
        for (int i=length-1; i>=0; i--) {
            if (s.charAt(i) == c)
                prevOcc = 0;
            else distance[i] = Math.min(distance[i], ++prevOcc);
        }
        return distance;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e')));
        System.out.println(Arrays.toString(shortestToChar("aaab", 'b')));
        System.out.println(Arrays.toString(shortestToChar("abaa", 'b')));
    }
}
