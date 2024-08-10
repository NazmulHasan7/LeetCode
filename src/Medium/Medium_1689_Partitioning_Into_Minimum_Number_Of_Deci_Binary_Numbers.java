// 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
package Medium;

public class Medium_1689_Partitioning_Into_Minimum_Number_Of_Deci_Binary_Numbers {
    /*
        Given  4 2 3 1
        Binary 1 1 1 1
               1 1 1 0
               1 0 1 0
               1 0 0 0
        These are the minimum numbers required to sum up to 4231
     */
    public static int minPartitions(String n) {
        int max = 0;
        for (char c : n.toCharArray())
            max = Math.max(max, c-48);
        return max;
    }
    public static void main(String[] args) {
        System.out.println(minPartitions("32"));
        System.out.println(minPartitions("82734"));
        System.out.println(minPartitions("27346209830709182346"));
    }
}
