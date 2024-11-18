// 763. Partition Labels
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_763_Partition_Labels {
    public static List<Integer> partitionLabels(String s) {
        // keep track of the last occurrence of each character
        int[] lastOccurrence = new int[26];
        int n = s.length();
        for (int i=0; i<n; i++)
            lastOccurrence[s.charAt(i)-'a'] = i;

        List<Integer> answer = new ArrayList<>();
        int size = 0, end = 0;

        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            size++;
            if (lastOccurrence[c-'a'] > end)
                end = lastOccurrence[c-'a'];

            if (i == end) {
                answer.add(size);
                size = 0;
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels("eccbbbbdec"));
    }
}
