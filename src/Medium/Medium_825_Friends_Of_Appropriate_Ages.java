// 825. Friends Of Appropriate Ages
package Medium;

public class Medium_825_Friends_Of_Appropriate_Ages {
    public static int numFriendRequests(int[] ages) {
        int [] ageCount=new int[121];
        for(int age : ages) ageCount[age]++;
        int request = 0;

        for(int x=1; x<=120; x++){
            // Iterate over the valid range
            for(int y=(int)(0.5*x)+7+1; y<=x; y++){
                request += ageCount[x]* ageCount[y];
                if(x==y) request -= ageCount[x];
            }
        } return request;
    }
    public static void main(String[] args) {
        System.out.println(numFriendRequests(new int[]{16,17,18}));
        System.out.println(numFriendRequests(new int[]{20,30,100,110,120}));
    }
}
