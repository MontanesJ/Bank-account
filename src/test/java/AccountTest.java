import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AccountTest {
    
    @Test
    public void when_we_deposit_10_whe_should_get_balance_10() {
        BankAccount bankAccount = new BankAccount();
        Balance expected = new Balance(BigDecimal.TEN);
        Balance result = bankAccount.deposit(BigDecimal.TEN);
        Assertions.assertEquals(expected, result);
    }
}

