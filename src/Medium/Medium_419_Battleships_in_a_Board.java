// 419. Battleships in a Board
package Medium;

public class Medium_419_Battleships_in_a_Board {
    private static void dfs(int r, int c, int n, int m, char[][] board) {
        if (r<0 || c<0 || r>=n || c>=m || board[r][c] == '.')
            return;

        board[r][c] = '.';
        dfs(r-1, c, n, m, board);
        dfs(r+1, c, n, m, board);
        dfs(r, c-1, n, m, board);
        dfs(r, c+1, n, m, board);
    }
    public static int countBattleships(char[][] board) {
        int count = 0;
        int n = board.length, m = board[0].length;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    dfs(i, j, n, m, board);
                }
            }
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(countBattleships(new char[][]{
                {'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}}));
        System.out.println(countBattleships(new char[][]{{'.'}}));
    }
}
