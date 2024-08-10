// 1009. Complement of Base 10 Integer
package Easy;

public class Easy_1009_Complement_of_Base_10_Integer {
    public static int bitwiseComplement(int n) {
        int x = 0, temp = n;
        if (n == 0) return 1;
        // Complement = all 1's - num
        while (temp != 0) {
            temp >>= 1;
            x++;
        } return (int) (Math.pow(2, x) - 1) - n;
    }
    public static void main(String[] args) {
        System.out.println(bitwiseComplement(5));
        System.out.println(bitwiseComplement(7));
        System.out.println(bitwiseComplement(10));
        System.out.println(bitwiseComplement(0));
        System.out.println(bitwiseComplement(1));
    }
}
