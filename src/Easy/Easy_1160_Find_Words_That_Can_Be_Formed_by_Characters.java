// 1160. Find Words That Can Be Formed by Characters
package Easy;

public class Easy_1160_Find_Words_That_Can_Be_Formed_by_Characters {
    public static int countCharacters(String[] words, String chars) {
        int[] counts = new int[26];
        for(int i=0; i<chars.length(); i++)
            counts[chars.charAt(i)-'a']++;
        int length=0;
        for(String word:words)
            if(canForm(word,counts))
                length += word.length();
        return length;
    }
    private static boolean canForm(String word, int counts[]){
        int[] freq = new int[26];
        for(int i=0; i<word.length(); i++){
            int c = word.charAt(i)-'a';
            freq[c]++;
            if(freq[c] > counts[c])
                return false;
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(countCharacters(new String[] {"cat","bt","hat","tree"}, "atach"));
        System.out.println(countCharacters(new String[] {"hello","world","leetcode"}, "welldonehoneyr"));
    }
}
