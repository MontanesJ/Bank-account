package kata;

import java.math.BigDecimal;

public class Balance {

    private final BigDecimal balance;

    public Balance add(Amount amount){
        return new Balance(balance.add(amount.getValue()));
    }

    public Balance subtract(Amount amount){
        return new Balance(balance.subtract(amount.getValue()));
    }

    public Balance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Balance)) {
            return false;
        }
        Balance toCompare = (Balance) obj;
        return balance.compareTo(toCompare.balance) == 0;
    }
}
