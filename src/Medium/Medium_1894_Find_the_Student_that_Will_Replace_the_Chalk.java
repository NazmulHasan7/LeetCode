// 1894. Find the Student that Will Replace the Chalk
package Medium;

public class Medium_1894_Find_the_Student_that_Will_Replace_the_Chalk {
    public static int chalkReplacer(int[] chalk, int k) {
        int sum = 0, len = chalk.length;
        for (int i=0; i<len; i++) {
            k = k - chalk[i];
            // If the chalks are not enough even for a round
            if (k < 0) return i;
            sum += chalk[i];
        }
        k = k % sum;
        for (int i=0; i<len; i++) {
            k = k - chalk[i];
            if (k < 0) return i;
        } return -1;
    }
    public static void main(String[] args) {
        System.out.println(chalkReplacer(new int[]{5,1,5},22));
        System.out.println(chalkReplacer(new int[]{3,4,1,2},25));
    }
}
