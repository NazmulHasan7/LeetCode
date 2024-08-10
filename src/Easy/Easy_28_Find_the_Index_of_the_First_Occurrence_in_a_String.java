// 28. Find the Index of the First Occurrence in a String
package Easy;

public class Easy_28_Find_the_Index_of_the_First_Occurrence_in_a_String {
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
    }
}
