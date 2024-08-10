// 819. Most Common Word
package Easy;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Easy_819_Most_Common_Word {
    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, banned);

        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder wordBuffer = new StringBuilder();
        String result = "", tempStr;
        int maxCount = 0, freqCount;
        for (char c : paragraph.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                if (Character.isUpperCase(c))
                    wordBuffer.append((char)(c+32));
                else wordBuffer.append(c);
            }
            else if (!wordBuffer.isEmpty()){
                tempStr = wordBuffer.toString();
                if (!set.contains(tempStr)) {
                    freqCount = map.getOrDefault(tempStr, 0) + 1;
                    if (freqCount > maxCount) {
                        maxCount = freqCount;
                        result = tempStr;
                    } map.put(tempStr, freqCount);
                } wordBuffer.setLength(0);
            }
        }
        if (!wordBuffer.isEmpty()) {
            tempStr = wordBuffer.toString();
            if (!set.contains(tempStr) && map.getOrDefault(tempStr, 0)+1 > maxCount)
                return tempStr;
        } return result;
    }
    public static void main(String[] args) {
        System.out.println(mostCommonWord(
                "Bob hit a ball, the hit BALL flew far after it was hit", new String[] {"hit"}));
        System.out.println(mostCommonWord("a", new String[] {}));
    }
}
