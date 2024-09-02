// 3270. Find the Key of the Numbers
package Easy;

public class Easy_3270_Find_the_Key_of_the_Numbers {
    public static int generateKey(int num1, int num2, int num3) {
        int answer = 0;
        int multiplier = 1;

        for (int i=0; i<4; i++) {
            int d1 = num1 % 10;
            int d2 = num2 % 10;
            int d3 = num3 % 10;
            int min = Math.min(d1, Math.min(d2, d3));
            answer += (min * multiplier);

            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
            multiplier *= 10;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(generateKey(1,10,1000));
        System.out.println(generateKey(987,879,798));
    }
}
