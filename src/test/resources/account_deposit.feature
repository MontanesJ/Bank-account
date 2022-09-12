Feature: Account is credited with amount

  Scenario: account deposit
    Given a new account with a balance at zero
    When the account make a deposit with 10
    Then the new balance should be 10
