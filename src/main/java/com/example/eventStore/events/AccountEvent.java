package com.example.eventStore.events;

import java.time.Instant;

public abstract class AccountEvent {
    String accountid;
    Instant occurredAt;

    public AccountEvent(String accountid, Instant occurredAt) {
        this.accountid = accountid;
        this.occurredAt = occurredAt;
    }


    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public Instant getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(Instant occurredAt) {
        this.occurredAt = occurredAt;
    }
}
