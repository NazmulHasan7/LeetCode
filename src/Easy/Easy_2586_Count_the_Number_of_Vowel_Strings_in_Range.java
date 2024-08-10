// 2586. Count the Number of Vowel Strings in Range
package Easy;

public class Easy_2586_Count_the_Number_of_Vowel_Strings_in_Range {
    public static int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for (int i=left; i<=right; i++) {
            char cs = words[i].charAt(0);
            char ce = words[i].charAt(words[i].length()-1);
            if ((cs == 'a' || cs == 'e' || cs == 'i' || cs == 'o' || cs == 'u')
            && (ce == 'a' || ce == 'e' || ce == 'i' || ce == 'o' || ce == 'u'))
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(vowelStrings(new String[] {"are","amy","u"}, 0, 2));
        System.out.println(vowelStrings(new String[] {"hey","aeo","mu","ooo","artro"}, 1, 4));
    }
}
