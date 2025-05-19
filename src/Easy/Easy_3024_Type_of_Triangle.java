// 3024. Type of Triangle
package Easy;

public class Easy_3024_Type_of_Triangle {
    public static String triangleType(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        boolean isValidLengths = a+b > c && b+c > a && a+c > b;
        if (isValidLengths) {
            if (a == b && b == c)
                return "equilateral";
            else if (a == b || b == c || a == c)
                return "isosceles";
            else
                return "scalene";
        }
        return "none";
    }
    public static void main(String[] args) {
        System.out.println(triangleType(new int[]{3,3,3}));
        System.out.println(triangleType(new int[]{3,4,5}));
    }
}
