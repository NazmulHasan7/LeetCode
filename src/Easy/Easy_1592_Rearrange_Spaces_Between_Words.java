// 1592. Rearrange Spaces Between Words
package Easy;
import java.util.ArrayList;

public class Easy_1592_Rearrange_Spaces_Between_Words {
    public static String reorderSpaces(String text) {
        int spaceCount = 0;
        int wordCount = 0;
        for (int i=0; i<text.length(); i++)
            if (text.charAt(i) == ' ') spaceCount++;

        ArrayList<String> list = new ArrayList<>();
        String[] wordArr = text.split(" ");
        for (String word : wordArr) {
            if (!word.isEmpty()) {
                wordCount++;
                list.add(word);
            }
        } if (wordCount == 1)
            return list.get(0) + " ".repeat(spaceCount);

        int rem = spaceCount % (wordCount-1);
        spaceCount = spaceCount / (wordCount-1);
        String result = list.get(0);
        for (int i=1; i<list.size(); i++)
            result += " ".repeat(spaceCount) + list.get(i);
        return result + " ".repeat(rem);
    }

    // Far better solution
    public static String reorderSpacesBetter(String text) {
        int spaceCount = 0;
        int wordCount = 0;
        int length = text.length();
        for (int i=0; i<length; i++) {
            if (text.charAt(i) == ' ') spaceCount++;
            else {
                wordCount++;
                while (i<text.length() && text.charAt(i)!=' ')
                    i++;
                i--;
            }
        } if (spaceCount == 0) return text;
        int extraSpace = (wordCount > 1) ? spaceCount % (wordCount-1) : spaceCount;
        spaceCount = (wordCount > 1) ? spaceCount / (wordCount-1) : 0;
        int index = 0;
        StringBuilder sb = new StringBuilder();

        while (index<length) {
            while (index<length && text.charAt(index)==' ')
                index++;
            while (index<length && text.charAt(index)!=' ')
                sb.append(text.charAt(index++));
            sb.append(" ".repeat(spaceCount));
        } text = sb.toString().trim();

        if (extraSpace > 0) text = text + (" ".repeat(extraSpace));
        return text;
    }
    public static void main(String[] args) {
        System.out.println(reorderSpaces("  this   is  a sentence "));
        System.out.println(reorderSpaces("  sentence "));
        System.out.println(reorderSpacesBetter("  hello"));
    }
}
