// 476. Number Complement
package Easy;

public class Easy_476_Number_Complement {
    public static int findComplement(int num) {
        // Complement = all 1s - num
        int temp = num, n =0;
        while (temp != 0) {
            temp >>= 1;
            n++;
        }
        return (int)((Math.pow(2, n) - 1) - num);
    }
    public static void main(String[] args) {
        System.out.println(findComplement(5));
        System.out.println(findComplement(1));
    }
}
