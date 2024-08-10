// 3019. Number of Changing Keys
package Easy;

public class Easy_3019_Number_of_Changing_Keys {
    public static int countKeyChanges(String s) {
        s = s.toLowerCase();
        int count = 0;
        for (int i=1; i<s.length(); i++)
            if (s.charAt(i-1) != s.charAt(i))
                count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countKeyChanges("aAbBcC"));
        System.out.println(countKeyChanges("AaAaAaaA"));
    }
}
