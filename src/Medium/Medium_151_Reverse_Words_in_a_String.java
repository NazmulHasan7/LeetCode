// 151. Reverse Words in a String
package Medium;

public class Medium_151_Reverse_Words_in_a_String {
    public static String reverseWords(String s) {
        StringBuilder answer = new StringBuilder();
        String[] srr = s.strip().split(" ");

        for (int i=srr.length-1; i>=1; i--) {
            if (!srr[i].isEmpty()) answer.append(srr[i]).append(" ");
        } return answer.append(srr[0]).toString();
    }
    public static String reverseWordsBetter(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) == ' ') continue;
            int end = i;

            while (i >= 0 && s.charAt(i) != ' ') i--;
            sb.append(s, i+1, end+1).append(' ');
        } return sb.toString().strip();
    }
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));
    }
}
