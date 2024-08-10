// 2660. Determine the Winner of a Bowling Game
package Easy;

public class Easy_2660_Determine_the_Winner_of_a_Bowling_Game {
    public static int isWinner(int[] player1, int[] player2) {
        int player1Score = player1[0];
        int player2Score = player2[0];

        int length = player1.length;
        if (length > 1) {
            player1Score += (player1Score == 10) ? player1[1] * 2 : player1[1];
            player2Score += (player2Score == 10) ? player2[1] * 2 : player2[1];
            for (int i=2; i<length; i++) {
                player1Score += (player1[i-1]==10 || player1[i-2]==10) ? player1[i] * 2 : player1[i];
                player2Score += (player2[i-1]==10 || player2[i-2]==10) ? player2[i] * 2 : player2[i];
            }
        } // System.out.println(player1Score + " " + player2Score);
        if (player1Score == player2Score) return 0;
        return (player1Score > player2Score) ? 1 : 2;
    }
    public static void main(String[] args) {
        System.out.println(isWinner(new int[] {4,10,7,9}, new int[] {6,5,2,3}));
        System.out.println(isWinner(new int[] {3,5,7,6}, new int[] {8,10,10,2}));
        System.out.println(isWinner(new int[] {2,3}, new int[] {4,1}));
    }
}
