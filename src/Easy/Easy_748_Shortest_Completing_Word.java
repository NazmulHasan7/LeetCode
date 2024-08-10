// 748. Shortest Completing Word
package Easy;

public class Easy_748_Shortest_Completing_Word {
    public static boolean check(String word, int[] freq) {
        int[] wordFreq = new int[26];
        for (char c : word.toCharArray())
            wordFreq[c-'a']++;

        for (int i=0; i<26; i++)
            if(freq[i] > wordFreq[i])
                return false;
        return true;
    }
    public static String shortestCompletingWordBetter(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        int[] freq = new int[26];
        for (char c : licensePlate.toCharArray())
            if (c >= 'a' && c <= 'z') freq[c-'a']++;

        String result = "";
        for (String word : words)
            if (check(word, freq))
                if (result.isEmpty() || result.length() > word.length())
                    result = word;
        return result;
    }
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        String shortestWord = "";
        int shortLength = Integer.MAX_VALUE;
        int[] freq = new int[26];
        int wordLength;

        for (char c : licensePlate.toCharArray()) {
            if (c >= 'a' && c <= 'z')
                freq[c-'a']++;
            else if (c >= 'A' && c <= 'Z')
                freq[c-'A']++;
        }
        for (String word : words) {
            int[] wordFreq = new int[26];
            for (char c : word.toCharArray())
                wordFreq[c-'a']++;

            wordLength = word.length();
            if (wordLength < shortLength) {
                int x;
                for (x=0; x<26; x++)
                    if (freq[x] > wordFreq[x])
                        break;
                if (x == 26) {
                    shortestWord = word;
                    shortLength = wordLength;
                }
            }
        } return shortestWord;
    }
    public static void main(String[] args) {
        System.out.println(shortestCompletingWord("1s3 PSt", new String[] {"step","steps","stripe","stepple"}));
        System.out.println(shortestCompletingWord("1s3 456", new String[] {"looks","pest","stew","show"}));
        System.out.println(shortestCompletingWordBetter("GrC8950", new String[]
                {"measure","other","every","base","according","level","meeting","none","marriage","rest"}));
    }
}
