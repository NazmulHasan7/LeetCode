// 1528. Shuffle String
package Easy;

public class Easy_1528_Shuffle_String {
    public static String restoreString(String s, int[] indices) {
        char[] str = new char[indices.length];
        for (int i=0; i<indices.length; i++)
            str[indices[i]] = s.charAt(i);
        return String.valueOf(str);
    }
    public static void main(String[] args) {
        System.out.println(restoreString("codeleet", new int[] {4,5,6,7,0,2,1,3}));
    }
}