package kata;

import java.time.Clock;
import java.time.ZonedDateTime;

public class Account {

    private final OperationHistory operationHistory;
    private final Clock clock;
    private final StatementPrinter printer;

    public Account( Clock clock,StatementPrinter printer){
        this.clock = clock;
        this.printer = printer;
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
        if(!operationHistory.getBalance().hasEnough(amount)){
            throw new IllegalArgumentException("not enough money");
        }
        Operation operation = Operation.builder()
                .type(OperationType.WITHDRAWAL)
                .amount(amount)
                .date(ZonedDateTime.now(clock)).build();
        operationHistory.addOperation(operation);
        return operationHistory.getBalance();
    }

    public void print(){
        printer.print(operationHistory.getStatement());
    }
}
