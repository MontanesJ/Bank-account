package kata;

import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Builder
@Getter
public class Operation {
    private OperationType type;
    private ZonedDateTime date;
    private Amount amount;

    public Balance calcBalance(Balance balance){
        return type.apply(amount, balance);
    }

}
