// 1700. Number of Students Unable to Eat Lunch
package Easy;

public class Easy_1700_Number_of_Students_Unable_to_Eat_Lunch {
    public static int countStudents(int[] students, int[] sandwiches) {
        int student1 = 0, student0 = 0;
        for (int student : students) {
            if (student == 0) student0++;
            else student1++;
        }
        // order of students does not matter
        // strict order of sandwiches does matter
        for (int sandwich : sandwiches) {
            if (sandwich == 0) {
                if (student0 == 0) break;
                else student0--;
            } else {
                if (student1 == 0) break;
                else student1--;
            }
        } return student1 + student0;
    }
    public static void main(String[] args) {
        System.out.println(countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
        System.out.println(countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
    }
}
