import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAccount {

    private int balance;
    private List<AccountingEntry> accountingEntryList = new ArrayList<>();
    private PrintStatement printStatement;

    public BankAccount(Strategy strategy){
        printStatement = PrintStatementStrategy.get(strategy);
    }

    public void deposit(int amount){
        createAccountingEntry(amount);
    }

    public void withdraw(int amount){
        createAccountingEntry(-amount);
    }

    public void printStatement(){
        printStatement.print(accountingEntryList);
    }

    public void createAccountingEntry(int amount){
        AccountingEntry accountingEntry = new AccountingEntry(new Date(), amount, balance);
        accountingEntryList.add(accountingEntry);
        balance = balance + amount;
    }
}
