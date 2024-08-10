// 2506. Count Pairs Of Similar Strings
package Easy;
import java.util.Arrays;

public class Easy_2506_Count_Pairs_Of_Similar_Strings {
    public static int similarPairs(String[] words) {
        int count = 0, length = words.length;
        int[][] freq = new int[length][26];
        for (int i=0; i<length; i++)
            for (char c : words[i].toCharArray())
                freq[i][c-'a'] = 1;
        for (int i=0; i<length; i++)
            for (int j=i+1; j<length; j++)
                if (Arrays.equals(freq[i], freq[j]))
                    count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(similarPairs(new String[] {"aba","aabb","abcd","bac","aabc"}));
        System.out.println(similarPairs(new String[] {"aabb","ab","ba"}));
        System.out.println(similarPairs(new String[] {"nba","cba","dba"}));
    }
}
