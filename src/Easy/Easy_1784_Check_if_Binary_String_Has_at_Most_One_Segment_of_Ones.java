// 1784. Check if Binary String Has at Most One Segment of Ones
package Easy;

public class Easy_1784_Check_if_Binary_String_Has_at_Most_One_Segment_of_Ones {
    public static boolean checkOnesSegment(String s) {
        // return !s.contains("01");
        for (int i=1; i<s.length(); i++)
            if (s.charAt(i-1) == '0' && s.charAt(i) == '1')
                return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(checkOnesSegment("1001"));
        System.out.println(checkOnesSegment("110"));
    }
}
