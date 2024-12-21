// 2043. Simple Bank System
package Medium;

public class Medium_2043_Simple_Bank_System {
    static class Bank {
        private int n;
        private long[] balance;
        public Bank(long[] balance) {
            this.n = balance.length;
            this.balance = balance;
        }
        public boolean transfer(int account1, int account2, long money) {
            if (account1 >= 1 && account1 <= n && account2 >= 1 && account2 <= n) {
                if (balance[account1-1] >= money) {
                    balance[account1-1] -= money;
                    balance[account2-1] += money;
                    return true;
                }
            } return false;
        }
        public boolean deposit(int account, long money) {
            if (account >= 1 && account <= n) {
                balance[account-1] += money;
                return true;
            } return false;
        }
        public boolean withdraw(int account, long money) {
            if (account >= 1 && account <= n && balance[account-1] >= money) {
                balance[account-1] -= money;
                return true;
            } return false;
        }
    }
    public static void main(String[] args) {
        Bank bank = new Bank(new long[]{10, 100, 20, 50, 30});
        System.out.println(bank.withdraw(3, 10));
        // Account 3 has $20 - $10 = $10.
        System.out.println(bank.transfer(5, 1, 20));
        // Account 5 has $30 - $20 = $10, and account 1 has $10 + $20 = $30.
        System.out.println(bank.deposit(5, 20));
        // Account 5 has $10 + $20 = $30.
        System.out.println(bank.transfer(3, 4, 15));
        // so it is invalid to transfer $15 from it.
        System.out.println(bank.withdraw(10, 50));
    }
}
