// 2011. Final Value of Variable After Performing Operations
package Easy;

public class Easy_2011_Final_Value_of_Variable_After_Performing_Operations {
    public static int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String op: operations)
            x += (op.equals("X++") || op.equals("++X")) ? 1 : -1;
        return x;
    }
    public static void main(String[] args) {
        System.out.println(finalValueAfterOperations(new String[]{"--X","X++","X++"}));
        System.out.println(finalValueAfterOperations(new String[]{"++X","++X","X++"}));
        System.out.println(finalValueAfterOperations(new String[]{"X++","++X","--X","X--"}));
    }
}
