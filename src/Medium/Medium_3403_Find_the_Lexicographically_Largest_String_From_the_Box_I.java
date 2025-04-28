// 3403. Find the Lexicographically Largest String From the Box I
package Medium;

public class Medium_3403_Find_the_Lexicographically_Largest_String_From_the_Box_I {
    public static String answerString(String word, int numFriends) {
        int n = word.length();
        if (numFriends == 1) return word;

        int maxLen = n-numFriends+1;
        char currentMax = word.charAt(0);
        String answer = "";

        for (int i=0; i<n; i++) {
            char c = word.charAt(i);
            if (c >= currentMax) {
                String subStr = word.substring(i, Math.min(n, i+maxLen));
                if (subStr.compareTo(answer) > 0)
                    answer = subStr;
                currentMax = c;
            }
        } return answer;
    }
     public static void main(String[] args) {
         System.out.println(answerString("dbca", 2));
         System.out.println(answerString("gggg", 4));
     }
}
