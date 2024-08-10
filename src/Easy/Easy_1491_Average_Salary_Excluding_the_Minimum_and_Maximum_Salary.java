// 1491. Average Salary Excluding the Minimum and Maximum Salary
package Easy;

public class Easy_1491_Average_Salary_Excluding_the_Minimum_and_Maximum_Salary {
    public static double average(int[] salary) {
        int min = salary[0], max = salary[0], total = 0;
        int n = salary.length;
        for (int i : salary) {
            total += i;
            if (i < min) min = i;
            else if (i > max) max = i;
        }
        return (double)(total - min - max) / (n-2);
    }
    public static void main(String[] args) {
        System.out.println(average(new int[] {4000,3000,1000,2000}));
        System.out.println(average(new int[] {1000,2000,3000}));
    }
}
