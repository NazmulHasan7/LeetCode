// 1535. Find the Winner of an Array Game
package Medium;

public class Medium_1535_Find_the_Winner_of_an_Array_Game {
    // Exactly the same as 3175
    public static int getWinner(int[] arr, int k) {
        int n = arr.length;
        int winner = arr[0], winCount = 0;

        for (int i=1; i<n; i++) {
            if (winner < arr[i]) {
                winCount = 1;
                winner = arr[i];
            } else {
                winCount++;
            }
            if (winCount == k) break;
        } return winner;
    }
    public static void main(String[] args) {
        System.out.println(getWinner(new int[]{2,1,3,5,4,6,7},2));
        System.out.println(getWinner(new int[]{3,2,1},10));
    }
}
