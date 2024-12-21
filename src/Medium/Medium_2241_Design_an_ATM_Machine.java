// 2241. Design an ATM Machine
package Medium;
import java.util.Arrays;

public class Medium_2241_Design_an_ATM_Machine {
    static class ATM {
        long[][] notes;
        public ATM() {
            this.notes = new long[][]{{20,0}, {50,0}, {100,0}, {200,0}, {500,0}};
        }
        public void deposit(int[] banknotesCount) {
            for (int i=0; i<5; i++)
                this.notes[i][1] += banknotesCount[i];
        }
        public int[] withdraw(int amount) {
            int[] result = new int[5];
            for (int i=4; i>=0; i--) {
                if (amount >= notes[i][0]) {
                    int count = (int) Math.min(notes[i][1], amount / notes[i][0]);
                    amount -= (int) (notes[i][0] * count);
                    result[i] = count;
                }
            }
            if (amount != 0) return new int[]{-1};
            // A valid combination found, deduct the note counts
            for (int i=0; i<5; i++) notes[i][1] -= result[i];
            return result;
        }
    }
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.deposit(new int[]{0,0,1,2,1});
        System.out.println(Arrays.toString(atm.withdraw(600)));
        atm.deposit(new int[]{0,1,0,1,1});
        System.out.println(Arrays.toString(atm.withdraw(600)));
        System.out.println(Arrays.toString(atm.withdraw(550)));
    }
}
