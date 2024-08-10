// 278. First Bad Version
package Easy;

public class Easy_278_First_Bad_Version {
    public static boolean isBadVersion(int version) {
        return version == 4; // test sample
    }
    public static int firstBadVersion(int end) {
        int start = 1, mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (isBadVersion(mid)) end = mid;
            else start = mid + 1;
        } return start;
    }
    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
        System.out.println(firstBadVersion(1));
    }
}
