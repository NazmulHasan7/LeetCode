// 2119. A Number After a Double Reversal
package Easy;

public class Easy_2119_A_Number_After_a_Double_Reversal {
    public static boolean isSameAfterReversals(int num) {
        if (num == 0) return true;
        else return (num % 10 != 0);
    }
    public static void main(String[] args) {
        System.out.println(isSameAfterReversals(526));
        System.out.println(isSameAfterReversals(1800));
        System.out.println(isSameAfterReversals(0));
    }
}
