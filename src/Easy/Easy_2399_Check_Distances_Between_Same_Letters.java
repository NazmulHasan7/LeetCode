// 2399. Check Distances Between Same Letters
package Easy;

public class Easy_2399_Check_Distances_Between_Same_Letters {
    public static boolean checkDistances(String s, int[] distance) {
        int[] forwardDistance = new int[26];
        int[] backwardDistance = new int[26];
        int length = s.length();

        for (int i=0; i<length; i++)
            forwardDistance[s.charAt(i)-'a'] = i;
        for (int j=length-1; j>=0; j--)
            backwardDistance[s.charAt(j)-'a'] = j;

        for (int i=0; i<distance.length; i++) {
            if (backwardDistance[i] != 0 || forwardDistance[i] != 0)
                if (Math.abs(backwardDistance[i] - forwardDistance[i]) - 1 != distance[i])
                    return false;
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(checkDistances("abaccb", new int[]
                {1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
        System.out.println(checkDistances("aa", new int[]
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }
}
