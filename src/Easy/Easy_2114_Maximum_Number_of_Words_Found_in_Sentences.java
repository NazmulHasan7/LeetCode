// 2114. Maximum Number of Words Found in Sentences
package Easy;

public class Easy_2114_Maximum_Number_of_Words_Found_in_Sentences {
    public static int mostWordsFound(String[] sentences) {
        int max = sentences[0].split(" ").length;
        int n;
        for (int i=1; i<sentences.length; i++) {
            n = sentences[i].split(" ").length;
            if (max < n) max = n;
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(mostWordsFound(new String[] {"alice and bob love leetcode",
                "i think so too", "this is great thanks very much"}));
        System.out.println(mostWordsFound(new String[] {"please wait", "continue to fight",
                "continue to win"}));
    }
}
