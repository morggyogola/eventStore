package com.example.eventStore.services;

import com.eventstore.dbclient.AppendToStreamOptions;
import com.eventstore.dbclient.EventData;
import com.eventstore.dbclient.EventStoreDBClient;
import com.example.eventStore.events.AccountEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountService {
    private final EventStoreDBClient eventStoreDBClient;
    private final ObjectMapper objectMapper;

    public AccountService(EventStoreDBClient eventStoreDBClient, ObjectMapper objectMapper) {
        this.eventStoreDBClient = eventStoreDBClient;
        this.objectMapper = objectMapper;
    }

    private void saveEvent(String accountId, AccountEvent event) throws Exception {
        String streamName = "account-" + accountId;
        String eventData = objectMapper.writeValueAsString(event);


        EventData eventToStore = EventData.builderAsJson(UUID.randomUUID(), event.getClass().getSimpleName(), eventData)
                .build();
        eventStoreDBClient.appendToStream(streamName, AppendToStreamOptions.get(), eventToStore);
    }

}
