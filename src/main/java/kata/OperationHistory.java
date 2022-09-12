package kata;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OperationHistory {

    private final List<Operation> operations;

    public OperationHistory(){
        operations = new ArrayList<>();
    }

    public boolean addOperation(Operation operation){
        return operations.add(operation);
    }

    public Balance getBalance(){
        Balance balance = new Balance(BigDecimal.ZERO);
        for(Operation operation : operations){
            balance = operation.calcBalance(balance);
        }
        return balance;
    }

}
