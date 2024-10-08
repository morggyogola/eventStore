package com.example.eventStore.services;

import com.eventstore.dbclient.AppendToStreamOptions;
import com.eventstore.dbclient.EventData;
import com.eventstore.dbclient.EventStoreDBClient;
import com.example.eventStore.events.AccountEvent;
import com.example.eventStore.events.MoneyDeposited;
import com.example.eventStore.events.MoneyWithdrawn;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class AccountService {
    private final EventStoreDBClient eventStoreDBClient;
    private final ObjectMapper objectMapper;

    public AccountService(EventStoreDBClient eventStoreDBClient, ObjectMapper objectMapper) {
        this.eventStoreDBClient = eventStoreDBClient;
        this.objectMapper = objectMapper;
    }

    public  void deposit(String accountId, BigDecimal amount) throws Exception{
        AccountEvent event = new MoneyDeposited(amount,accountId);
        saveEvent(accountId,event);
    }

    public  void withdraw(String accountId, BigDecimal amount) throws Exception{
        AccountEvent event = new MoneyWithdrawn(amount,accountId);
        saveEvent(accountId, event);
    }

    private void saveEvent(String accountId, AccountEvent event) throws Exception {
        String streamName = "account-" + accountId;
        String eventData = objectMapper.writeValueAsString(event);


        EventData eventToStore = EventData.builderAsJson(UUID.randomUUID(), event.getClass().getSimpleName(), eventData)
                .build();
        eventStoreDBClient.appendToStream(streamName, AppendToStreamOptions.get(), eventToStore);
    }

}
