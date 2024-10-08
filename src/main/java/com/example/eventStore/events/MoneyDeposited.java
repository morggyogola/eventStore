package com.example.eventStore.events;

import java.math.BigDecimal;

public class MoneyDeposited extends AccountEvent{

    BigDecimal amount;

    public MoneyDeposited(BigDecimal amount,String accountId) {
        super(accountId);
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
