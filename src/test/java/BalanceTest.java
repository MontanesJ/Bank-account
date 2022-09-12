import kata.Account;
import kata.Amount;
import kata.Balance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BalanceTest {

    Balance balance;
    private final Amount ten = new Amount(BigDecimal.TEN);

    @Test
    public void when_we_add_10_we_should_get_a_balance_at_10(){
        balance = new Balance(BigDecimal.ZERO);
        Balance expected = new Balance(BigDecimal.TEN);
        Balance result = balance.add(ten);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void when_we_subtract_10_from_a_balance_10_we_should_get_a_balance_at_0(){
        balance = new Balance(BigDecimal.TEN);
        Balance expected = new Balance(BigDecimal.ZERO);
        Balance result = balance.subtract(ten);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void we_have_enough_from_an_empty_balance(){
        balance = new Balance(BigDecimal.ZERO);
        boolean result = balance.hasEnough(ten);
        Assertions.assertFalse(result);

    }
}
