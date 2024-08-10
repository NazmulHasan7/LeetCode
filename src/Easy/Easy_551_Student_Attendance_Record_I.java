// 551. Student Attendance Record I
package Easy;

public class Easy_551_Student_Attendance_Record_I {
    public static boolean checkRecord(String s) {
        int aCount = 0, lCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                aCount++;
                if (aCount > 1) return false;
                lCount = 0;
            } else if (c == 'L') {
                lCount++;
                if (lCount == 3) return false;
            } else lCount = 0;
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLP"));
        System.out.println(checkRecord("PPALLL"));
    }
}
