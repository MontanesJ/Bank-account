package kata;

import java.time.Clock;
import java.time.ZonedDateTime;

public class Account {

    private final OperationHistory operationHistory;
    private final Clock clock;


    public Account(Clock clock){
        this.clock = clock;
        operationHistory = new OperationHistory();
    }

    public Balance deposit(Amount amount) {
        Operation operation = Operation.builder()
                .type(OperationType.DEPOSIT)
                .amount(amount)
                .date(ZonedDateTime.now(clock)).build();
        operationHistory.addOperation(operation);
        return operationHistory.getBalance();
    }

    public Balance withdrawal(Amount amount) {
        Operation operation = Operation.builder()
                .type(OperationType.WITHDRAWAL)
                .amount(amount)
                .date(ZonedDateTime.now(clock)).build();
        operationHistory.addOperation(operation);
        return operationHistory.getBalance();
    }
}
