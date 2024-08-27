// 860. Lemonade Change
package Easy;

public class Easy_860_Lemonade_Change {
    public static boolean lemonadeChange(int[] bills) {
        if (bills[0] > 5) return false;
        int $5 = 0, $10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                $5++;
            } else if (bill == 10) {
                if ($5 == 0) return false;
                $5--;
                $10++;
            } else {
                if ($5 > 0 && $10 > 0) {
                    $5--;
                    $10--;
                } else if ($5 >= 3) {
                    $5 -= 3;
                } else return false;
            }
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5,5,5,10,20}));
        System.out.println(lemonadeChange(new int[]{5,5,10,10,20}));
        System.out.println(lemonadeChange(new int[]{5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5}));
    }
}
