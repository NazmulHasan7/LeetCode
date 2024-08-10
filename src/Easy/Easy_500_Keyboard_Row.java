// 500. Keyboard Row
package Easy;
import java.util.ArrayList;
import java.util.Arrays;

public class Easy_500_Keyboard_Row {
    public static String[] findWords(String[] words) {
        String[] keyRow = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        ArrayList<String> list = new ArrayList<>();
        int rowIndex;
        String temp;
        for (String word : words) {
            temp = word.toLowerCase();
            if (keyRow[0].indexOf(temp.charAt(0)) != -1)
                rowIndex = 0;
            else if (keyRow[1].indexOf(temp.charAt(0)) != -1)
                rowIndex = 1;
            else rowIndex = 2;
            int j;
            for (j = 1; j < temp.length(); j++)
                if (keyRow[rowIndex].indexOf(temp.charAt(j)) == -1)
                    break;
            if (j == temp.length())
                list.add(word);
        }
        String[] result = new String[list.size()];
        for (int i=0; i<list.size(); i++)
            result[i] = list.get(i);
        return result;
    }
    public static String[] findWordsBetter(String[] words) {
        String[] keyRow = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        int[][] freq = new int[3][26];
        for (char c : keyRow[0].toCharArray())
            freq[0][c-'a'] = 1;
        for (char c : keyRow[1].toCharArray())
            freq[1][c-'a'] = 1;
        for (char c : keyRow[2].toCharArray())
            freq[2][c-'a'] = 1;

        int index;
        String temp;
        char x;
        ArrayList<String> list = new ArrayList<>();
        for (String word : words) {
            temp = word.toLowerCase();
            x = temp.charAt(0);
            if (freq[0][x-'a'] == 1) index = 0;
            else if (freq[1][x-'a'] == 1) index = 1;
            else index = 2;

            int j;
            for (j=1; j<temp.length(); j++)
                if (freq[index][temp.charAt(j)-'a'] == 0)
                    break;
            if (j == temp.length()) list.add(word);
        }
        String[] result = new String[list.size()];
        for (int i=0; i<list.size(); i++)
            result[i] = list.get(i);
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findWordsBetter(new String[] {"Hello","Alaska","Dad","Peace"})));
        System.out.println(Arrays.toString(findWordsBetter(new String[] {"omk"})));
        System.out.println(Arrays.toString(findWordsBetter(new String[] {"adsdf", "sfd"})));
    }
}
