// 165. Compare Version Numbers
package Medium;

public class Medium_165_Compare_Version_Numbers {
    public static int compareVersion(String version1, String version2) {
        int n1 = version1.length();
        int n2 = version2.length();

        int i=0, j=0;
        while (i<n1 || j<n2) {
            int revisionV1 = 0;
            int revisionV2 = 0;

            while (i<n1 && version1.charAt(i) != '.')
                revisionV1 = revisionV1 * 10 + version1.charAt(i++) - '0';
            i++;

            while (j<n2 && version2.charAt(j) != '.')
                revisionV2 = revisionV2 * 10 + version2.charAt(j++) - '0';
            j++;

            if (revisionV1 < revisionV2) return -1;
            else if (revisionV1 > revisionV2) return 1;
        } return 0;
    }
    public static void main(String[] args) {
        System.out.println(compareVersion("1.01", "1.001"));
        System.out.println(compareVersion("1.0", "1.0.0"));
        System.out.println(compareVersion("0.1", "1.1"));
    }
}
