import java.text.SimpleDateFormat;
import java.util.List;

public class BasePrintStatement implements  PrintStatement{

    @Override
    public void print(List<AccountingEntry> accountingEntryList){
        System.out.println("DATE | AMOUNT | BALANCE");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");
        accountingEntryList.forEach(accountEntry -> System.out.format("%s | %d | %d \n",simpleDateFormat.format(accountEntry.getDate()),accountEntry.getAmount(),accountEntry.getBalance()));
    }
}
