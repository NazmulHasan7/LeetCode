// 1880. Check if Word Equals Summation of Two Words
package Easy;

public class Easy_1880_Check_if_Word_Equals_Summation_of_Two_Words {
    public static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int num1 = 0, num2 = 0, num3 = 0;
        for (int i=0; i<firstWord.length(); i++)
            num1 = num1 * 10 + firstWord.charAt(i)-'a';
        for (int i=0; i<secondWord.length(); i++)
            num2 = num2 * 10 + secondWord.charAt(i)-'a';
        for (int i=0; i<targetWord.length(); i++)
            num3 = num3 * 10 + targetWord.charAt(i)-'a';
        return num3 == num1 + num2;
    }
    public static void main(String[] args) {
        System.out.println(isSumEqual("acb", "cba", "cdb"));
        System.out.println(isSumEqual("aaa", "a", "aab"));
        System.out.println(isSumEqual("aaa", "a", "aaaa"));
    }
}
