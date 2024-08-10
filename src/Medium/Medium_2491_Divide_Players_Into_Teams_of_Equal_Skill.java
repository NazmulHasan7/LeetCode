// 2491. Divide Players Into Teams of Equal Skill
package Medium;
import java.util.Arrays;

public class Medium_2491_Divide_Players_Into_Teams_of_Equal_Skill {
    public static long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int length = skill.length;
        long target = skill[0] + skill[length-1];

        int start = 0, end = length-1;
        long total = 0;
        while (start < end) {
            if (skill[start] + skill[end] != target)
                return -1;
            total += (long) skill[start] * skill[end];
            start++;
            end--;
        } return total;
    }
    public static void main(String[] args) {
        System.out.println(dividePlayers(new int[] {3,2,5,1,3,4}));
        System.out.println(dividePlayers(new int[] {3,4}));
        System.out.println(dividePlayers(new int[] {1,1,2,3}));
    }
}
