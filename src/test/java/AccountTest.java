import kata.Account;
import kata.Amount;
import kata.Balance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class AccountTest {

    Clock fixed = Clock.fixed(Instant.now(), ZoneId.systemDefault());
    private final Amount ten = new Amount(BigDecimal.TEN);

    @Test
    public void when_we_deposit_10_whe_should_get_balance_10() {
        Account bankAccount = new Account(fixed);
        Balance expected = new Balance(BigDecimal.TEN);
        Balance result = bankAccount.deposit(ten);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void when_we_deposit_10_and_withdrawal_10_whe_should_get_balance_0() {
        Account account = new Account(fixed);
        Balance expected = new Balance(BigDecimal.ZERO);
        account.deposit(ten);
        Balance result = account.withdrawal(ten);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void we_cant_withdrawal_10_from_an_empty_account() {
        Account account = new Account(fixed);
        Assertions.assertThrows(IllegalArgumentException.class, () ->  account.withdrawal(ten));
    }
}

