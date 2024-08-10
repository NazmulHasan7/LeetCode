// 682. Baseball Game
package Easy;
import java.util.ArrayList;

public class Easy_682_Baseball_Game {
    public static int calPoints(String[] operations) {
        int sum = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (String op : operations) {
            if (op.equals("+"))
                arr.add(arr.get(arr.size()-1) + (arr.get(arr.size()-2)));
            else if (op.equals("D"))
                arr.add(arr.get(arr.size()-1) * 2);
            else if (op.equals("C"))
                arr.remove(arr.size()-1);
            else
                arr.add(Integer.parseInt(op));
        }
        for (int i=0; i<arr.size(); i++)
            sum += arr.get(i);
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(calPoints(new String[] {"5","2","C","D","+"}));
        System.out.println(calPoints(new String[] {"5","-2","4","C","D","9","+","+"}));
        System.out.println(calPoints(new String[] {"1","C"}));
        System.out.println(calPoints(new String[] {"1","C","-62","-45","-68"}));
    }
}
