package kata;

import java.math.BigDecimal;

public class Amount {

    private final BigDecimal amount;

    public Amount(BigDecimal amount){
        if(amount.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Amount must be positif");
        }
        this.amount = amount;
    }

    public BigDecimal getValue(){
        return amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Amount)) {
            return false;
        }
        Amount toCompare = (Amount) obj;
        return amount.compareTo(toCompare.amount) == 0;
    }
}
