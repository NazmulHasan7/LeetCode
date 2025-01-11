// 2785. Sort Vowels in a String
package Medium;

public class Medium_2785_Sort_Vowels_in_a_String {
    public static String sortVowels(String s) {
        char[] crr = s.toCharArray();
        int[] map = new int[128];

        for (int i=0; i<crr.length; i++) {
            if (isVowel(Character.toLowerCase(crr[i]))) {
                map[crr[i]]++; // count the occurrence of each vowel
                crr[i] = '*';
            }
        }

        int mapIdx = 0;
        for (int i=0; i<crr.length; i++) {
            if (crr[i] == '*') {
                while (map[mapIdx] == 0)
                    mapIdx++;
                crr[i] = (char) mapIdx;
                map[mapIdx]--;
            }
        } return new String(crr);
    }
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public static void main(String[] args) {
        System.out.println(sortVowels("lEetcOde"));
        System.out.println(sortVowels("lYmpH"));
    }
}
