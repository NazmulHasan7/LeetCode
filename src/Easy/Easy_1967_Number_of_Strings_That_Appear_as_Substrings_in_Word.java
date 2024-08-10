// 1967. Number of Strings That Appear as Substrings in Word
package Easy;

public class Easy_1967_Number_of_Strings_That_Appear_as_Substrings_in_Word {
    public static int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String pattern : patterns)
            if (word.contains(pattern))
                count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(numOfStrings(new String[] {"a","abc","bc","d"}, "abc"));
        System.out.println(numOfStrings(new String[] {"a", "b", "c"}, "aaaaabbbbb"));
        System.out.println(numOfStrings(new String[] {"a", "a", "a"}, "ab"));
    }
}
