// 794. Valid Tic-Tac-Toe State
package Medium;

public class Medium_794_Valid_Tic_Tac_Toe_State {
    public static boolean validTicTacToe(String[] board) {
        int xCount = 0;
        int oCount = 0;

        for (String row : board)
            for (char c : row.toCharArray())
                if (c == 'X') xCount++;
                else if (c == 'O')oCount++;

        // invalid case 1 -> X & O count should be same or difference is max 1
        if (xCount != oCount && xCount - oCount != 1)
            return false;

        boolean xWin = checkForWin(board, 'X');
        boolean oWin = checkForWin(board, 'O');

        // invalid case 2 -> both cannot win
        if (xWin && oWin) return false;
        // invalid case 3 -> x wins but x and o count are same
        if (xWin && xCount == oCount) return false;
        // invalid case 4 -> o wins but x and o count are not same
        if (oWin && xCount != oCount) return false;
        return true;
    }
    private static boolean checkForWin(String[] board, char target) {
        // check for horizontal
        for (String row : board)
            if (row.charAt(0) == target && row.charAt(1) == target && row.charAt(2) == target)
                return true;

        // check for vertical
        for (int c=0; c<3; c++)
            if (board[0].charAt(c) == target && board[1].charAt(c) == target && board[2].charAt(c) == target)
                return true;

        // check for diagonal top left to bottom right
        if (board[0].charAt(0) == target && board[1].charAt(1) == target && board[2].charAt(2) == target)
            return true;
        // check for diagonal top right to bottom left
        if (board[0].charAt(2) == target && board[1].charAt(1) == target && board[2].charAt(0) == target)
            return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(validTicTacToe(new String[]{"O  ","   ","   "}));
        System.out.println(validTicTacToe(new String[]{"XOX"," X ","   "}));
        System.out.println(validTicTacToe(new String[]{"XOX","O O","XOX"}));
    }
}
