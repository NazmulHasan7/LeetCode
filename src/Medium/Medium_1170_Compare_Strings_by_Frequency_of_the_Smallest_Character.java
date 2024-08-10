// 1170. Compare Strings by Frequency of the Smallest Character
package Medium;
import java.util.Arrays;

public class Medium_1170_Compare_Strings_by_Frequency_of_the_Smallest_Character {
    private static int f(String str) {
        int[] freq = new int[26];
        for (char c : str.toCharArray())
            freq[c-'a']++;
        for (int i=0; i<26; i++)
            if (freq[i] != 0) return freq[i];
        return 0;
    }
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordFreqArr = new int[words.length];
        for (int i=0; i<words.length; i++)
            wordFreqArr[i] = f(words[i]);
        Arrays.sort(wordFreqArr);

        int[] answer = new int[queries.length];
        int idx = 0;
        for (String query : queries) {
            int start = 0, end = words.length-1;
            while (start <= end) {
                int mid = (start+end) / 2;
                if (wordFreqArr[mid] <= f(query))
                    start = mid + 1;
                else end = mid - 1;
            }
            // wordFreqArr[start:] > f(query)
            answer[idx++] = wordFreqArr.length - start;
        } return answer;
    }
    public int[] numSmallerByFrequencyBetter(String[] queries, String[] words) {
        int[] wordFrequencies = new int[words.length];
        for (int i=0; i<words.length; i++)
            wordFrequencies[i] = f(words[i]);
        Arrays.sort(wordFrequencies);

        int[] answer = new int[queries.length];
        for (int i=0; i<queries.length; i++)
            answer[i] = getCount(wordFrequencies, f(queries[i]));
        return answer;
    }
    private int getCount(int[] sortedFrequencies, int value) {
        int start = 0, end = sortedFrequencies.length;
        while (start < end) {
            int mid = (start+end) / 2;
            if (sortedFrequencies[mid] <= value)
                start = mid + 1;
            else end = mid;
        }
        return sortedFrequencies.length - start;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numSmallerByFrequency(
                new String[]{"cbd"}, new String[]{"zaaaz"} )));
        System.out.println(Arrays.toString(numSmallerByFrequency(
                new String[]{"bbb","cc"}, new String[]{"a","aa","aaa","aaaa"} )));
    }
}
