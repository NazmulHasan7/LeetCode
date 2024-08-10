// 2000. Reverse Prefix of Word
package Easy;

public class Easy_2000_Reverse_Prefix_of_Word {
    public static String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) return word;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<=index; i++)
            sb.append(word.charAt(i));
        return sb.reverse() + word.substring(index+1);
    }
    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
        System.out.println(reversePrefix("xyxzxe", 'z'));
        System.out.println(reversePrefix("abcd", 'z'));
    }
}
