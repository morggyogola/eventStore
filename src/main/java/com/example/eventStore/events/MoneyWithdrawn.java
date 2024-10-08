package com.example.eventStore.events;

import java.math.BigDecimal;

public class MoneyWithdrawn extends AccountEvent{
    BigDecimal amount;

    public MoneyWithdrawn(BigDecimal amount,String accountId){
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
