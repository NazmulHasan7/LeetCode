// 374. Guess Number Higher or Lower
package Easy;

public class Easy_374_Guess_Number_Higher_or_Lower {
    public static int guess(int num) {
        if (num == 6) return 0;
        else if (num < 6) return 1;
        else return -1;
    }
    public static int guessNumber(int end) {
        int start = 1, mid = 0, res;
        while (start <= end) {
            mid = start + (end - start) / 2;
            res = guess(mid);
            if (res == 0) return mid;
            else if (res == -1) end = mid - 1;
            else start = mid + 1;
        } return -1;
    }
    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }
}
