// 1668. Maximum Repeating Substring
package Easy;

public class Easy_1668_Maximum_Repeating_Substring {
    public static int maxRepeating(String sequence, String word) {
        int count = 0;
        StringBuilder seq = new StringBuilder(word);
        while (sequence.contains(seq)) {
            seq.append(word);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(maxRepeating("ababc", "ab"));
        System.out.println(maxRepeating("ababc", "ba"));
        System.out.println(maxRepeating("ababc", "ac"));
    }
}
