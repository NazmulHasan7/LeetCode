// 1079. Letter Tile Possibilities
package Medium;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Medium_1079_Letter_Tile_Possibilities {
    public static int numTilePossibilities(String tiles) {
        Set<String> answer = new HashSet<>();
        backtrack(tiles, new StringBuilder(), answer, new boolean[tiles.length()]);
        return answer.size();
    }
    private static void backtrack(String tiles, StringBuilder current, Set<String> answer, boolean[] used) {
        if (!current.isEmpty())
            answer.add(current.toString());

        for (int i=0; i<tiles.length(); i++) {
            if (used[i]) continue;
            used[i] = true;
            current.append(tiles.charAt(i));
            backtrack(tiles, current, answer, used);
            used[i] = false;
            current.deleteCharAt(current.length()-1);
        }
    }
    static int count = 0;
    public static int numTilePossibilitiesBetter(String tiles) {
        char[] crr = tiles.toCharArray();
        Arrays.sort(crr);
        backtrack(crr, new boolean[crr.length]);
        return count;
    }
    private static void backtrack(char[] crr, boolean[] used) {
        for (int i=0; i<crr.length; i++) {
            if (used[i] || i>0 && crr[i] == crr[i-1] && !used[i-1])
                continue;
            count++;
            used[i] = true;
            backtrack(crr, used);
            used[i] = false;
        }
    }
    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
        System.out.println(numTilePossibilities("AAABBC"));
        System.out.println(numTilePossibilities("V"));
    }
}
