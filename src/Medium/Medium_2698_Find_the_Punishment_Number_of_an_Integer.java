// 2698. Find the Punishment Number of an Integer
package Medium;

public class Medium_2698_Find_the_Punishment_Number_of_an_Integer {
    // Time complexity -> O(n) * 2^(log10(i^2))
    // SC -> log10(i^2) [stack]
    public static int punishmentNumber(int n) {
        int punishment = 1; // 1*1 == 1
        for (int i=2; i<=n; i++) { // O(n)
            int square = i * i;
            if (check(String.valueOf(square), 0, 0, i)) // 2^(log10(i^2))
                punishment += square;
        }
        return punishment;
    }
    // Number of digits = digits of (i^2) = log10(i^2) = 2log10(i)
    // For each digit we have two possibilities -> partition in this index or skip it
    // so -> 2^(log10(i^2))
    private static boolean check(String str, int pos, int sum, int target) {
        if (pos == str.length())
            return sum == target;

        if (sum > target) return false;

        for (int i=pos+1; i<=str.length(); i++) {
            int value = Integer.parseInt(str.substring(pos, i));
            if (check(str, i, sum + value, target))
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(punishmentNumber(10));
        System.out.println(punishmentNumber(37));
    }
}
