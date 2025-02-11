package Easy;
import java.util.Scanner;

public class _001_Rename {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        StringBuilder updatedName = new StringBuilder("Medium_");
        for (char c: name.toCharArray()) {
            if (c != '.') {
                if (c == ' ' || c == '-') c = '_';
                updatedName.append(c);
            }
        } System.out.println(updatedName);
    }
}
// 2222. Number of Ways to Select Buildings
