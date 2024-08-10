// 79. Word Search
package Medium;

public class Medium_79_Word_Search {
    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        char[] crr = word.toCharArray();

        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (board[r][c] == crr[0] && dfs(board, crr, 0, r, c))
                    return true;
            }
        } return false;
    }
    private static boolean dfs(char[][] board, char[] crr, int idx, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length)
            return false;
        if (crr[idx] != board[row][col])
            return false;
        if (idx == crr.length-1)
            return true;

        // Mark the current element as visited
        char curr = board[row][col];
        board[row][col] = '*';
        boolean found = dfs(board, crr, idx+1, row+1, col)
                || dfs(board, crr, idx+1, row-1, col)
                || dfs(board, crr, idx+1, row, col+1)
                || dfs(board, crr, idx+1, row, col-1);
        // Undo the marking
        board[row][col] = curr;
        return found;
    }
    public static void main(String[] args) {
        System.out.println(exist(new char[][]{
                {'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}
        }, "SEE"));
        System.out.println(exist(new char[][]{
                {'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}
        }, "ABCB"));
    }
}
