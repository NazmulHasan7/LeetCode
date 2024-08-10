// 434. Number of Segments in a String
package Easy;

public class Easy_434_Number_of_Segments_in_a_String {
    public static int countSegments(String s) {
        // StringTokenizer st = new StringTokenizer(s, " ");
        // return st.countTokens();
        String[] strArr = s.split(" ");
        int count = 0;
        for (String str : strArr)
            if (!str.isEmpty()) count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John"));
        System.out.println(countSegments("Hello"));
        System.out.println(countSegments(""));
    }
}
