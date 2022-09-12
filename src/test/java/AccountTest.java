import kata.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class AccountTest {

    private Account account;
    Clock fixed = Clock.fixed(Instant.now(), ZoneId.systemDefault());
    private final Amount ten = new Amount(BigDecimal.TEN);
    private final StatementPrinterFake printer = new StatementPrinterFake();
    private final ZonedDateTime date = ZonedDateTime.now(fixed);

    @BeforeEach
    void init_BankAccount(){
        account = new Account(fixed,printer);
    }

    @Test
    public void when_we_deposit_10_whe_should_get_balance_10() {
        Balance expected = new Balance(BigDecimal.TEN);
        Balance result = account.deposit(ten);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void when_we_deposit_10_and_withdrawal_10_whe_should_get_balance_0() {
        Balance expected = new Balance(BigDecimal.ZERO);
        account.deposit(ten);
        Balance result = account.withdrawal(ten);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void we_cant_withdrawal_10_from_an_empty_account() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  account.withdrawal(ten));
    }

    @Test
    public void when_we_deposit_10_whe_should_get_1_statement_at_print() {
        Statement expect = Statement.builder()
                .type(OperationType.DEPOSIT)
                .date(date)
                .amount(ten)
                .balance(new Balance(BigDecimal.TEN))
                .build();
        account.deposit(ten);
        account.print();
        List<Statement> statementList = printer.getStatements();
        Assertions.assertEquals(expect, statementList.get(0));
    }
}

