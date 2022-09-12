package feature;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kata.Account;
import kata.Amount;
import kata.Balance;
import kata.StatementPrinterFake;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class AccountTestDef {

    Account account;
    Clock fixed = Clock.fixed(Instant.now(), ZoneId.systemDefault());

    Balance result;
    @Given("a new account with a balance at zero")
    public void aNewAccount() {
        account = new Account(fixed, new StatementPrinterFake());
    }
    @When("the account make a deposit with {bigdecimal}")
    public void the_account_is_deposit_with(BigDecimal bigDecimal) {
        Amount amount = new Amount(bigDecimal);
        result = account.deposit(amount);
    }

    @When("the account make a withdrawal with {bigdecimal}")
    public void theAccountIsWithdrawalWith(BigDecimal bigDecimal) {
        Amount amount = new Amount(bigDecimal);
        result = account.withdrawal(amount);
    }

    @Then("the new balance should be 10")
    public void operationShouldSucceed() {
        Balance expected = new Balance(BigDecimal.TEN);
        Assertions.assertEquals(expected,result);
    }
}
