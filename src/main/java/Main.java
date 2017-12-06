/**
 * Created by jviladoms on 6/12/17.
 */
public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(Strategy.STANDARD);

        bankAccount.deposit(100);
        bankAccount.withdraw(50);
        bankAccount.deposit(200);
        bankAccount.printStatement();
    }
}
