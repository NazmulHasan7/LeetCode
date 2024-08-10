// 2129. Capitalize the Title
package Easy;

public class Easy_2129_Capitalize_the_Title {
    public static String capitalizeTitle(String title) {
        char[] cArr = title.toCharArray();
        int firstIndex, wordLength;
        for (int i=0; i<cArr.length; i++) {
            firstIndex = i;
            wordLength = 0;
            while (i < cArr.length && cArr[i] != ' ') {
                cArr[i] = Character.toLowerCase(cArr[i]);
                i++;
                wordLength++;
            } if (wordLength > 2)
                cArr[firstIndex] = Character.toUpperCase(cArr[firstIndex]);
        } return String.valueOf(cArr);
    }
    public static void main(String[] args) {
        System.out.println(capitalizeTitle("capiTalIze tHe titLe"));
        System.out.println(capitalizeTitle("First leTTeR of EACH Word"));
        System.out.println(capitalizeTitle("i lOve leetcode"));
    }
}
