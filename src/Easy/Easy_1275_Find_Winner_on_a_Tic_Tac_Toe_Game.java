// 1275. Find Winner on a Tic Tac Toe Game
package Easy;
import java.util.HashMap;

public class Easy_1275_Find_Winner_on_a_Tic_Tac_Toe_Game {
    public static String tictactoe(int[][] moves) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('X', "A");
        map.put('0', "B");

        char player;
        char[][] board = new char[3][3];

        for (int i=0; i<moves.length; i++) {
            player = (i % 2 == 0) ? 'X' : '0';
            board[moves[i][0]][moves[i][1]] = player;
            if (rowCheck(board, player, moves[i][0]) || columnCheck(board, player, moves[i][1]) || diagonalCheck(board, player))
                return map.get(player);
            if (i == 8) return "Draw";
        }
        return "Pending";
    }
    public static boolean rowCheck(char[][] board, char player, int r) {
        return board[r][0] == player && board[r][1] == player && board[r][2] == player;
    }
    public static boolean columnCheck(char[][] board, char player, int c) {
        return board[0][c] == player && board[1][c] == player && board[2][c] == player;
    }
    public static boolean diagonalCheck(char[][] board, char player) {
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player)
                || (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }
    public static void main(String[] args) {
        System.out.println(tictactoe(new int[][] {{0,0},{2,0},{1,1},{2,1},{2,2}}));
        System.out.println(tictactoe(new int[][] {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}}));
        System.out.println(tictactoe(new int[][] {{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}}));
        System.out.println(tictactoe(new int[][] {{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1}}));
    }
}
