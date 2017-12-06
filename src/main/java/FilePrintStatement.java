import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class FilePrintStatement implements  PrintStatement{

    File file = new File("OutputFile.txt");

    @Override
    public void print(List<AccountingEntry> accountingEntryList){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");

        try {

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("DATE | AMOUNT | BALANCE \n");

            accountingEntryList.forEach(accountEntry -> {
                try {
                    bw.write(String.format("%s | %d | %d \n", simpleDateFormat.format(accountEntry.getDate()), accountEntry.getAmount(), accountEntry.getBalance()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
