// 1859. Sorting the Sentence
package Easy;

public class Easy_1859_Sorting_the_Sentence {
    public static String sortSentence(String s) {
        String[] sArr = s.split(" ");
        String[] sorted = new String[sArr.length];
        for (String str : sArr)
            sorted[str.charAt(str.length()-1)-'0'-1] = str.substring(0, str.length()-1);
        return String.join(" ", sorted);
    }
    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
        System.out.println(sortSentence("Myself2 Me1 I4 and3"));
    }
}
