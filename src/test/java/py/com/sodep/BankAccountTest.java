package py.com.sodep;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {

    @Test
    public void testDebitWithEnoughBalance() {
        BankAccount account = new BankAccount(10.0);
        double amount = account.debit(5.0);
        Assert.assertEquals(5.0, account.getBalance());
    }
}