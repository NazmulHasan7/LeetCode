// 1255. Maximum Score Words Formed by Letters
package Hard;

public class Hard_1255_Maximum_Score_Words_Formed_by_Letters {
    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freqArr = new int[26];
        for (char c : letters) freqArr[c-'a']++;
        return backtrack(words, 0, freqArr, score);
    }
    private static int backtrack(String[] words, int idx, int[] freq, int[] score) {
        if (idx == words.length) return 0;

        // Not include the current word
        int exclude = backtrack(words, idx+1, freq, score);
        // Include the current word
        boolean canFormWord = true;
        int wordScore = 0;
        int include = 0;
        for (char c : words[idx].toCharArray()) {
            if (freq[c-'a'] == 0)
                canFormWord = false;
            wordScore += score[c-'a'];
            freq[c-'a']--;
        }
        if (canFormWord)
            include = wordScore + backtrack(words, idx + 1, freq, score);
        // Recover the frequency array
        for (char c : words[idx].toCharArray())
            freq[c-'a']++;

        return Math.max(include, exclude);
    }
    public static void main(String[] args) {
        System.out.println(maxScoreWords(new String[]{"dog","cat","dad","good"},
                new char[]{'a','a','c','d','d','d','g','o','o'},
                new int[]{1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0}));
    }
}
