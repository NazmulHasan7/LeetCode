// 2446. Determine if Two Events Have Conflict
package Easy;

public class Easy_2446_Determine_if_Two_Events_Have_Conflict {
    public static boolean haveConflict(String[] event1, String[] event2){
        int start1 = Integer.parseInt(event1[0].substring(0, 2)) * 60 + Integer.parseInt(event1[0].substring(3));
        int end1   = Integer.parseInt(event1[1].substring(0, 2)) * 60 + Integer.parseInt(event1[1].substring(3));
        int start2 = Integer.parseInt(event2[0].substring(0, 2)) * 60 + Integer.parseInt(event2[0].substring(3));
        int end2   = Integer.parseInt(event2[1].substring(0, 2)) * 60 + Integer.parseInt(event2[1].substring(3));
        return start2 <= end1 && start1 <= end2;
    }
    public static void main(String[] args) {
        System.out.println(haveConflict(new String[] {"01:15","02:00"}, new String[] {"02:00","03:00"}));
        System.out.println(haveConflict(new String[] {"01:00","02:00"}, new String[] {"01:20","03:00"}));
        System.out.println(haveConflict(new String[] {"10:00","11:00"}, new String[] {"14:00","15:00"}));
    }
}
