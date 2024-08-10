// 804. Unique Morse Code Words
package Easy;
import java.util.HashMap;
import java.util.HashSet;

public class Easy_804_Unique_Morse_Code_Words {
    public static int uniqueMorseRepresentations(String[] words) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('a',   ".-");
        map.put('b', "-...");
        map.put('c', "-.-.");
        map.put('d',  "-..");
        map.put('e',    ".");
        map.put('f', "..-.");
        map.put('g',  "--.");
        map.put('h', "....");
        map.put('i',   "..");
        map.put('j', ".---");
        map.put('k',  "-.-");
        map.put('l', ".-..");
        map.put('m',   "--");
        map.put('n',   "-.");
        map.put('o',  "---");
        map.put('p', ".--.");
        map.put('q', "--.-");
        map.put('r',  ".-.");
        map.put('s',  "...");
        map.put('t',    "-");
        map.put('u',  "..-");
        map.put('v', "...-");
        map.put('w',  ".--");
        map.put('x', "-..-");
        map.put('y', "-.--");
        map.put('z', "--..");

        HashSet<String> set = new HashSet<>();
        String decoded;
        for (String word: words) {
            decoded = "";
            for (char c: word.toCharArray())
                decoded += map.get(c);
            set.add(decoded);
        }
        return set.size();
    }
    public static int uniqueMorseRepresentationsBetter(String[] words) {
        String[] code = {
                ".-","-...","-.-.","-..",".","..-.","--.","....",
                "..",".---","-.-",".-..","--","-.","---",".--.","--.-",
                ".-.", "...","-","..-","...-",".--","-..-","-.--","--.."
        };
        HashSet<String> set = new HashSet<>();
        for (String word: words) {
            StringBuilder sb = new StringBuilder();
            for (char c: word.toCharArray())
                sb.append(code[c - 'a']);
            set.add(sb.toString());
        }
        return set.size();
    }
    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[]{"gin","zen","gig","msg"}));
        System.out.println(uniqueMorseRepresentations(new String[]{"a"}));
        System.out.println(uniqueMorseRepresentationsBetter(new String[]{"gin","zen","gig","msg"}));
        System.out.println(uniqueMorseRepresentationsBetter(new String[]{"a"}));
    }
}
