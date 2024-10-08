package com.example.eventStore.events;

import java.time.Instant;

public abstract class AccountEvent {
    private String accountId;
    private Instant occurredAt;

    public AccountEvent(String accountId) {
        this.accountId = accountId;
        this.occurredAt = Instant.now();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Instant getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(Instant occurredAt) {
        this.occurredAt = occurredAt;
    }
}
