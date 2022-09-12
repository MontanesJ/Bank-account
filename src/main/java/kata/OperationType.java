package kata;

import java.util.function.BiFunction;

public enum OperationType {

    DEPOSIT(Balance::add);

    private final BiFunction<Balance, Amount, Balance> operation;
    OperationType(BiFunction<Balance, Amount, Balance> operation) {
        this.operation = operation;
    }
    public Balance apply(Amount amount, Balance balance){
        return operation.apply(balance, amount);
    }

}
