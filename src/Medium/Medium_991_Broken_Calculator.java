// 991. Broken Calculator
package Medium;

public class Medium_991_Broken_Calculator {
    public static int brokenCalc(int startValue, int target) {
        int answer = 0;
        while (startValue < target) {
            if (target % 2 == 0)
                target /= 2;
            else target++;
            answer++;
        }
        return (startValue - target) + answer;
    }
    public static void main(String[] args) {
        System.out.println(brokenCalc(2,3));
        System.out.println(brokenCalc(5,8));
        System.out.println(brokenCalc(3,10));
    }
}
