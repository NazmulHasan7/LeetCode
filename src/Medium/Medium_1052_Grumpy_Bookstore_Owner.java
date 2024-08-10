// 1052. Grumpy Bookstore Owner
package Medium;

public class Medium_1052_Grumpy_Bookstore_Owner {
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0;
        // Customers who are already satisfied
        for (int i=0; i<grumpy.length; i++)
            if (grumpy[i] == 0) satisfied += customers[i];

        // keep themselves not grumpy for minutes consecutive minutes
        int left = 0, right = 0, bonus = 0, bonusInCurrentWindow = 0;

        while (right < grumpy.length) {
            if (grumpy[right] == 1)
                bonusInCurrentWindow += customers[right];
            // Window size reaches minutes
            while (right - left + 1 > minutes) {
                if (grumpy[left] == 1)
                    bonusInCurrentWindow -= customers[left];
                left++;
            }
            bonus = Math.max(bonus, bonusInCurrentWindow);
            right++;
        } return satisfied + bonus;
    }
    public static void main(String[] args) {
        System.out.println(maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));
        System.out.println(maxSatisfied(new int[]{1}, new int[]{0}, 1));
    }
}
