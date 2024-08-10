// 2938. Separate Black and White Balls
package Medium;

public class Medium_2938_Separate_Black_and_White_Balls {
    public static long minimumSteps(String s) {
        int len = s.length();
        int last1Idx = s.length()-1;
        long steps = 0;
        for (int i=len-1; i>=0; i--) {
            if (s.charAt(i) == '1') {
                steps += (last1Idx - i);
                last1Idx--;
            }
        } return steps;
    }
    public static void main(String[] args) {
        System.out.println(minimumSteps("101"));
        System.out.println(minimumSteps("100"));
        System.out.println(minimumSteps("0111"));
    }
}
