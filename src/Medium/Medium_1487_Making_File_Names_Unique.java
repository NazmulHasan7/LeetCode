// 1487. Making File Names Unique
package Medium;
import java.util.Arrays;
import java.util.HashMap;

public class Medium_1487_Making_File_Names_Unique {
    public static String[] getFolderNames(String[] names) {
        int n = names.length;
        String[] answer = new String[n];

        HashMap<String, Integer> map = new HashMap<>();

        for (int i=0; i<n; i++) {
            int occurrence = map.getOrDefault(names[i], 0);
            if (occurrence == 0) {
                answer[i] = names[i];
                map.put(names[i], occurrence+1);
            } else {
                int k = occurrence;
                String newName = names[i] + "(" + occurrence + ")";
                while (map.containsKey(newName)) {
                    k++;
                    newName = names[i] + "(" + k + ")";
                }
                map.put(names[i], k);
                map.put(newName, 1);
                answer[i] = newName;
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFolderNames(new String[]{"pes","fifa","gta","pes(2019)"})));
        System.out.println(Arrays.toString(getFolderNames(new String[]{"gta","gta(1)","gta","avalon"})));
    }
}
