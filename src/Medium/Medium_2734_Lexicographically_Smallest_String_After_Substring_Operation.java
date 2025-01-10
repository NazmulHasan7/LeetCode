// 2734. Lexicographically Smallest String After Substring Operation
package Medium;

public class Medium_2734_Lexicographically_Smallest_String_After_Substring_Operation {
    public static String smallestString(String s) {
        int n = s.length();
        char[] answer = s.toCharArray();

        int idx = 0;
        while (idx < n && answer[idx] == 'a')
            idx++;

        if (idx == n) {
            answer[n-1] = 'z';
        } else {
            while (idx < n && answer[idx] != 'a') {
                answer[idx]--;
                idx++;
            }
        } return new String(answer);
    }
    public static void main(String[] args) {
        System.out.println(smallestString("cbabc"));
        System.out.println(smallestString("aa"));
        System.out.println(smallestString("acbbc"));
    }
}
