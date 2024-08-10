// 809. Expressive Words
package Medium;

public class Medium_809_Expressive_Words {
    public static boolean isStretchy(char[] str1, String word) {
        char[] str2 = word.toCharArray();
        int idx1 = 0, idx2 = 0;

        while (idx1<str1.length && idx2<str2.length) {
            if (str1[idx1] != str2[idx2]) return false;

            int c1 = 0, c2 = 0;
            char targetChar = str1[idx1];
            while (idx1 < str1.length && str1[idx1] == targetChar) {
                idx1++;
                c1++;
            }
            while (idx2 < str2.length && str2[idx2] == targetChar) {
                idx2++;
                c2++;
            }
            // c2 > c1 -> "hheello", c1 < 3 -> "heelo"
            if (c1 != c2 && (c1 < 3 || c2 > c1)) return false;
        } return idx1 == str1.length && idx2 == str2.length;
    }
    public static int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String word : words)
            if (isStretchy(s.toCharArray(), word)) count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(expressiveWords("heeellooo", new String[]{"hello", "hi", "helo", "heelo", "hheello"}));
        System.out.println(expressiveWords("zzzzzyyyyy", new String[]{"zzyy","zy","zyy"}));
    }
}
