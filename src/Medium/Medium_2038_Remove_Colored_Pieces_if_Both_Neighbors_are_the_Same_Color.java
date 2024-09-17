// 2038. Remove Colored Pieces if Both Neighbors are the Same Color
package Medium;

public class Medium_2038_Remove_Colored_Pieces_if_Both_Neighbors_are_the_Same_Color {
    public static boolean winnerOfGame(String colors) {
        int alice = 0, bob = 0;
        int n = colors.length();
        char[] crr = colors.toCharArray();

        for (int i=1; i<n-1; i++) {
            if (crr[i-1] == crr[i] && crr[i] == crr[i+1]) {
                if (crr[i] == 'A') alice++;
                else bob++;
            }
        } return alice > bob;
    }
    public static void main(String[] args) {
        System.out.println(winnerOfGame("AAABABB"));
        System.out.println(winnerOfGame("AA"));
        System.out.println(winnerOfGame("ABBBBBBBAAA"));
    }
}
