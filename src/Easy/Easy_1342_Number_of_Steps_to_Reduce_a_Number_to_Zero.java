package Easy;

public class Easy_1342_Number_of_Steps_to_Reduce_a_Number_to_Zero {
    public static int numberOfSteps(int num) {
        int steps = 0;
        while (num != 0) {
            if (num % 2 == 0)
                num /= 2;
            else
                num -= 1;
            steps++;
        } return steps;
    }
    public static int numberOfStepsBitManipulation(int num) {
        int steps = 0;
        while (num != 0) {
            if ((num & 1) == 0)
                num = num >> 1;
            else
                num -= 1;
            steps++;
        } return steps;
    }
    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
        System.out.println(numberOfStepsBitManipulation(14));
        System.out.println(numberOfSteps(8));
        System.out.println(numberOfStepsBitManipulation(8));
        System.out.println(numberOfSteps(123));
        System.out.println(numberOfStepsBitManipulation(123));
    }
}
