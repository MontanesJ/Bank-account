package kata;

import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Builder
@Getter
public class Statement {
    private OperationType type;
    private ZonedDateTime date;
    private Amount amount;
    private Balance balance;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Statement)) {
            return false;
        }
        Statement toCompare = (Statement) obj;
        return type == toCompare.type && amount.equals(toCompare.amount) && balance.equals(toCompare.balance) && date.equals(toCompare.date);
    }
}
