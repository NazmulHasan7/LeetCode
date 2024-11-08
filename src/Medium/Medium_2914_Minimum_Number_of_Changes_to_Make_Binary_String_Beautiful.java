// 2914. Minimum Number of Changes to Make Binary String Beautiful
package Medium;

public class Medium_2914_Minimum_Number_of_Changes_to_Make_Binary_String_Beautiful {
    public static int minChanges(String s) {
        // The problem requires us to count the number of changes needed to make adjacent pairs in the string identical.
        // This means for each pair (s[i], s[i + 1]), we check if they are the same.
        // If they are not, it counts as one required change to make them identical

        int n = s.length();
        int count = 0;

        for (int i=0; i<n-1; i+=2) {
            if (s.charAt(i) != s.charAt(i+1))
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
         System.out.println(minChanges("1001"));
         System.out.println(minChanges("10"));
         System.out.println(minChanges("0000"));
    }
}
