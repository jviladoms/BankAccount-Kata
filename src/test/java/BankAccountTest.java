import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class BankAccountTest {

    private BankAccount bankAccount;
    private File testFile;

    @Mock
    PrintStatementStrategy printStatementStrategy;

    @Before
    public void setUp() throws IOException {
        bankAccount = spy(new BankAccount(Strategy.FILE));
        testFile = new File("OutputFile.txt");
    }

    @Test
    public void basicFlowAccount(){
        bankAccount.deposit(100);
        bankAccount.withdraw(50);
        bankAccount.printStatement();

        verify(bankAccount,atLeast(2)).createAccountingEntry(anyInt());
        assertTrue(checkFileValues());
    }

    private boolean checkFileValues(){
        try{
            FileReader fr = new FileReader(testFile);
            BufferedReader br = new BufferedReader(fr);

            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                String[] splitedLine = currentLine.split("\\|");
                if (splitedLine.length != 3){
                    return false;
                }
                // Other validations
            }
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @After
    public void clean(){
        testFile.delete();
    }
}
