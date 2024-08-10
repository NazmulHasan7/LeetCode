// 2325. Decode the Message
package Easy;
import java.util.Arrays;
import java.util.HashMap;

public class Easy_2325_Decode_the_Message {
    public static String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap<>();
        char c, value = 'a';
        for (int i=0; i<key.length(); i++) {
            c = key.charAt(i);
            if (c != ' ' && !map.containsKey(c))
                map.put(key.charAt(i), value++);
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : message.toCharArray()) {
            if (ch == ' ') sb.append(ch);
            else sb.append(map.get(ch));
        } return sb.toString();
    }
    public static String decodeMessageBetter(String key, String message) {
        char[] freq = new char[26];
        Arrays.fill(freq, ' ');
        char index = 'a';
        for (char c : key.toCharArray())
            if (c != ' ' && freq[c-'a'] == ' ')
                freq[c-'a'] = index++;
        StringBuilder sb = new StringBuilder();
        for (char ch : message.toCharArray()) {
            if (ch == ' ') sb.append(ch);
            else sb.append(freq[ch-'a']);
        } return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(decodeMessageBetter("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
        System.out.println(decodeMessageBetter("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
        System.out.println(decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
        System.out.println(decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
    }
}
