// 2284. Sender With Largest Word Count
package Medium;
import java.util.HashMap;
import java.util.Map;

public class Medium_2284_Sender_With_Largest_Word_Count {
    public static String largestWordCount(String[] messages, String[] senders) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i=0; i<senders.length; i++)
            map.put(senders[i], map.getOrDefault(senders[i], 0) + messages[i].split(" ").length);

        String answer = senders[0];
        int highest = 0;
        for (String key : map.keySet()) {
            int count = map.get(key);
            if (count > highest) {
                highest = map.get(key);
                answer = key;
            } else if (count == highest) {
                answer = answer.compareTo(key) > 0 ? answer : key;
            }
        } return answer;
    }
    public String largestWordCountBetter(String[] messages, String[] senders) {
        Map<String, Integer> wordCount = new HashMap<>();

        int highest = 0;
        String answer = senders[0];
        for(int i=0; i<messages.length; i++) {
            int curCount = wordCount.getOrDefault(senders[i], 0);

            for (char c : messages[i].toCharArray())
                if (c == ' ') curCount++;

            curCount ++;
            wordCount.put(senders[i], curCount);
            if(curCount > highest) {
                answer = senders[i];
                highest = curCount;
            } else if(curCount == highest && senders[i].compareTo(answer) >= 1) {
                answer = senders[i];
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(largestWordCount(new String[]{"Hello userTwooo","Hi userThree","Wonderful day Alice","Nice day userThree"},
                new String[]{"Alice","userTwo","userThree","Alice"}));
        System.out.println(largestWordCount(new String[]{"How is leetcode for everyone","Leetcode is useful for practice"},
                new String[]{"Bob","Charlie"}));
    }
}
