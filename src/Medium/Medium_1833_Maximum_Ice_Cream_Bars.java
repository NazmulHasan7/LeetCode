// 1833. Maximum Ice Cream Bars
package Medium;

public class Medium_1833_Maximum_Ice_Cream_Bars {
    public static int maxIceCream(int[] costs, int coins) {
        int max = 0;
        for (int c : costs)
            max = Math.max(max, c);

        int[] freq = new int[max + 1];
        for (int c : costs) freq[c]++;

        int answer = 0;
        for (int i=1; i<=max; i++) {
            if (freq[i] * i >= coins) {
                answer += coins/i;
                break;
            } else {
                coins -= freq[i] * i;
                answer += freq[i];
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(maxIceCream(new int[]{1,3,2,4,1},7));
        System.out.println(maxIceCream(new int[]{10,6,8,7,7,8},5));
        System.out.println(maxIceCream(new int[]{1,6,3,1,2,5},20));
    }
}
