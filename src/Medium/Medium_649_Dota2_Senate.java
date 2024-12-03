// 649. Dota2 Senate
package Medium;
import java.util.LinkedList;
import java.util.Queue;

public class Medium_649_Dota2_Senate {
    public static String predictPartyVictory(String senate) {
        int radiant = 0, dire = 0, banRCount = 0, banDCount = 0;
        Queue<Character> senateQueue = new LinkedList<>();

        for (char c : senate.toCharArray()) {
            senateQueue.add(c);
            if (c == 'R') radiant++;
            else dire++;
        }

        while (radiant > 0 && dire > 0) {
            char currSenator = senateQueue.poll();
            if (currSenator == 'R') {
                if (banRCount == 0) {
                    banDCount++;
                    senateQueue.add(currSenator);
                } else {
                    banRCount--;
                    radiant--;
                }
            } else {
                if (banDCount == 0) {
                    senateQueue.add(currSenator);
                    banRCount++;
                } else {
                    banDCount--;
                    dire--;
                }
            }
        }
        if (dire > 0) return "Dire";
        return "Radiant";
    }
    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RD"));
        System.out.println(predictPartyVictory("RDD"));
    }
}
