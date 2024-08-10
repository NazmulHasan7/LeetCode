// 2255. Count Prefixes of a Given String
package Easy;

public class Easy_2255_Count_Prefixes_of_a_Given_String {
    public static int countPrefixes(String[] words, String s) {
        int count = 0;
        for (String word : words)
            if (s.startsWith(word))
                count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countPrefixes(new String[] {"a","b","c","ab","bc","abc"}, "abc"));
        System.out.println(countPrefixes(new String[] {"a", "a"}, "aa"));
    }
}
