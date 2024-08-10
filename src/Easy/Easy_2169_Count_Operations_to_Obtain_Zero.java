// 2169. Count Operations to Obtain Zero
package Easy;

public class Easy_2169_Count_Operations_to_Obtain_Zero {
    public static int countOperationsRecursive(int num1, int num2) {
        if (num1 == 0 || num2 == 0) return 0;
        else if (num1 >= num2)
            return 1 + countOperationsRecursive(num1 - num2, num2);
        else return 1 + countOperationsRecursive(num2 - num1, num1);
    }
    public static int countOperations(int num1, int num2) {
        int count = 0;
        if (num1 == 0 || num2 == 0) return count;
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                count += num1 / num2;
                num1 = num1 % num2;
            } else {
                count += num2 / num1;
                num2 = num2 % num1;
            }
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(countOperations(2, 3));
        System.out.println(countOperations(10, 10));
    }
}
