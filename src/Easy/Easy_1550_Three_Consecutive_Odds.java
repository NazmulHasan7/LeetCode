// 1550. Three Consecutive Odds
package Easy;

public class Easy_1550_Three_Consecutive_Odds {
    public static boolean threeConsecutiveOdds(int[] arr) {
        for (int i=0; i<arr.length-2; i++)
            if (arr[i] % 2 == 1 && arr[i+1] % 2 == 1 && arr[i+2] % 2 == 1)
                return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(threeConsecutiveOdds(new int[] {2,6,4,1}));
        System.out.println(threeConsecutiveOdds(new int[] {1,2,34,3,4,5,7,23,12}));
    }
}
